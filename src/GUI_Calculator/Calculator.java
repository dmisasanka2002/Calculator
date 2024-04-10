package GUI_Calculator;

public class Calculator {

    static basicCalFrame frame;
    static String mode = "basic";
    Calculator(){
        frame = new basicCalFrame();
    }

    public static void main(String[] args) {
        frame = new basicCalFrame();
    }
}
