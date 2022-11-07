import java.util.*;

//TicTacToeModel
//model should not know how many views there are so make a list
public class TicTacToe {


    public static final int SIZE = 3;
    public static final boolean X = true;
    public static final boolean O = false;

    public enum Status {X_WON, O_WON, TIE, UNDECIDED};

    private char[][] grid;
    private boolean turn;
    private Status status;

    private List<TicTacToeView> views; //list of views

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

    private void updateStatus(int x, int y) {
        {
            int col = 0;
            int row = 0;
            int diag = 0;
            int adiag = 0;
            int isFull = 0;


            // Check row
            for (int i = 0; i < SIZE - 1; i++) {
                if (grid[x][i] != ' ' && grid[x][i] == grid[x][i + 1]) {
                    row++;
                }
            }
            // Check col
            for (int i = 0; i < SIZE - 1; i++) {
                if (grid[i][y] != ' ' && grid[i][y] == grid[i + 1][y]) {
                    col++;
                }
            }

            //check diag
            if (x == y) {
                for (int i = 0; i < SIZE - 1; i++) {
                    if (grid[i][i] != ' ' && grid[i][i] == grid[i + 1][i + 1]) {
                        diag++;
                    }
                }
            }

            //check adiag
            if (x + y == SIZE - 1) {
                for (int i = 0; i < SIZE - 1; i++) {
                    if (grid[i][SIZE - 1 - i] != ' ' && grid[i][SIZE - 1 - i] == grid[i + 1][SIZE - 2 - i]) {
                        adiag++;
                    }
                }
            }

            // check full
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (grid[i][j] != ' ') {
                        isFull++;
                    }
                }
            }
            int win = SIZE - 1;

            if (win == adiag || win == diag || win == row || win == col) {
                status = turn ? Status.X_WON : Status.O_WON;
            }

            if (isFull == SIZE * SIZE) {
                status = Status.TIE;
            }
        }
    }

    public boolean getTurn() {return turn;}

    public void play(int x, int y) { //change in state of the game
        if (grid[x][y] != ' ') return;
        grid[x][y] = turn? 'X' : 'O';
        updateStatus(x,y);

        for (TicTacToeView v: views) { v.update(new TicTacToeEvent(this, x, y, turn, status));} // its a model because it notifies the view

        changeTurn();
    }
}

