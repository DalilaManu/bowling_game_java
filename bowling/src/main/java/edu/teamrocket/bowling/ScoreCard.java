package edu.teamrocket.bowling;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScoreCard {
    private static final Map<Character, Integer> VALUES = new HashMap<>();
    static {
        VALUES.put('-', 0);
        VALUES.put('1', 1);
        VALUES.put('2', 2);
        VALUES.put('3', 3);
        VALUES.put('4', 4);
        VALUES.put('5', 5);
        VALUES.put('6', 6);
        VALUES.put('7', 7);
        VALUES.put('8', 8);
        VALUES.put('9', 9);
        VALUES.put('X', 10);
    }

    private String rolls;
    private List<Integer> rollValues;

    public ScoreCard(String rolls) {
        this.rolls = rolls;
        this.rollValues = expandRolls();
    }

    private List<Integer> expandRolls() {
        List<Integer> values = new ArrayList<>();
        int prev = 0;

        for (char r : rolls.toCharArray()) {
            if (r == 'X') {
                values.add(10);
                prev = 10;
            } else if (r == '/') {
                int spareVal = 10 - prev;
                values.add(spareVal);
                prev = spareVal;
            } else {
                int v = VALUES.get(r);
                values.add(v);
                prev = v;
            }
        }

        return values;
    }

    public int score() {
        int total = 0;
        int rollIndex = 0;

        for (int frame = 0; frame < 10; frame++) {
            if (rolls.charAt(rollIndex) == 'X') {
                // Strike
                total += 10 + rollValues.get(rollIndex + 1) + rollValues.get(rollIndex + 2);
                rollIndex++;
            } else if (rolls.charAt(rollIndex + 1) == '/') {
                // Spare
                total += 10 + rollValues.get(rollIndex + 2);
                rollIndex += 2;
            } else {
                // Open frame
                total += rollValues.get(rollIndex) + rollValues.get(rollIndex + 1);
                rollIndex += 2;
            }
        }

        return total;
    }
}

  