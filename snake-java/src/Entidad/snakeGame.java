/*
 */
package Entidad;

import java.awt.Image;
import javax.swing.JPanel;
import javax.swing.Timer;

public class snakeGame extends JPanel {

    //window zise
    private int L_HEIGHT = 500;
    private int L_WIDTH = 500;

    private int DOR_ZISE = 10;
    private int ALL_DOTS = 500;

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
    }

}
