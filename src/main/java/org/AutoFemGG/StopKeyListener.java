package org.AutoFemGG;

import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

public class StopKeyListener implements NativeKeyListener {
    public void nativeKeyPressed(NativeKeyEvent e){



        if (e.getKeyCode() == NativeKeyEvent.VC_F4){
            robotClicker.isEnabled = false;
            ClickerGUI.startButton.setEnabled(true);
        }

    }
}
