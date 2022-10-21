import java.util.*;

//TicTacToeModel
public class TicTacToe {


    public static final int SIZE = 3;
    public static final boolean X = true;
    public static final boolean O = false;

    public enum Status {X_WON, O_WON, TIE, UNDECIDED};

    private char[][] grid;
    private boolean turn;
    private Status status;

    private List<TicTacToeView> views;

    public TicTacToe() {
        grid = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                grid[i][j] = ' ';
            }
        }
        turn = X;
        status = Status.UNDECIDED;
        views = new ArrayList<>();

    }

    public void addTicTacToeView(TicTacToeView v) {
        views.add(v);
    }


    private void changeTurn() {
        turn = !turn;
    }

    public Status getStatus() {return status;}

    private void updateStatus() {
        return; //TODO
    }

    public boolean getTurn() {return turn;}

    public void play(int x, int y) {
        if (grid[x][y] != ' ') return;
        grid[x][y] = turn? 'X' : 'O';
        updateStatus();

        for (TicTacToeView v: views) { v.update(this, x, y, turn, status);}

        changeTurn();
    }
}

