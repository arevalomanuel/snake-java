/*
 */
package Entidad;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class snakeGame extends JPanel implements ActionListener {

    //window zise
    private final int L_HEIGHT = 500;
    private final int L_WIDTH = 500;

    private int dots;
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
    private int snakeX[] = new int[ALL_DOTS];
    private int snakeY[] = new int[ALL_DOTS];

    //apple position
    private int appleX;
    private int appleY;

    //direction of snake
    private boolean d_left;
    private boolean d_rigth;
    private boolean d_up;
    private boolean d_down;

    //si esta activo el juego
    private boolean inGame = true;

    public snakeGame() {
        initBoard();
    }

    public void initBoard() {
        addKeyListener(new TAdapter());
        setBackground(Color.black);
        setFocusable(true);

        setPreferredSize(new Dimension(L_WIDTH, L_HEIGHT));

        guardarImagenes();
        assignSide() ;
        initGame();
    }

    public void guardarImagenes() {
        ImageIcon iid = new ImageIcon("src/main/java/Img/greenBody.png");
        body = iid.getImage();
        
//         ImageIcon iid = new ImageIcon("src/main/java/Img/greenBody.png");
//       apple = iid.getImage();
      
//         ImageIcon iid = new ImageIcon("src/main/java/Img/greenBody.png");
//        head = iid.getImage();
    
    }
    
    public void initGame(){
        dots = 3;
        
         for (int i = 0; i < dots; i++) {
            snakeX[i] = 50 - i * 10;
            snakeY[i] = 50;
        }
        
        timer = new Timer(DELAY, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawing(g);
    }

    private void doDrawing(Graphics g) {
        if (inGame) {
            g.drawImage(body, snakeX[0], snakeY[0], this);
        }
       
         Toolkit.getDefaultToolkit().sync();
    }

    //asigna el lado para donde se movera la serpiente en su primer movimiento (random)
    public void assignSide() {
        d_left = true;
        d_rigth = false;
        d_up = false;
        d_down = false;
    }

    public void randomApple() {
    }

    public void movimiento() {
        if (d_left) {
            d_rigth = false;
            d_up = false;
            d_down = false;
        }
        if (d_rigth) {
            d_left = false;
            d_up = false;
            d_down = false;
        }
        if (d_up) {
            d_left = false;
            d_rigth = false;
            d_down = false;
        }
        if (d_down) {
            d_left = false;
            d_rigth = false;
            d_up = false;
        }
    }

    public void colicion() {

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (inGame) {
            movimiento();
        }

        repaint();
    }

    private class TAdapter extends KeyAdapter {

        public void KeyPresset(KeyEvent e) {
            int key = e.getKeyCode();

            if ((key == KeyEvent.VK_D) && (!d_left)) {
                snakeX[0]+=10;
                d_rigth = false;
                d_up = false;
                d_down = false;
            }
            if ((key == KeyEvent.VK_A) && (!d_rigth)) {
                d_left = false;
                d_up = false;
                d_down = false;
            }
            if ((key == KeyEvent.VK_W) && (!d_up)) {
                d_left = false;
                d_rigth = false;
                d_down = false;
            }
            if ((key == KeyEvent.VK_W) && (!d_down)) {
                d_left = false;
                d_rigth = false;
                d_up = false;
            }

        }

    }
}
