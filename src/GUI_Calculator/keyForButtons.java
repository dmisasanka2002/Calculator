package GUI_Calculator;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static GUI_Calculator.advancedCalFrame.deg;
import static GUI_Calculator.advancedCalFrame.rad;
import static GUI_Calculator.basicCalFrame.*;

public class keyForButtons {
    keyForButtons(JButton button){
        button.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                if ((e.getKeyCode() == KeyEvent.VK_0) || (e.getKeyCode() == KeyEvent.VK_NUMPAD0)){
                    button0.doClick();
                }
                else if ((e.getKeyCode() == KeyEvent.VK_1) || (e.getKeyCode() == KeyEvent.VK_NUMPAD1)){
                    button1.doClick();
                }
                else if ((e.getKeyCode() == KeyEvent.VK_2) || (e.getKeyCode() == KeyEvent.VK_NUMPAD2)){
                    button2.doClick();
                }
                else if ((e.getKeyCode() == KeyEvent.VK_3) || (e.getKeyCode() == KeyEvent.VK_NUMPAD3)){
                    button3.doClick();
                }
                else if ((e.getKeyCode() == KeyEvent.VK_4) || (e.getKeyCode() == KeyEvent.VK_NUMPAD4)){
                    button4.doClick();
                }
                else if ((e.getKeyCode() == KeyEvent.VK_5) || (e.getKeyCode() == KeyEvent.VK_NUMPAD5)){
                    button5.doClick();
                }
                else if ((e.getKeyCode() == KeyEvent.VK_6) || (e.getKeyCode() == KeyEvent.VK_NUMPAD6)){
                    button6.doClick();
                }
                else if ((e.getKeyCode() == KeyEvent.VK_7) || (e.getKeyCode() == KeyEvent.VK_NUMPAD7)){
                    button7.doClick();
                }
                else if ((e.getKeyCode() == KeyEvent.VK_8) || (e.getKeyCode() == KeyEvent.VK_NUMPAD8)){
                    button8.doClick();
                }
                else if ((e.getKeyCode() == KeyEvent.VK_9) || (e.getKeyCode() == KeyEvent.VK_NUMPAD9)){
                    button9.doClick();
                }
                else if ((e.getKeyCode() == KeyEvent.VK_ENTER) || (e.getKeyCode() == KeyEvent.VK_EQUALS)){
                    ans.doClick();
                }
                else if (e.getKeyCode() == KeyEvent.VK_ADD) {
                    add.doClick();
                }
                else if (e.getKeyCode() == KeyEvent.VK_SUBTRACT) {
                    sub.doClick();
                }
                else if (e.getKeyCode() == KeyEvent.VK_MULTIPLY) {
                    mul.doClick();
                }
                else if ((e.getKeyCode() == KeyEvent.VK_DIVIDE) || (e.getKeyCode() == KeyEvent.VK_SLASH)){
                    divide.doClick();
                }
                else if ((e.getKeyCode() == KeyEvent.VK_DECIMAL)){
                    decimalPoint.doClick();
                }
                else if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    back.doClick();
                }
                else if (e.getKeyCode() == KeyEvent.VK_DELETE) {
                    clear.doClick();
                }
                else if (e.getKeyCode() == KeyEvent.VK_R) {
                    rad.doClick();
                }
                else if (e.getKeyCode() == KeyEvent.VK_D) {
                    deg.doClick();
                }
                else {
                    System.out.println("NOT A VALID KEY .");
                }
            }
        });
    }

}
