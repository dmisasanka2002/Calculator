package GUI_Calculator;

import javax.swing.*;

public class helpBox extends JOptionPane{

    helpBox(){
        JOptionPane.showMessageDialog(null,"This is " + Calculator.mode.toUpperCase() + " Mode");
    }

}
