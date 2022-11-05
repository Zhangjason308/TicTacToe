import org.testng.annotations.Test;

import static org.junit.Assert.*;

public class TicTacToeTest {

    @Test
    public void initialStatusMustBeUndecided() {
        TicTacToe ttt = new TicTacToe();
        assertEquals(TicTacToe.Status.UNDECIDED,ttt.getStatus());
    }

    @Test
    public void testXWon() {
        TicTacToe ttt = new TicTacToe();
        ttt.play(0,0);
        ttt.play(1,0);
        ttt.play(0,1);
        ttt.play(2,0);
        ttt.play(0,2);
        assertEquals(TicTacToe.Status.X_WON,ttt.getStatus());
    }
}