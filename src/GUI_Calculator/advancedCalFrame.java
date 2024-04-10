package GUI_Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static GUI_Calculator.basicCalFrame.*;

public class advancedCalFrame extends JFrame implements ActionListener {
    static Buttons parenthesis1, parenthesis2, sin, cos, tan, cosec, sec, cot, asin,
            atan, acos, log, ln, power, cube, sqrt, cubicSqrt, inverse, pi, e,
            nThPower, abs, fact, exp, sinh, cosh, tanh, power10, persentageButton, historyButton;

    static JTextField text, text2;
    static JRadioButton rad, deg;
    static char unit;
    static JPanel historyPanel;

    advancedCalFrame() {
        this.setTitle("CALCULATOR");
        this.setLayout(new BorderLayout(15, 2));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //this.setSize(635, 800);
        this.getContentPane().setBackground(new Color(58, 56, 56, 255));

        ImageIcon icon = new ImageIcon("src/GUI_Calculator/icon.png");
        this.setIconImage(icon.getImage());

        menuBar Menu = new menuBar();
        this.add(Menu, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        text = new JTextField();
        text.setFont(new Font("Monospaced", Font.BOLD, 35));
        text.setHorizontalAlignment(4);  // 4 = RIGHT Alignment.
        text.setBackground(Color.darkGray);
        text.setForeground(Color.green);
        text.setLayout(new BorderLayout());
        text.setEditable(false);

        text2 = new JTextField();
        text2.setFont(new Font("Monospaced", Font.BOLD, 30));
        text2.setHorizontalAlignment(4);  // 4 = RIGHT Alignment.
        text2.setBackground(Color.darkGray);
        text2.setForeground(Color.darkGray);
        text2.setEditable(false);

        panel.add(text, BorderLayout.CENTER);
        panel.add(text2, BorderLayout.NORTH);

        parenthesis1 = new Buttons("(");
        parenthesis2 = new Buttons(")");

        sin = new Buttons("sin");
        cos = new Buttons("cos");
        tan = new Buttons("tan");
        cosec = new Buttons("cosec");
        sec = new Buttons("sec");
        cot = new Buttons("cot");
        asin = new Buttons("sin-1");
        acos = new Buttons("cos-1");
        atan = new Buttons("tan-1");
        sinh = new Buttons("sinh");
        cosh = new Buttons("cosh");
        tanh = new Buttons("tanh");
        persentageButton = new Buttons("%");
        power10 = new Buttons("10^x");
        log = new Buttons("log");
        ln = new Buttons("ln");
        power = new Buttons("X^2");
        nThPower = new Buttons("X^n");
        cube = new Buttons("X^3");
        sqrt = new Buttons("X^0.5");
        cubicSqrt = new Buttons("X^1/3");
        inverse = new Buttons("1/x");
        pi = new Buttons("PI");
        e = new Buttons("e");
        abs = new Buttons("|x|");
        fact = new Buttons("x!");
        exp = new Buttons("e^x");
        historyButton = new Buttons("Ⓜ");

        ans.setBackground(Color.CYAN);
        clear.setForeground(Color.RED);
        clear.setBackground(new Color(0xFF242624, true));

        rad = new JRadioButton("R");
        rad.setBackground(Color.LIGHT_GRAY);
        rad.setFont(new Font(null, Font.BOLD, 18));
        deg = new JRadioButton("D");
        deg.setBackground(Color.LIGHT_GRAY);
        deg.setFont(new Font(null, Font.BOLD, 18));
        ButtonGroup group = new ButtonGroup();
        group.add(rad);
        group.add(deg);
        rad.addActionListener(this);
        deg.addActionListener(this);
        rad.doClick();

        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.LIGHT_GRAY);
        panel1.add(rad);
        panel1.add(deg);

        JPanel numberPanel = new JPanel();
        numberPanel.setBounds(10, 200, 250, 300);
        numberPanel.setLayout(new GridLayout(4, 5, 5, 5));
        numberPanel.setBorder(BorderFactory.createLineBorder(Color.BLUE, 1));

        JPanel functionPanel = new JPanel();
        functionPanel.setBounds(10, 200, 250, 300);
        functionPanel.setLayout(new GridLayout(5, 6, 0, 3));
        functionPanel.setBorder(BorderFactory.createLineBorder(Color.BLUE, 1));

        functionPanel.add(panel1);
        functionPanel.add(pi);
        functionPanel.add(parenthesis1);
        functionPanel.add(parenthesis2);
        functionPanel.add(e);
        functionPanel.add(exp);
        functionPanel.add(sin);
        functionPanel.add(cos);
        functionPanel.add(tan);
        functionPanel.add(asin);
        functionPanel.add(acos);
        functionPanel.add(atan);
        functionPanel.add(cosec);
        functionPanel.add(sec);
        functionPanel.add(cot);
        functionPanel.add(sinh);
        functionPanel.add(cosh);
        functionPanel.add(tanh);
        functionPanel.add(power);
        functionPanel.add(sqrt);
        functionPanel.add(inverse);
        functionPanel.add(abs);
        functionPanel.add(log);
        functionPanel.add(ln);
        functionPanel.add(cube);
        functionPanel.add(nThPower);
        functionPanel.add(cubicSqrt);
        functionPanel.add(fact);
        functionPanel.add(persentageButton);
        functionPanel.add(historyButton);

        panel.add(functionPanel, BorderLayout.SOUTH);
        this.add(panel, BorderLayout.CENTER);

        numberPanel.add(button7);
        numberPanel.add(button8);
        numberPanel.add(button9);
        numberPanel.add(back);
        numberPanel.add(clear);
        numberPanel.add(button4);
        numberPanel.add(button5);
        numberPanel.add(button6);
        numberPanel.add(mul);
        numberPanel.add(divide);
        numberPanel.add(button1);
        numberPanel.add(button2);
        numberPanel.add(button3);
        numberPanel.add(add);
        numberPanel.add(sub);
        numberPanel.add(button0);
        numberPanel.add(decimalPoint);
        numberPanel.add(power10);
        numberPanel.add(negativeButton);
        numberPanel.add(ans);

        historyPanel = new JPanel();
        historyPanel.setVisible(false);

        this.add(historyPanel,BorderLayout.WEST);
        this.add(numberPanel, BorderLayout.SOUTH);
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        if (e.getActionCommand().equals("R")) {
            unit = 'R';
        } else if (e.getActionCommand().equals("D")) {
            unit = 'D';
        }
    }

}
