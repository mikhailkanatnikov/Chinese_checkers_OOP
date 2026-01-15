package drawing;


import javax.swing.*;
import java.awt.*;

public class startMenu {
    public static void main(String[] args) {

        JFrame menuWindow = new JFrame("Chinese Checkers (Михаил Канатников)");
        menuWindow.setSize(800, 600);

        JButton startButton = new JButton("Начать игру");
        startButton.setBackground(new Color(205, 20, 222));

        JLabel rulesText = new JLabel();
        rulesText.setText("<html><h1 style= 'text-align: center;'>Chinese Checkers</h1>\n" +
                "<h2 style= 'text-align: center;'>Данный проект - реализация упрощенной версии игры Китайские шашки на языке Java с использованием Swing.</h2>\n" +
                "<h2 style= 'text-align: center;'>Правила:</h2>\n" +
                "\n" +
                "<h3 style= 'text-align: center;'>Цель игрока белыми шашками перегнать все свои шашки в противоположный угол доски на выделенные квадраты. Цель игрока черными шашками аналогична. <h3>\n" +
                "<h2 style= 'text-align: center;'>Ходы:<h2>\n" +
                "<h3 style= 'text-align: center;'>Можно передвигаться по диагонали в любом направлении + разрешено перепрыгивать через шашку соперника так же по диагонали в любом направлении. Бить нельзя.<h3>\n" +
                "<h3 style= 'text-align: center;'>Победителем считается игрок, первым перегнавший все свои шашки на противоположный угол доски.<h3>\n </html>");

        startButton.addActionListener(e -> {
                    menuWindow.dispose(); //закрыть меню
                    new GameWindow().start();
                }
        );
        menuWindow.setLayout(new BorderLayout());
        menuWindow.add(rulesText,BorderLayout.CENTER);
        menuWindow.add(startButton,BorderLayout.SOUTH);

        menuWindow.setVisible(true);
    }
}
