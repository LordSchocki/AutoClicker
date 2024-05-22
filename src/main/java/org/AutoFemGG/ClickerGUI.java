package org.AutoFemGG;

import javax.swing.*;
import java.awt.*;

public class ClickerGUI {

    //creating the clicker components

    public static JFrame mainWindow = new JFrame("FemClicker");
    public JPanel mainPanel = new JPanel();
    private final JLabel welcomeLabel = new JLabel("My FemClicker");
    public static JButton startButton = new JButton("Start");
    public static JButton stopButton = new JButton("Stop");
    private final JPanel buttonPanel = new JPanel();
    private final JPanel radioPanel = new JPanel();
    public JTextField cpsField = new JTextField();
    public JLabel cpsLabel = new JLabel("Enter your CPS");
    public JLabel rightOrLeft = new JLabel("Right or Left click");
    public static JRadioButton RightClick = new JRadioButton("Right Click");
    public static JRadioButton LeftClick = new JRadioButton("Left Click");
    public static ButtonGroup mouseButtons = new ButtonGroup();
    private final ImageIcon icon = new ImageIcon("src/media/mouse_pointer.png");

    private final setListeners listeners = new setListeners(cpsField);

    // method to add the items to each-other

    private void addComponents(){


        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(startButton);
        buttonPanel.add(stopButton);

        mouseButtons.add(LeftClick);
        mouseButtons.add(RightClick);

        radioPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        radioPanel.add(LeftClick);
        radioPanel.add(RightClick);


        mainPanel.add(welcomeLabel);
        mainPanel.add(Box.createRigidArea(new Dimension(0,40)));
        mainPanel.add(cpsLabel);
        mainPanel.add(Box.createRigidArea(new Dimension(0,20)));
        mainPanel.add(cpsField);
        mainPanel.add(Box.createRigidArea(new Dimension(0,40)));
        mainPanel.add(rightOrLeft);
        mainPanel.add(Box.createRigidArea(new Dimension(0,40)));
        mainPanel.add(radioPanel);
        mainPanel.add(Box.createRigidArea(new Dimension(0,40)));
        mainPanel.add(buttonPanel);



        mainWindow.add(mainPanel);


    }



    // method to set the traits

    private void setComponents(){
        mainWindow.setLayout(new FlowLayout(FlowLayout.CENTER));
        mainWindow.setLocationRelativeTo(null);
        mainWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainWindow.setIconImage(icon.getImage());
        mainWindow.setSize(400,400);

        mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));





    }

    public void initGUI(){
        //first add then set the components to avoid issues
        addComponents();

        setComponents();

        listeners.setAllListeners();



        mainWindow.setVisible(true);

    }


}
