package edu.teamrocket.bowling;

public class App {
    public static void main(String[] args) {
        System.out.println("Bowling Game - Scoring System");
        
        // Ejemplo de uso
        ScoreCard scoreCard = new ScoreCard("XXXXXXXXXXXX");
        Automaton automaton = new Automaton();
        automaton.setInput(scoreCard);
        
        int score = automaton.output();
        System.out.println("Juego perfecto (12 strikes): " + score + " puntos");
    }
}
