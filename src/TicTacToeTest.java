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

    @Test
    public void testOWon() {
        TicTacToe ttt = new TicTacToe();
        ttt.play(0, 0);
        ttt.play(1, 0);
        ttt.play(0, 1);
        ttt.play(1, 1);
        ttt.play(2, 2);
        ttt.play(1, 2);
        assertEquals(TicTacToe.Status.O_WON, ttt.getStatus());
    }
    @Test
    public void testRowWin() {
        TicTacToe ttt = new TicTacToe();
        ttt.play(0,0);
        ttt.play(1,0);

        ttt.play(0,1);
        ttt.play(1,1);

        ttt.play(0,2);

        assertEquals(TicTacToe.Status.X_WON, ttt.getStatus());
    }

    @Test
    public void testColWin() {
        TicTacToe ttt = new TicTacToe();
        ttt.play(0,0);
        ttt.play(0,1);

        ttt.play(1,0);
        ttt.play(1,1);

        ttt.play(2,0);

        assertEquals(TicTacToe.Status.X_WON, ttt.getStatus());
    }
    @Test
    public void testDiagWin() {
        TicTacToe ttt = new TicTacToe();
        ttt.play(0,0);
        ttt.play(1,0);

        ttt.play(1,1);
        ttt.play(2,1);

        ttt.play(2,2);

        assertEquals(TicTacToe.Status.X_WON, ttt.getStatus());
    }
    @Test
    public void testaDiagWin() {
        TicTacToe ttt = new TicTacToe();
        ttt.play(0,2);
        ttt.play(1,2);

        ttt.play(1,1);
        ttt.play(2,1);

        ttt.play(2,0);

        assertEquals(TicTacToe.Status.X_WON, ttt.getStatus());
    }
    public void testTie() {
        TicTacToe ttt = new TicTacToe();
        ttt.play(0,0);
        ttt.play(1,1);

        ttt.play(2,0);
        ttt.play(1,0);

        ttt.play(1,2);
        ttt.play(2,1);

        ttt.play(2,2);
        ttt.play(0,2);

        ttt.play(0,1);

        assertEquals(TicTacToe.Status.TIE, ttt.getStatus());
    }
}