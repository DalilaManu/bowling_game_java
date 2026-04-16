
# Bowling Game Kata 


Proyecto desarrollado por **Dalila y Yolanda** como parte de una práctica académica para aprender Java, Maven y principios de diseño orientado a objetos.


##  Descripción del proyecto  
Este proyecto es una **refactorización a Java** del *Bowling Game Kata*, originalmente implementado en Python. El objetivo principal es aplicar **TDD (Test Driven Development)** y mejorar la estructura del código utilizando conceptos de **Domain Driven Design** y **autómatas finitos** para modelar el dominio del juego de bolos.

El programa recibe una cadena con la secuencia completa de tiradas de una partida de bolos y calcula la **puntuación total** siguiendo las reglas del *American Ten-Pin Bowling*.

---

##  Reglas resumidas del juego  
- Una partida tiene **10 frames**.  
- Cada frame tiene **hasta dos tiradas**, excepto el último si hay spare o strike.  
- **Spare (/)** → 10 puntos + los bolos del siguiente lanzamiento.  
- **Strike (X)** → 10 puntos + los bolos de las dos siguientes tiradas.  
- **-** significa 0 bolos.  
- No se validan errores ni número de tiradas: se asume que el input es correcto.

---

## Enfoque de diseño  
Para estructurar la lógica utilicé un **autómata finito**, porque el juego avanza como una secuencia de estados bien definidos:

- Estado de tirada normal  
- Estado de spare  
- Estado de strike  
- Estado de tiradas extra del último frame  

Cada transición del autómata calcula parte de la puntuación mediante una función de salida (modelo tipo *Mealy Machine*).  
Esto permite separar claramente:

- la lectura de símbolos del marcador  
- la lógica de puntuación  
- la transición entre estados  

---

##  Refactorización a Java  
La refactorización consistió en:

1. **Reescribir la lógica original en clases Java**, con tipos fuertes y responsabilidades claras.  
2. Crear dos componentes principales:
   - `ScoreCard`: interpreta la cadena de entrada.
   - `Automaton`: gestiona los estados y calcula la puntuación.
3. Mejorar la legibilidad y la mantenibilidad del código.
4. Documentar el comportamiento de cada estado del autómata.

---

##  TDD (Test Driven Development)  
El desarrollo siguió el ciclo clásico de TDD:

1. **Escribir un test sencillo** (sin strikes ni spares).  
2. Añadir casos con spare.  
3. Añadir casos con strike.  
4. Añadir casos del décimo frame.  
5. Refactorizar manteniendo todos los tests en verde.

La cobertura se ejecuta con:

```
coverage run -m pytest
coverage report -m
```

Este enfoque garantiza un diseño **incremental**, **orgánico** y fácil de defender en examen.

---

## Resultado  
El proyecto final es una implementación en Java:

- clara  
- modular  
- basada en estados  
- completamente testeada con TDD  
- y fiel a las reglas del Bowling Game Kata  

