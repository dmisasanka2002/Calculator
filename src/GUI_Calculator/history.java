package GUI_Calculator;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static GUI_Calculator.Buttons.pastCalcList;
import static GUI_Calculator.advancedCalFrame.*;

public class history implements ListSelectionListener, ActionListener {
    JList<String> listBox = new JList<>();
    static JButton historyClear, panelClose;

    history(){
        new pastCalc();

        listBox.setModel(pastCalcList);
        listBox.setVisibleRowCount(15);
        listBox.setBackground(Color.BLACK);
        listBox.setFont(new Font("SansSerif",Font.ITALIC,20));
        listBox.setForeground(Color.WHITE);
        //listBox.setMaximumSize(new Dimension(800,800));
        listBox.addListSelectionListener(this);

        historyClear = new JButton("Clear History");
        historyClear.setBackground(Color.GREEN);
        historyClear.setForeground(Color.BLACK);
        historyClear.addActionListener(this);

        panelClose = new JButton("X");
        panelClose.setBackground(new Color(234, 76, 91));
        panelClose.addActionListener(this);

        historyPanel.setLayout(new BorderLayout());
        historyPanel.add(historyClear,BorderLayout.SOUTH);
        historyPanel.add(panelClose,BorderLayout.NORTH);
        historyPanel.add(new JScrollPane(listBox), BorderLayout.CENTER);

        historyButton.setEnabled(false);
        historyPanel.setVisible(true);

    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()){
            String pastValue = listBox.getSelectedValue().split("=")[1].strip();
            String str = text.getText();
            if (str.endsWith("+") || str.endsWith("-") || str.endsWith("*") || str.endsWith("/")) {
                text.setText(text.getText() + pastValue);
                text2.setText(text2.getText() + pastValue);
            }
            else if (str.isEmpty()){
                text.setText(pastValue);
                text2.setText(pastValue);
            }

        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("X")){
            historyPanel.setVisible(false);
            historyButton.setEnabled(true);
        }
        else if (e.getActionCommand().equals("Clear History")) {
            pastCalcList.clear();
            historyClear.setEnabled(false);
            pastCalc.clearFile();
        }
    }
}
