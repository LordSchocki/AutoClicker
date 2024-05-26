package org.AutoFemGG;


import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;


//class for the actual clicking of the left mouse and right mouse
public class robotClicker {

    public static boolean isEnabled = false; // our static variable to determine if we should click

    private Robot robot; //declaring robot


    public int calculateDelay(float cpsPerSecond){ //method to convert the cps to ms
        float delayCps = 1000 / cpsPerSecond; //to get the cps just 1000ms 2 cps,
        // for example, 2 would be a click every 500ms
        return Math.round(delayCps); //round it to a full int for the robot
    }


    public void startLeftClicking(JTextField cpsField){ //method to start left-clicking
        isEnabled = true;
        try{
            Float.parseFloat(cpsField.getText());
        } catch (NumberFormatException e){
            return;
        }

        float cpsNumber;
        try{
            cpsNumber = Float.parseFloat(cpsField.getText()); //parse the text field to a float number
        } catch (NumberFormatException e){
            System.out.println(e.getMessage());
            return;
        }

        if(cpsNumber < 0){
            return; //if it is less than zero, it would be negative clicks so return then
        }


        //create a new thread for better performance
        new Thread(() -> {
            try{
                robot = new Robot();
                int cpsDelay = calculateDelay(cpsNumber); //creating the delay outside the loop to save resources



                while(isEnabled){
                   robot.mousePress(InputEvent.BUTTON1_DOWN_MASK); //press
                   robot.delay(cpsDelay); //then wait
                   robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK); //then repeat and release
                  }


            }  catch (Exception ex){
                System.out.println(ex.getMessage());
            }

        }).start();


    }

    public void startRightClicking(JTextField cpsField){ //method to start right-clicking
        float cpsNumber;
        try{
            cpsNumber = Float.parseFloat(cpsField.getText()); //parse the text field to a float number
        } catch (NumberFormatException e){
            System.out.println(e.getMessage());
            return;
        }

        if(cpsNumber < 0){
            return;
        }

        new Thread(() -> {
            try{
                robot = new Robot();
                int cpsDelay = calculateDelay(cpsNumber);


                while(isEnabled){
                    robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
                    robot.delay(cpsDelay);
                    robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
                }


            }  catch (Exception ex){
                System.out.println(ex.getMessage());
            }

        }).start();


    }

}
