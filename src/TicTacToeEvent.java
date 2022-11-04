import java.util.EventObject;

public class TicTacToeEvent extends EventObject { // extend from event object because Source from getSource is an EventObject
    private final boolean turn;
    private final TicTacToe.Status status;
    private int x;
    private int y;


    public TicTacToeEvent(TicTacToe ticTacToeModel, int x, int y, boolean turn, TicTacToe.Status status) {
        super(ticTacToeModel); // ticTacToeModel is the Source
    this.x = x;
    this.y = y;
    this.turn = turn;
    this.status = status;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isTurn() {
        return turn;
    }

    public TicTacToe.Status getStatus() {
        return status;
    }

}
