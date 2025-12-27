package drawing;

import logic.Board;
import logic.Checker;
import logic.PlayerColor;

import javax.swing.*;
import java.awt.*;

public class BoardPanel extends JPanel {

    public Board board;

    public BoardPanel(Board board) {
        this.board = board;
    }

    public int BOARD_HEIGHT_WIDTH = 400;
    public int CELL_AMOUNT = 49;


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawBoard(g);
        drawCheckers(g);

    }

    private void drawBoard(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        //сам квадрат
        g2d.setColor(Color.BLACK);
        g2d.drawRect(85, 70, BOARD_HEIGHT_WIDTH, BOARD_HEIGHT_WIDTH);

        //клетки
        g2d.setColor(Color.black);
        for (int i = 0; i <= 7; i += 1) {
            for (int j = 0; j <= 7; j += 1) {

                if ((i + j) % 2 == 0) {
                    g2d.drawRect(85 + 50 * i, 70 + 50 * j, 50, 50);

                    g2d.setColor(new Color(217, 185, 167)); //белые
                    g2d.fillRect(85 + 50 * i, 70 + 50 * j, 50, 50);
                } else {
                    g2d.drawRect(85 + 50 * i, 70 + 50 * j, 50, 50);
                    g2d.setColor(new Color(92, 76, 67)); //коричневые
                    g2d.fillRect(85 + 50 * i, 70 + 50 * j, 50, 50);
                }


            }
        }

    }

    private void drawCheckers(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j <= 7; j++) {
                if (!board.isSquareEmpty(i, j)) {
                    Checker checker = board.getCheckerAt(i, j); //получаем шашку в конкретной клетке
                    //определяемся с цветом
                    if (checker.getCheckerColor() == PlayerColor.BLACK) {
                        g2d.setColor(Color.BLACK);
                    } else {
                        g2d.setColor(Color.WHITE);
                    }


                    g2d.fillOval(90 + 50 * i, 75 + 50 * j, 40, 40);

                    g2d.setColor(Color.BLACK);
                    g2d.drawOval(90 + 50 * i, 75 + 50 * j, 40, 40);
                }


                }
            }


        }
    }
