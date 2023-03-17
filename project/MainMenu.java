import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu {
    GameFrame gameFrame ;
    String title = "HUNGRY ELIZER";
    JButton startBtn = new JButton();
    JButton settingsBtn = new JButton();
    JButton exitBtn = new JButton();
    JButton easyBtn = new JButton();
    JButton medBtn = new JButton();
    JButton hardBtn = new JButton();
    JButton backBtn = new JButton();
    JButton tryAgainBtn = new JButton();





    GamePanel gamePanel;
    JLabel titleLabel;
    ColorPicker colorPicker;
    public MainMenu(GamePanel gamePanel,GameFrame gameFrame){
        this.gameFrame = gameFrame;

        this.gamePanel = gamePanel;

        colorPicker = new ColorPicker(this);

        int padding = 50;
        int spacing = 50;

        int startbtnHeight = 50;
        int startbtnWidth = 200;
        int startbtnPosX = (gamePanel.SCREEN_WIDTH/2)-(startbtnWidth/2);
        int startbtnPosY = (gamePanel.SCREEN_HEIGHT/2)-(startbtnHeight/2)+ padding;
        startBtn.setBounds(startbtnPosX,startbtnPosY,startbtnWidth,startbtnHeight);
        ImageIcon startIcon = new ImageIcon("startbtn.png");
        startBtn.setIcon(loadImage(startIcon, startbtnWidth, startbtnHeight));

        int settingsbtnHeight = 50;
        int settingsbtnWidth = 200;
        int settingsbtnPosX = (gamePanel.SCREEN_WIDTH/2)-(settingsbtnWidth/2);
        int settingsbtnPosY = startbtnPosY+(settingsbtnHeight/2)+ spacing;
        settingsBtn.setBounds(settingsbtnPosX,settingsbtnPosY,settingsbtnWidth,settingsbtnHeight);
        ImageIcon settingsIcon = new ImageIcon("Settingsbtn.png");
        settingsBtn.setIcon(loadImage(settingsIcon, settingsbtnWidth, settingsbtnHeight));

        int exitbtnHeight = 50;
        int exitbtnWidth = 200;
        int exitbtnPosX = (gamePanel.SCREEN_WIDTH/2)-(exitbtnWidth/2);
        int exitbtnPosY = settingsbtnPosY+(exitbtnHeight/2)+ spacing;
        exitBtn.setBounds(exitbtnPosX,exitbtnPosY,exitbtnWidth,exitbtnHeight);
        ImageIcon exitIcon = new ImageIcon("Exitbtn.png");
        exitBtn.setIcon(loadImage(exitIcon, exitbtnWidth, exitbtnHeight));

        int tryAgainbtnHeight = 50;
        int tryAgainbtnWidth = 200;
        int tryAgainbtnPosX = (gamePanel.SCREEN_WIDTH/2)-(tryAgainbtnWidth/2);
        int tryAgainbtnPosY = startbtnPosY+(tryAgainbtnHeight/2)+ spacing;
        tryAgainBtn.setBounds(tryAgainbtnPosX,tryAgainbtnPosY,tryAgainbtnWidth,tryAgainbtnHeight);
        ImageIcon tryAgainIcon = new ImageIcon("retrybtn2.png");
        tryAgainBtn.setIcon(loadImage(tryAgainIcon, tryAgainbtnWidth, tryAgainbtnHeight));



        //...................................................... setting's button

        int easybtnHeight = 50;
        int easybtnWidth = 200;
        int easybtnPosX = (gamePanel.SCREEN_WIDTH/2)-(easybtnWidth/2);
        int easybtnPosY = (gamePanel.SCREEN_HEIGHT/2)-(easybtnHeight/2)+ padding;
        easyBtn.setBounds(easybtnPosX,easybtnPosY,easybtnWidth,easybtnHeight);
        //easyBtn.setBackground(Color.green);
        ImageIcon easyIcon = new ImageIcon("easybtn2.png");
        easyBtn.setIcon(loadImage(easyIcon, easybtnWidth, easybtnHeight));




        int medbtnHeight = 50;
        int medbtnWidth = 200;
        int medbtnPosX = (gamePanel.SCREEN_WIDTH/2)-(medbtnWidth/2);
        int medbtnPosY =  easybtnPosY+(medbtnHeight/2)+ spacing;
        medBtn.setBounds(medbtnPosX,medbtnPosY,medbtnWidth,medbtnHeight);
       // medBtn.setBackground(Color.yellow);
        ImageIcon medIcon = new ImageIcon("mediumbtn.png");
        medBtn.setIcon(loadImage(medIcon, medbtnWidth, medbtnHeight));

        int hardbtnHeight = 50;
        int hardbtnWidth = 200;
        int hardbtnPosX = (gamePanel.SCREEN_WIDTH/2)-(hardbtnWidth/2);
        int hardbtnPosY = medbtnPosY+(hardbtnHeight/2)+ spacing;
        hardBtn.setBounds(hardbtnPosX,hardbtnPosY,hardbtnWidth,hardbtnHeight);
        //hardBtn.setBackground(Color.red);
        ImageIcon hardIcon = new ImageIcon("hardbtn.png");
        hardBtn.setIcon(loadImage(hardIcon, hardbtnWidth, hardbtnHeight));

        int backbtnHeight = 50;
        int backbtnWidth = 200;
        int backbtnPosX = (gamePanel.SCREEN_WIDTH/2)-(backbtnWidth/2);
        int backbtnPosY = hardbtnPosY+(backbtnHeight/2)+ spacing;
        backBtn.setBounds(backbtnPosX,backbtnPosY,backbtnWidth,backbtnHeight);
        ImageIcon backIcon = new ImageIcon("bckbtn2.png");
        backBtn.setIcon(loadImage(backIcon, backbtnWidth, backbtnHeight));
        //...............................................

        titleLabel = new JLabel(title,SwingConstants.CENTER);
        int titleLabelFontSize = 90;
        titleLabel.setFont(new Font("Colonna MT",Font.CENTER_BASELINE,titleLabelFontSize));
        titleLabel.setForeground(Color.white);
        int titleLabelHeight = 150;
        int titleLabelWidth = 1000;
        int titleLabelPosX = (gamePanel.SCREEN_WIDTH/2)-(titleLabelWidth/2);
        int titleLabelPosY = 100-(titleLabelHeight/2)+ padding;
        titleLabel.setBounds(titleLabelPosX,titleLabelPosY,titleLabelWidth,titleLabelHeight);

        startBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Start();
            }
        });
        settingsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Settings();
            }
        });
        exitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Exit();
            }
        });
        //................................................
        easyBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Easy();
            }
        });
        medBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Medium();
            }
        });
        hardBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {Hard();}
        });
        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {Back();}
        });
        tryAgainBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {Retry();}
        });


        gamePanel.add(startBtn);
        gamePanel.add(settingsBtn);
        gamePanel.add(exitBtn);
        gamePanel.add(titleLabel);


    }
    public void Start(){
        gamePanel.remove(startBtn);
        gamePanel.remove(settingsBtn);
        gamePanel.remove(exitBtn);
        gamePanel.remove(titleLabel);
        gamePanel.setUp();
       gamePanel.startGame();

    }
    public void Settings(){
        gamePanel.remove(startBtn);
        gamePanel.remove(settingsBtn);
        gamePanel.remove(exitBtn);
        titleLabel.setText("AYUSIN MO");
        gamePanel.add(easyBtn);
        gamePanel.add(medBtn);
        gamePanel.add(hardBtn);
        gamePanel.add(backBtn);
        gamePanel.refresh();

        int Height = 100;
        int Width = 200;
        int PosX = (gamePanel.SCREEN_WIDTH/2)-(Width/2);
        int PosY = (gamePanel.SCREEN_HEIGHT/2)-(Height/2) - 50;
        colorPicker.addColorPicker(PosX,PosY,Width,Height);

    }
    public void Exit(){
        System.exit(0);

    }
    public void Easy(){

        gamePanel.DELAY = 200;
        titleLabel.setForeground(Color.green);
        Back();
    }
    public void Medium(){
        gamePanel.DELAY = 150;
        titleLabel.setForeground(Color.yellow);
        Back();
    }
    public void Hard(){
        gamePanel.DELAY = 100;
        titleLabel.setForeground(Color.red);
        Back();
    }
    public void Back(){
        gamePanel.add(startBtn);
        gamePanel.add(settingsBtn);
        gamePanel.add(exitBtn);
        titleLabel.setText(title);
        gamePanel.remove(easyBtn);
        gamePanel.remove(medBtn);
        gamePanel.remove(hardBtn);
        gamePanel.remove(backBtn);
        gamePanel.refresh();

        colorPicker.removeColorPicker();
    }
    public void Retry(){
        gameFrame.dispose();
        new GameFrame();


    }
    public void stop(){

        gamePanel.add(exitBtn);
        gamePanel.add(tryAgainBtn);

    }
    public ImageIcon loadImage(ImageIcon icon, int width, int height ){
       Image img = icon.getImage();
       Image newimg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
       return new ImageIcon(newimg);
    }




    }


