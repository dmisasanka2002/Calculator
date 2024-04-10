package GUI_Calculator;

import java.io.*;
import java.util.Scanner;

import static GUI_Calculator.Buttons.pastCalcList;
import static GUI_Calculator.history.historyClear;

public class pastCalc {
    String expression;
    static File file = new File("C:\\Users\\Sasanka\\Desktop\\Java\\History.txt");
    pastCalc(){
        pastCalcReader();
    }
    pastCalc(String expression){
        this.expression = expression;
        try (FileReader reader = new FileReader("C:\\Users\\Sasanka\\Desktop\\Java\\History.txt");
            LineNumberReader lineReader = new LineNumberReader(reader)) {
            lineReader.skip(Long.MAX_VALUE);

            if ((!expression.split("=")[1].strip().equals("null"))){
                pastCalcWriter(expression);
            }

        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    private void deleteLine() {

        new pastCalc(expression);
    }

    private void pastCalcReader() {

        try (Scanner reader = new Scanner(new File("C:\\Users\\Sasanka\\Desktop\\Java\\History.txt"))) {

            pastCalcList.clear();
            while (reader.hasNextLine()) {
                pastCalcList.add(0,reader.nextLine());
                //System.out.println(reader.nextLine());
            }
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void pastCalcWriter(String expression) {
        try (FileWriter writer = new FileWriter("C:\\Users\\Sasanka\\Desktop\\Java\\History.txt",true)) {
            writer.append(expression).append("\n");
            try {
                historyClear.setEnabled(true);
            }
            catch (Exception ignored){}

        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    protected static void clearFile() {


        try {
            file.delete();
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
