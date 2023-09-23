package Main;

import javax.swing.JFrame;

import Entidad.snakeGame;

public class snakeMain extends JFrame {

    public snakeMain() {

        initUI();
    }

    private void initUI() {

        add(new snakeGame());

        setResizable(false);
        pack();

        setTitle("Snake");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        java.awt.EventQueue.invokeLater(() -> {
            JFrame ex = new snakeMain();
            ex.setVisible(true);
        });
    }
}
