package GUI_Calculator;

import jdk.jshell.JShell;

public class Calculations {
    static String result;

    Calculations(String expression){
        JShell shell = JShell.builder().build();

        result = shell.eval(expression).get(0).value();
    }
}
