package drawing;
import logic.*;
import javax.swing.*;
import java.awt.*;


public class GameWindow {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Chinese checkers");
        frame.setSize(600,600);

        BoardPanel panel = new BoardPanel();

        frame.add(panel);

        frame.setVisible(true);




    }
}
