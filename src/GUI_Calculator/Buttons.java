package GUI_Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Buttons extends JButton implements ActionListener {
    static DefaultListModel<String> pastCalcList = new DefaultListModel<>();
    static boolean lastAnswer = false;
    JTextField text2;

    Buttons(String buttonName) {
        this.setText(buttonName);
        this.setFont(new Font("Monospaced", Font.BOLD, 22));
        new keyForButtons(this);
        this.addActionListener(this);

    }


    private static String del(String text) {
        StringBuilder newText = new StringBuilder();
        String[] strings = text.split("");

        for (int i = 0; i < strings.length - 1; i++) {
            newText.append(strings[i]);
        }
        return newText.toString();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JTextField text = basicCalFrame.text;

        if (Calculator.mode.equals("advanced")) {
            text = advancedCalFrame.text;
            text2 = advancedCalFrame.text2;
        }
        if (lastAnswer){
            text2.setText(text.getText());
            lastAnswer = false;
        }

        if (e.getActionCommand().equals("C")) {
            text.setText("");
            text2.setText("");
            text2.setForeground(Color.darkGray);
        }
        else if (e.getActionCommand().equals("DEL")) {
            text.setText(del(text.getText()));
            text2.setText(del(text2.getText()));
        }
        else if (e.getActionCommand().equals("+/-")) {
            text.setText("-" + text.getText());
            text2.setText("-" + text2.getText());
        }
        else if (e.getActionCommand().equals(".")) {
            text.setText(text.getText() + e.getActionCommand());
            text2.setText(text2.getText() + e.getActionCommand());
        }
        else if (e.getActionCommand().equals("=")) {
            if (text.getText().isEmpty()){
                try {
                    text.setText(pastCalcList.get(0).split("=")[1].strip());
                    text2.setForeground(Color.CYAN);
                    text2.setText("("+ pastCalcList.get(0).split("=")[0].strip()+")");
                    lastAnswer = true;
                }
                catch (Exception ignored){}

            }
            else {
                try {
                    System.out.println(text2.getText());
                    new Calculations(text2.getText());
                    text2.setText(text.getText());
                    text2.setForeground(Color.CYAN);
                } catch (Exception ex) {
                    new Calculations(text.getText());
                }
                text.setText(String.valueOf(Calculations.result));
                pastCalcList.add(0, text2.getText() + " = " + Calculations.result);
                try {
                    pastCalcList.remove(1);
                }
                catch (Exception ignored) {}
                new pastCalc(pastCalcList.get(0));
            }

        }
        else {
            String[] buttons = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "+", "-", "x", "/"};
            for (String i : buttons) {
                if (e.getActionCommand().equals(i)) {

                    if (i.equals("x")) {
                        text.setText(text.getText() + "*");
                        text2.setText(text2.getText() + "*");
                        break;
                    }
                    text.setText(text.getText() + e.getActionCommand());
                    text2.setText(text2.getText() + e.getActionCommand());
                    break;
                }
                else if (i.equals("/")) {
                    advancedCalculations obj = new advancedCalculations();
                    obj.actionPerformed(e);
                }
            }
        }
    }

}
