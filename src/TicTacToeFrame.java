import javax.swing.*;
import java.awt.*;
public class TicTacToeFrame extends JFrame implements TicTacToeView{

    private JButton[][] buttons;
    public TicTacToeFrame() {
        super ("Tic Tac Toe");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(TicTacToe.SIZE, TicTacToe.SIZE));

        TicTacToe model = new TicTacToe();

        model.addTicTacToeView(this);

        buttons = new JButton[TicTacToe.SIZE][TicTacToe.SIZE];

        TicTacToeController tttc = new TicTacToeController(model);

        for (int i=0; i < TicTacToe.SIZE; i++) {
            for (int j=0; j < TicTacToe.SIZE; j++) {
                JButton b = new JButton(" ");
                b.setActionCommand(i + " " + j);
                buttons[i][j] = b;
                b.addActionListener(tttc);
                this.add(b);
            }
        }
        this.setVisible(true);
    }
    @Override
    public void update(TicTacToe ticTacToe, int x, int y, boolean turn, TicTacToe.Status status) {
        String label = turn? "X": "0";
        buttons[x][y].setText(label);
    }
    public static void main(String args[]) {
        new TicTacToeFrame();
    }
}
