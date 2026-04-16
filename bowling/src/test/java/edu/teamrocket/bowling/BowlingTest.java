package edu.teamrocket.bowling;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class BowlingTest {
    private Automaton automaton;
    private String pins;
    private int expectedScore;
    
    public BowlingTest(String pins, int expectedScore) {
        this.pins = pins;
        this.expectedScore = expectedScore;
    }
    
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
            // state_n cases
            { "12345123451234512345", 60 },
            { "9-9-9-9-9-9-9-9-9-9-", 90 },
            { "9-3561368153258-7181", 82 },
            
            // spare cases
            { "9-3/613/815/-/8-7/8-", 121 },
            
            // strike cases
            { "X9-9-9-9-9-9-9-9-9-", 100 },
            { "X9-X9-9-9-9-9-9-9-", 110 },
            { "XX9-9-9-9-9-9-9-9-", 120 },
            { "XXX9-9-9-9-9-9-9-", 141 },
            
            // extra_rolls cases
            { "9-3/613/815/-/8-7/8/8", 131 },
            { "5/5/5/5/5/5/5/5/5/5/5", 150 },
            { "9-9-9-9-9-9-9-9-9-XXX", 111 },
            { "8/549-XX5/53639/9/X", 149 },
            { "X5/X5/XX5/--5/X5/", 175 },
            { "XXXXXXXXXXXX", 300 },
        });
    }
    
    @Before
    public void setUp() {
        this.automaton = new Automaton();
    }
    
    @Test
    public void testScoreCases() {
        ScoreCard scoreCard = new ScoreCard(pins);
        automaton.setInput(scoreCard);
        assertEquals(expectedScore, automaton.output());
    }
}
