package edu.teamrocket.bowling;

public class Automaton {
    private ScoreCard input;

    public Automaton() {
        this.input = null;
    }

    public void setInput(ScoreCard scoreCard) {
        this.input = scoreCard;
    }

    public int output() {
        if (input == null) {
            return 0;
        }
        return input.score();
    }
}