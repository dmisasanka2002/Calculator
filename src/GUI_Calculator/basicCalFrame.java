package GUI_Calculator;

import javax.swing.*;
import java.awt.*;
public class basicCalFrame extends JFrame{

    static Buttons button0,button1,button2,button3,button4, button5,button6,
            button7,button8,button9,add,sub,mul,divide,ans,back,clear,
            parenthesis, decimalPoint, negativeButton;
    int width = 360;int height = 540;
    static JTextField text;

    basicCalFrame() {
        this.setTitle("CALCULATOR");
        this.setResizable(false);
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(width,height);
        this.getContentPane().setBackground(new Color(58, 56, 56));
        //setDefaultLookAndFeelDecorated(true);

        ImageIcon icon = new ImageIcon("src/GUI_Calculator/icon.png");
        this.setIconImage(icon.getImage());

        menuBar Menu = new menuBar();
        this.add(Menu);

        text = new JTextField(1);
        text.setBounds(10,25,326,90);
        text.setFont(new Font("Monospaced", Font.BOLD,35));
        text.setHorizontalAlignment(4);  // 4 = RIGHT Alignment.
        text.setBackground(Color.darkGray);
        text.setForeground(Color.green);
        text.setEditable(false);
        this.add(text);

        button0 = new Buttons("0");
        button1 = new Buttons("1");
        button2 = new Buttons("2");
        button3 = new Buttons("3");
        button4 = new Buttons("4");
        button5 = new Buttons("5");
        button6 = new Buttons("6");
        button7 = new Buttons("7");
        button8 = new Buttons("8");
        button9 = new Buttons("9");
        add = new Buttons("+");
        sub = new Buttons("-");
        mul = new Buttons("x");
        divide = new Buttons("/");
        ans = new Buttons("=");
        parenthesis = new Buttons("()");parenthesis.setEnabled(false);
        decimalPoint = new Buttons(".");
        negativeButton = new Buttons("+/-");
        back = new Buttons("DEL");
        clear = new Buttons("C");

        parenthesis.setBounds(93,150,250/3,50);
        back.setBounds(177,150,250/3,50);

        ans.setBackground(Color.CYAN);

        clear.setForeground(Color.RED);
        clear.setBackground(new Color(0xFF242624, true));
        clear.setBounds(10,150,250/3,50);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBounds(10,200,250,300);
        buttonPanel.setLayout(new GridLayout(4,3,3,3));
        buttonPanel.setBorder(BorderFactory.createLineBorder(Color.BLUE,1));

        JPanel operatorPanel = new JPanel();
        operatorPanel.setBounds(260,150,76,350);
        operatorPanel.setLayout(new GridLayout(5,1,3,3));

        this.add(clear);this.add(parenthesis);this.add(back);

        operatorPanel.add(add);operatorPanel.add(sub);operatorPanel.add(mul);
        operatorPanel.add(divide);operatorPanel.add(ans);

        buttonPanel.add(button7);buttonPanel.add(button8);buttonPanel.add(button9);buttonPanel.add(button4);
        buttonPanel.add(button5);buttonPanel.add(button6);buttonPanel.add(button1);buttonPanel.add(button2);
        buttonPanel.add(button3);buttonPanel.add(negativeButton);buttonPanel.add(button0);buttonPanel.add(decimalPoint);

        this.add(buttonPanel);
        this.add(operatorPanel);

        this.setVisible(true);
    }
}
