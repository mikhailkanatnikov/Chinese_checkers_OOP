package drawing;
import logic.*;
import javax.swing.*;
import java.awt.*;


public class GameWindow {

    public void start() {

        JFrame frame = new JFrame("Chinese checkers");

        frame.setSize(600,600);

        Board board = new Board();
        BoardPanel panel = new BoardPanel(board);
        frame.add(panel);
        frame.setVisible(true);






    }
}
