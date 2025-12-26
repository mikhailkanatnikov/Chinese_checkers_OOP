package drawing;

import javax.swing.*;
import java.awt.*;

public class BoardPanel extends JPanel {

    public int BOARD_HEIGHT_WIDTH = 400;
    public int CELL_AMOUNT = 49;


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawBoard(g);

    }

    private void drawBoard(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        //сам квадрат
        g2d.setColor(Color.BLACK);
        g2d.drawRect(85, 70, 400, 400);

        //квадратики
        g2d.setColor(Color.black);
        for (int x = 85; x <= 435; x += 50) {
            for (int y = 70; y <= 420; y += 50) {

                if ((x / 50 + y / 50) % 2 == 0) {
                    g2d.drawRect(x, y, 50, 50);
                    g2d.setColor(new Color(217, 185, 167)); //белые
                    g2d.fillRect(x, y, 50, 50);
                } else {
                    g2d.drawRect(x, y, 50, 50);
                    g2d.setColor(new Color(38, 28, 22)); //коричневые
                    g2d.fillRect(x, y, 50, 50);
                }


            }
        }


    }

    private void drawCheckers(Graphics g) {

    }
}
