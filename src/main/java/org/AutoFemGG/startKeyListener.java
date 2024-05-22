package org.AutoFemGG;

import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

import javax.swing.*;
import java.awt.*;

public class startKeyListener implements NativeKeyListener {

    JTextField cpsTextField;
    robotClicker clicker = new robotClicker();

    startKeyListener (JTextField cpsTextField){
        this.cpsTextField = cpsTextField;

    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent nativeEvent) {
        if (nativeEvent.getKeyCode() == NativeKeyEvent.VC_T){


            robotClicker.isEnabled = true;
            clicker.startLeftClicking(cpsTextField);
            ClickerGUI.startButton.setEnabled(false);

        }
    }



}
