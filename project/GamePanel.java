import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.AffineTransform;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener {

    public static final int SCREEN_WIDTH = 1300;
    public static final int SCREEN_HEIGHT = 750;
    static final int UNIT_SIZE = 50;
    static final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / (UNIT_SIZE * UNIT_SIZE);
    public static int DELAY = 200;
    public int x[] = new int[GAME_UNITS];
    public int y[] = new int[GAME_UNITS];
    int bodyParts = 3;
    int applesEaten;
    int appleX;
    int appleY;
    char direction = 'R';
    boolean running = false;
    Timer timer;
    Random random;
    boolean isMenu = true;
    MainMenu mainMenu;
    boolean isHungry = true;

    public Color snakeColor;
    ImageIcon Head;



    GamePanel(GameFrame gameFrame) {
        random = new Random();
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        //background
        Head = new ImageIcon("sir1.png");
        this.setBackground(Color.gray);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        this.setLayout(null);

        if(isMenu){
            mainMenu = new MainMenu(this,gameFrame);
        }
        else{

            startGame();
        }
    }
    public void setUp(){

       this.requestFocus();


    }

    public void startGame() {
        isMenu = false;
        newApple();
        running = true;
        timer = new Timer(DELAY, this);
        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(isMenu){
            ImageIcon image = new ImageIcon("snake3.gif");
            g.drawImage(image.getImage(),0, 0, 1300, 750, null);

        }

        draw(g);
    }

    public void draw(Graphics g) {

        if(isMenu){
            return;
        }

        if (running) {
            //food color
            ImageIcon image = new ImageIcon("apple2.png");
            g.drawImage(image.getImage(),appleX, appleY, UNIT_SIZE, UNIT_SIZE, null);



            for (int i = 0; i < bodyParts; i++) {
                if (i == 0) {
                    //head color
                    ImageIcon headImage = animateSir();
                    g.drawImage(headImage.getImage(),x[i], y[i], UNIT_SIZE, UNIT_SIZE, null);

                } else {
                    //body color
                    g.setColor(snakeColor);
                    g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                }
            }
            g.setColor(Color.white);
            g.setFont(new Font("Colonna MT", Font.PLAIN, 40));
            FontMetrics metrics = getFontMetrics(g.getFont());
            g.drawString("Score: " + applesEaten, (SCREEN_WIDTH - metrics.stringWidth("Score: " + applesEaten)) / 2,
                    g.getFont().getSize());
        } else {
            gameOver(g);

        }

    }

    public void newApple() {
        appleX = random.nextInt((int) (SCREEN_WIDTH / UNIT_SIZE)) * UNIT_SIZE;
        appleY = random.nextInt((int) (SCREEN_HEIGHT / UNIT_SIZE)) * UNIT_SIZE;
    }

    public void move() {
        for (int i = bodyParts; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }

        switch (direction) {
            case 'U':
                y[0] = y[0] - UNIT_SIZE;
                break;
            case 'D':
                y[0] = y[0] + UNIT_SIZE;
                break;
            case 'L':
                x[0] = x[0] - UNIT_SIZE;
                break;
            case 'R':
                x[0] = x[0] + UNIT_SIZE;
                break;
        }

    }

    public void checkApple() {
        if ((x[0] == appleX) && (y[0] == appleY)) {
            bodyParts++;
            applesEaten++;
            newApple();
        }
    }

    public void checkCollisions() {
        // checks if head collides with body
        for (int i = bodyParts; i > 0; i--) {
            if ((x[0] == x[i]) && (y[0] == y[i])) {
                running = false;
            }
        }
        // check if head touches left border
        if (x[0] < 0) {
            running = false;
        }
        // check if head touches right border
        if (x[0] > SCREEN_WIDTH) {
            running = false;
        }
        // check if head touches top border
        if (y[0] < 0) {
            running = false;
        }
        // check if head touches bottom border
        if (y[0] > SCREEN_HEIGHT) {
            running = false;
        }

        if (!running) {
            timer.stop();
        }
    }

    public void gameOver(Graphics g) {
        // Score


        g.setColor(Color.white);
        g.setFont(new Font("Colonna MT", Font.BOLD, 40));
        FontMetrics metrics1 = getFontMetrics(g.getFont());
        g.drawString("Score: " + applesEaten, (SCREEN_WIDTH - metrics1.stringWidth("Score: " + applesEaten)) / 2,
        g.getFont().getSize());
        // Game Over text
        g.setColor(Color.white);
        g.setFont(new Font("Colonna MT", Font.BOLD, 75));
        FontMetrics metrics2 = getFontMetrics(g.getFont());

        g.drawString("Talo kana uno ka kay sir!", (SCREEN_WIDTH - metrics2.stringWidth("Talo kana uno ka kay sir!")) / 2, SCREEN_HEIGHT / 2);
        g.translate(0,0);
        mainMenu.stop();

    }
    public void refresh(){
        this.repaint();
        this.revalidate();
    }
    public ImageIcon animateSir(){
        isHungry = !isHungry;
        if(isHungry){
            return new ImageIcon("sir2.png");

        }
        else{
            return new ImageIcon("sir1.png");
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (running) {
            move();
            checkApple();
            checkCollisions();
        }
        repaint();
    }

    public class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    if (direction != 'R') {
                        direction = 'L';
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if (direction != 'L') {
                        direction = 'R';
                    }
                    break;
                case KeyEvent.VK_UP:
                    if (direction != 'D') {
                        direction = 'U';
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if (direction != 'U') {
                        direction = 'D';
                    }
                    break;
            }
        }
    }
}