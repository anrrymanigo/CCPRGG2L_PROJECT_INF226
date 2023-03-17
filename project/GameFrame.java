import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class GameFrame extends JFrame{
    GamePanel gamePanel;
    public SnakeGame snakeGame;
    GameFrame() {


       SetUp();

    }
    public void SetUp(){
        if(gamePanel != null){
            snakeGame.NewGame();
            return;
        }
        gamePanel = (new GamePanel(this));

        this.add(gamePanel);
        this.setTitle("SNAKE");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        if(!this.isUndecorated()){
            this.setUndecorated(true);
        }
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
    }
}