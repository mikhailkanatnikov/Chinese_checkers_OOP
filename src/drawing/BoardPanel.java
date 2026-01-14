package drawing;

import logic.Board;
import logic.Checker;
import logic.PlayerColor;
import logic.Point;

import javax.swing.*;
import java.awt.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static logic.Point.specialPoints;

public class BoardPanel extends JPanel {

    public int BOARD_HEIGHT_WIDTH = 400;

    public Board board;

    public Integer selectedX = null;
    public Integer selectedY = null;
    private final JLabel statusLabel;


    public BoardPanel(Board board) {
        this.board = board;
        setLayout(new BorderLayout());

        //мышь

        addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                // Обработка кликов

                int x = e.getX();
                int y = e.getY();

                int clickedBoardX = (x - 85) / 50;
                int clickedBoardY = (y - 70) / 50;

                if (clickedBoardX < 0 || clickedBoardX > 7 || clickedBoardY < 0 || clickedBoardY > 7) {
                    return;
                }

                if (selectedX == null) {
                    // Выбор шашки
                    if (!board.isSquareEmpty(clickedBoardX, clickedBoardY) &&
                            board.getCheckerAt(clickedBoardX, clickedBoardY).getCheckerColor() == board.currentPlayer) {
                        selectedX = clickedBoardX;
                        selectedY = clickedBoardY;
                        repaint();
                    }
                } else {
                    // Ход
                    try {
                        board.makeMove(selectedX, selectedY, clickedBoardX, clickedBoardY);
                        if (board.currentPlayer == PlayerColor.WHITE) {
                            statusLabel.setText("Ходят белые");
                        } else {
                            statusLabel.setText("Ходят чёрные");
                        }

                        // ПРОВЕРКА ПОБЕДЫ
                        if (board.checkWin(PlayerColor.WHITE)) {
                            statusLabel.setText("Белые победили!");
                        }
                        if (board.checkWin(PlayerColor.BLACK)) {
                            statusLabel.setText("Чёрные победили!");
                        }

                        selectedX = null;
                        selectedY = null;
                        repaint();
                    } catch (IllegalArgumentException ex) {
                        selectedX = null;
                        selectedY = null;
                        repaint();
                    }
                }
            }
        });


        statusLabel = new JLabel("Ходят белые", SwingConstants.CENTER);
        add(statusLabel, BorderLayout.SOUTH); // ← добавить эту строку
    }


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

                g2d.drawRect(85 + 50 * i, 70 + 50 * j, 50, 50);




                if ((i + j) % 2 == 0) {

                    g2d.setColor(new Color(217, 185, 167)); //белые
                    g2d.fillRect(85 + 50 * i, 70 + 50 * j, 50, 50);
                    // После g2d.fillRect(...);
                    if (selectedX != null && i == selectedX && j == selectedY) {
                        g2d.setColor(new Color(255, 255, 0, 100));
                        g2d.fillRect(85 + 50 * i, 70 + 50 * j, 50, 50);
                    }


                } else {

                    g2d.setColor(new Color(92, 76, 67)); //коричневые
                    g2d.fillRect(85 + 50 * i, 70 + 50 * j, 50, 50);
                    // После g2d.fillRect(...);
                    if (selectedX != null && i == selectedX && j == selectedY) {
                        g2d.setColor(new Color(255, 255, 0, 100));
                        g2d.fillRect(85 + 50 * i, 70 + 50 * j, 50, 50);
                    }
                }

            }
        }

        //особые клетки
        for(Point p: specialPoints){
                g2d.setStroke(new BasicStroke(5));
                g2d.setColor(Color.BLACK);
                g2d.drawRect(85 + 50 * p.x, 70 + 50 * p.y, 50, 50);


        }
        g2d.setStroke(new BasicStroke(1));



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
