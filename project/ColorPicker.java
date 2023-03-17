import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ColorPicker {
    JList list;
    private String[] colorlist = { "BLUE", "WHITE", "MAGENTA", "YELLOW", "GREEN", "RED", "PINK", "ORANGE"};
    private Color[] colors = { Color.BLUE, Color.WHITE, Color.MAGENTA, Color.YELLOW, Color.GREEN, Color.RED, Color.PINK, Color.ORANGE};

    MainMenu mainMenu;
    JScrollPane scrollPane;
    JLabel label;

    public ColorPicker (MainMenu mainMenu){
        this.mainMenu = mainMenu;

        list = new JList(colorlist);
        list.setFont(new Font("Colonna MT", Font.BOLD, 30));
        list.setVisibleRowCount(2);

        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Add event
        EventHandler handler = new EventHandler();
        list.addListSelectionListener(handler);

        label = new JLabel("BODY COLOR:");
        label.setFont(new Font("Colonna MT", Font.BOLD, 25));
        label.setForeground(Color.WHITE);
        label.setVerticalAlignment(SwingConstants.CENTER);

        // JScrollPane
        scrollPane = new JScrollPane(list);
    }

    public void addColorPicker(int posX, int posY, int width, int height){
        scrollPane.setBounds(posX,posY,width,height);
        label.setBounds(posX,posY-70,width,height);
        mainMenu.gamePanel.add(label);
        mainMenu.gamePanel.add(scrollPane);
    }

    public void removeColorPicker(){
        mainMenu.gamePanel.remove(scrollPane);
        mainMenu.gamePanel.remove(label);
    }

    private class EventHandler implements ListSelectionListener {

        public void valueChanged(ListSelectionEvent event){
            mainMenu.gamePanel.snakeColor = colors[list.getSelectedIndex()];
        }
    }
}

