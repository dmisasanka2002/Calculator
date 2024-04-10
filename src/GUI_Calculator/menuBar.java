package GUI_Calculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class menuBar extends JMenuBar implements ActionListener {

    static advancedCalFrame frame;

    menuBar(){
        JMenu modeMenu = new JMenu("MODE");
        JMenu helpMenu = new JMenu("HELP");
        this.add(modeMenu);this.add(helpMenu);
        this.setBounds(10,5,95,15);

        JMenuItem basicMode = new JMenuItem("Basic Mode");
        JMenuItem advancedMode = new JMenuItem("Scientific Mode");
        JMenuItem exit = new JMenuItem("exit");

        JMenuItem help = new JMenuItem("help");

        /* Add ShortCuts Keys */
        basicMode.setMnemonic(KeyEvent.VK_B);  // b for Basic Mode.
        advancedMode.setMnemonic(KeyEvent.VK_A);  // a for Advanced Mode.
        exit.setMnemonic(KeyEvent.VK_E);  // e fot Exit.

        basicMode.addActionListener(this);
        advancedMode.addActionListener(this);
        exit.addActionListener(this);
        help.addActionListener(this);

        modeMenu.add(basicMode);modeMenu.add(advancedMode);modeMenu.add(exit);
        helpMenu.add(help);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("exit")){
            System.exit(0);
        }
        else if ((e.getActionCommand().equals("Scientific Mode")) && Calculator.mode.equals("basic")) {
            advancedCalFrame.text = basicCalFrame.text;
            Calculator.frame.dispose();
            Calculator.mode = "advanced";
            frame = new advancedCalFrame();
        }
        else if ((e.getActionCommand().equals("Basic Mode")) && Calculator.mode.equals("advanced")){
            advancedCalFrame.text = basicCalFrame.text;
            Calculator.mode = "basic";
            frame.dispose();
            new Calculator();
        }
        else if (e.getActionCommand().equals("help")) {
            new helpBox();
        }
    }
}
