/*
 */
package Entidad;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import javax.swing.JPanel;
import javax.swing.Timer;

public class snakeGame extends JPanel implements ActionListener {

    //window zise
    private final int L_HEIGHT = 500;
    private final int L_WIDTH = 500;

    private int DOR_ZISE = 10;
    private int ALL_DOTS = 900;

    private int DELAY = 50;

    //time advance
    Timer timer;

    //image
    Image apple;
    Image head;
    Image body;

    //long on snake
    private int x[] = new int[ALL_DOTS];
    private int y[] = new int[ALL_DOTS];

    //apple position
    private int appleX;
    private int appleY;

    //direction of snake
    private boolean d_left;
    private boolean d_rigth;
    private boolean d_up;
    private boolean d_down;

    public snakeGame() {
        initBoard();
    }

    public void initBoard() {
        addKeyListener(new TAdapter());
        setBackground(Color.black);
        setFocusable(true);

        setPreferredSize(new Dimension(L_WIDTH, L_HEIGHT));
    }

    //asigna el lado para donde se movera la serpiente en su primer movimiento (random)
    public void assignSide() {
        d_left = true;
        d_rigth = false;
        d_up = false;
        d_down = false;
    }

    public void guardarImagenes() {
    }

    public void randomApple() {
    }

    public void movimiento() {
    }

    public void colicion() {

    }

    private class TAdapter extends KeyAdapter {

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
