package GUI_Calculator;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static GUI_Calculator.advancedCalFrame.*;

public class advancedCalculations implements ActionListener {
    static boolean validity = true ;
    static boolean nthPower = false;
    static double expression,degFactor,radFactor;

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("PI")){
            text2.setText(text2.getText()+Math.PI);
            text.setText(text.getText() + "Pi");
        }
        else if (e.getActionCommand().equals("e")){
            text2.setText(text2.getText()+Math.E);
            text.setText(text.getText() + "e");
        }
        else if (e.getActionCommand().equals("log")){
            text2.setText(text2.getText() + "Math.log10(");
            text.setText(text.getText() + e.getActionCommand()+"(");
        }
        else if (e.getActionCommand().equals("ln")){
            text2.setText(text2.getText() + "Math.log(");
            text.setText(text.getText() + e.getActionCommand()+"(");
        }
        else if (e.getActionCommand().equals("|x|")){
            text2.setText(text2.getText() + "Math.abs(");
            text.setText(text.getText() + "abs(");
        }
        else if (e.getActionCommand().equals("x!")){
            double leftNum = getNumber(text.getText(),text.getCaretPosition());
            if (validity) {
                text2.setText(text2.getText() + factorial((int) leftNum));
                text.setText(text.getText() + "!");
            }
        }
        else if (e.getActionCommand().equals("%")){
            text2.setText(text2.getText()+"/100.0");
            text.setText(text.getText() + e.getActionCommand());
        }
        else if (e.getActionCommand().equals(")")){
            text.setText(text.getText() + ")");
            if (nthPower) {
                text2.setText(text2.getText() + ")");
                double exponent = getNumber(text.getText(), text.getCaretPosition());
                System.out.println("Exponent : "+exponent);
                text2.setText(text2.getText() + Math.pow(expression,exponent));
                nthPower = false;
            }
            else {
                text2.setText(text2.getText() + ")");
            }


        }
        else if (e.getActionCommand().equals("Ⓜ")){
            new history();
        }
        else {
            trigonometry(e);
        }
    }

    private static void trigonometry(ActionEvent e) {
        if (unit == 'R') {
            degFactor = 1;
            radFactor = 1;
        }
        else if (unit == 'D') {
            degFactor = (Math.PI)/180;
            radFactor = (180/Math.PI);
        }

        if (e.getActionCommand().equals("sin")) {
            text2.setText(text2.getText() + "Math.sin("+degFactor+"*");
            text.setText(text.getText() + e.getActionCommand() + "(");
        }
        else if (e.getActionCommand().equals("cos")) {
            text2.setText(text2.getText() + "Math.cos("+degFactor+"*");
            text.setText(text.getText() + e.getActionCommand() + "(");
        }
        else if (e.getActionCommand().equals("tan")) {
            text2.setText(text2.getText() + "Math.tan("+degFactor+"*");
            text.setText(text.getText() + e.getActionCommand() + "(");
        }
        else if (e.getActionCommand().equals("cosec")) {
            text2.setText(text2.getText() + "1/Math.sin("+degFactor+"*");
            text.setText(text.getText() + e.getActionCommand() + "(");
        }
        else if (e.getActionCommand().equals("sec")) {
            text2.setText(text2.getText() + "1/Math.cos("+degFactor+"*");
            text.setText(text.getText() + e.getActionCommand() + "(");
        }
        else if (e.getActionCommand().equals("cot")) {
            text2.setText(text2.getText() + "1/Math.tan("+degFactor+"*");
            text.setText(text.getText() + e.getActionCommand() + "(");
        }
        else if (e.getActionCommand().equals("sin-1")) {
            text2.setText(text2.getText() +radFactor+"*" + "Math.asin(");
            text.setText(text.getText() + e.getActionCommand() + "(");
        }
        else if (e.getActionCommand().equals("cos-1")) {
            text2.setText(text2.getText() + radFactor +"*"+ "Math.acos(");
            text.setText(text.getText() + e.getActionCommand() + "(");
        }
        else if (e.getActionCommand().equals("tan-1")) {
            text2.setText(text2.getText() + radFactor+"*"+ "Math.atan(");
            text.setText(text.getText() + e.getActionCommand() + "(");
        }
        else {
            exponential(e);
        }
    }

    private static void exponential(ActionEvent e){

        if (e.getActionCommand().equals("e^x")){
            text2.setText(text2.getText() + "Math.exp(");
            text.setText(text.getText() + "e^"+"(");
        }
        else if (e.getActionCommand().equals("1/x")){
            text2.setText(text2.getText() + "1/(");
            text.setText(text.getText() + "1/(");
        }
        else if (e.getActionCommand().equals("10^x")){
            text2.setText(text2.getText() + "Math.pow(10,");
            text.setText(text.getText() + "10^(");
        }
        else if (e.getActionCommand().equals("X^0.5")){
            text2.setText(text2.getText() + "Math.sqrt(");
            text.setText(text.getText() + "Sqrt(");
        }
        else if (e.getActionCommand().equals("X^2")){
            double leftNum = getNumber(text.getText(),text.getCaretPosition());
            text.setText(text.getText() + "^(2)");
            text2.setText(text2.getText() + Math.pow(leftNum,2));
        }
        else if (e.getActionCommand().equals("X^3")){
            double leftNum = getNumber(text.getText(),text.getCaretPosition());
            text2.setText(text2.getText() + Math.pow(leftNum,3));
            text.setText(text.getText() + "^(3)");
        }
        else if (e.getActionCommand().equals("X^1/3")){
            double leftNum = getNumber(text.getText(),text.getCaretPosition());
            text2.setText(text2.getText() + Math.cbrt(leftNum));
            text.setText(text.getText() + "^(1/3)");
        }
        else if (e.getActionCommand().equals("X^n")){
            nthPower = true;
            expression = getNumber(text.getText(),text.getCaretPosition());
            System.out.println("Expression : "+expression);
            text.setText(text.getText() + "^(");
            text2.setText(text2.getText() + "(");

        }
        else {
            hyperbolic(e);
        }
    }

    private static void hyperbolic(ActionEvent e){

        if (e.getActionCommand().equals("sinh")){
            text2.setText(text2.getText() + "Math.sinh(");
            text.setText(text.getText() + e.getActionCommand()+"(");
        }
        else if (e.getActionCommand().equals("cosh")){
            text2.setText(text2.getText() + "Math.cosh(");
            text.setText(text.getText() + e.getActionCommand()+"(");
        }
        else if (e.getActionCommand().equals("tanh")){
            text2.setText(text2.getText() + "Math.tanh(");
            text.setText(text.getText() + e.getActionCommand()+"(");
        }
        else {
            text.setText(text.getText() + e.getActionCommand());
            text2.setText(text2.getText() + e.getActionCommand());
        }
    }

    private double factorial(int number){
        if (number == 0){
            return 1;
        }
        return number*factorial(number - 1);
    }

    private static double getNumber(String text, int index){
        StringBuilder newText = new StringBuilder(text2.getText());
        StringBuilder leftNum = new StringBuilder();

        if (text.charAt(index-1) == ')') {
            return evalParentheses(text2.getText(), text2.getText().length());
        }
        else {
            for (int i = index - 1; i >= 0; i--) {
                try {
                    String value = String.valueOf(text.charAt(i));
                    if (text.charAt(i) == '.'){
                        validity = false;
                    }
                    else {
                        Integer.parseInt(value);
                    }
                    newText.deleteCharAt(newText.length()-1);
                    text2.setText(String.valueOf(newText));
                    if (i == 0){
                        return Double.parseDouble(text);
                    }
                    leftNum.insert(0, value);  // leftNum = value + leftNum;
                } catch (NumberFormatException e) {
                    text2.setText(String.valueOf(newText));
                    return Double.parseDouble(leftNum.toString());
                }
            }
        }
        return 0;
    }

    private static double evalParentheses(String text, int index){
        StringBuilder newText = new StringBuilder(text2.getText());
        StringBuilder leftNum = new StringBuilder();
        int count = 0;
        for (int i = index-1; i >= 0; i--){
            if (text.charAt(i) == ')'){
                count++;
            }
            else if (text.charAt(i) == '(') {
                count--;
            }
            newText.deleteCharAt(newText.length()-1);
            text2.setText(String.valueOf(newText));
            leftNum.insert(0,text.charAt(i));

            if (count == 0){
                new Calculations(leftNum.toString());
                if (!String.valueOf(Double.parseDouble(Calculations.result)).endsWith(".0")) {
                    validity = false;
                }
                return Double.parseDouble(Calculations.result);
            }
        }
        return 0;
    }
}
