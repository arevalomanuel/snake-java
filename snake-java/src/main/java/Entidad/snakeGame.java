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
    private final int DOT_SIZE = 10;
    private final int ALL_DOTS = 900;

    private final int DELAY = 200;

    //time advance
    Timer timer;

    //image
    Image apple;
    Image head;
    Image body;

    //long on snake
    private final int snakeX[] = new int[ALL_DOTS];
    private final int snakeY[] = new int[ALL_DOTS];

    //apple position
    private int appleX;
    private int appleY;

    //direction of snake
    private boolean d_left = false;
    private boolean d_rigth= false;
    private boolean d_up= false;
    private boolean d_down= true;

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
//        assignSide();
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

    public void initGame() {
        dots = 5;

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
            
           Toolkit.getDefaultToolkit().sync();
        }

        
    }

    //asigna el lado para donde se movera la serpiente en su primer movimiento (random)
//    public void assignSide() {
//        d_left = true;
//        d_rigth = false;
//        d_up = false;
//        d_down = false;
//    }

    public void randomApple() {
    }

    public void movimiento() {
       for (int z = dots; z > 0; z--) {
            snakeX[z] = snakeX[(z - 1)];
            snakeY[z] = snakeY[(z - 1)];
        }
        
        if (d_left) {
            snakeX[0] -= DOT_SIZE;
        }
        if (d_rigth) {
            snakeX[0] += DOT_SIZE;
        }
        if (d_up) {
            snakeY[0] -= DOT_SIZE;
        }
        if (d_down) {
            snakeY[0] += DOT_SIZE;
        }
    }

    public void colicion() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (inGame) {
            movimiento();
        }

        repaint();
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();

             if ((key == KeyEvent.VK_A) && (!d_rigth)) {
                d_left = true;
                d_up = false;
                d_down = false;
                
            }
            
            if ((key == KeyEvent.VK_D) && (!d_left)) {
                d_rigth = true;
                d_up = false;
                d_down = false;
              
            }
           
            if ((key == KeyEvent.VK_W) && (!d_down)) {
                d_up = true;
                d_rigth = false;
                d_left = false;
              
            }
            if ((key == KeyEvent.VK_S) && (!d_up)) {
                d_down = true;
                d_left = false;
                d_rigth = false;
              
                
            }

        }

    }
}
