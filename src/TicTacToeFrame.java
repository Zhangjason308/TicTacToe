import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TicTacToeFrame extends JFrame implements TicTacToeView{

    private JButton[][] buttons;
    public TicTacToeFrame() {
        super ("Tic Tac Toe");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(TicTacToe.SIZE, TicTacToe.SIZE));

        TicTacToe model = new TicTacToe();

        model.addTicTacToeView(this);

        buttons = new JButton[TicTacToe.SIZE][TicTacToe.SIZE];

        // TicTacToeController tttc = new TicTacToeController(model); this line can be deleted

        for (int i=0; i < TicTacToe.SIZE; i++) {
            for (int j=0; j < TicTacToe.SIZE; j++) {
                JButton b = new JButton(" ");
               // b.setActionCommand(i + " " + j); //encoding a message within the button, THIS LINE CAN BE DELETED
                buttons[i][j] = b;
                int x = i; //set the variables coordinates to x and y so it is compatible with the lambda because it is final
                int y = j;
                b.addActionListener(e -> model.play(x,y)); //interface with one method is a functional interface because it can conveniently be replaced by a lambda function
                this.add(b);                // Dont need to input java.awt.event.ActionEvent because it already knows
            }
            //This is effective because its a one-liner. Otherwise in more complicated code, the lambda would be ineffective
            //When you have multiple controllers or long code for controllers, then lambdas are ineffective
            //Clean code but lack of cohesion
            //When code gets more complicated, providing input from mouse and keyboard,
            //Usually good to start of with lambdas.
        }
        this.setVisible(true);
    }
    @Override
    public void update(TicTacToeEvent e) {
        String label = e.isTurn()? "X": "0";
        buttons[e.getX()][e.getY()].setText(label);
    }
    public static void main(String args[]) {
        new TicTacToeFrame();
    }
}
