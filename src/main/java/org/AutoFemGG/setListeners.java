package org.AutoFemGG;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;

import javax.swing.*;

public class setListeners {

    JTextField cpsTextField; // get the text field for better use
    setListeners(JTextField cpsTextField){
        this.cpsTextField = cpsTextField; //assigning it
    }

    robotClicker clicker = new robotClicker(); //creating the clicker

    public void setStartButtonListener(){ //first listener
        ClickerGUI.startButton.addActionListener(e -> {
            try{
                Float.parseFloat(cpsTextField.getText());
            } catch (NumberFormatException ex){
                return;
            }

            robotClicker.isEnabled = true; // set true to enable the while loop
            ClickerGUI.startButton.setEnabled(false);

            if (ClickerGUI.LeftClick.isSelected()){ //when left click selected left-clicking else right
                clicker.startLeftClicking(cpsTextField);
            }
            else{
                clicker.startRightClicking(cpsTextField);
            }


        });
    }




    public void setStopButtonListener(){

        ClickerGUI.stopButton.addActionListener(e -> {
            robotClicker.isEnabled = false;
            ClickerGUI.startButton.setEnabled(true);

        });
    }

    public void setKeyListeners(){
        StopKeyListener stopKeyListener = new StopKeyListener(); //the listener for F4
        startKeyListener startKeyListener = new startKeyListener(cpsTextField); //listener for T

        try {
            GlobalScreen.registerNativeHook(); //try registering the hook
            GlobalScreen.addNativeKeyListener(stopKeyListener);//now adding the listeners to the global screen
            GlobalScreen.addNativeKeyListener(startKeyListener); //register the startKeyListener here
        }catch (NativeHookException e){
            System.out.println(e.getMessage()); //here adding an exit key with F4
        }
    }

    public void setAllListeners(){//adding all the listeners
        setStopButtonListener();
        setStartButtonListener();
        setKeyListeners();

    }
}
