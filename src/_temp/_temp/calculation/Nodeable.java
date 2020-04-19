package _temp.calculation;

import java.util.Arrays;
import static _temp.gui.Settings.*;

public interface Nodeable {

    static void dupa(char c) {
        System.out.println("dupa");
    }

    static void NodeSelection(char c) {
        if (isValidSign(numberSigns, c) != -1) ;                                     //  new ValueParser(button.getText().charAt(0));     // ! method instead of constructor ?
    }

    static int isValidSign(char[] signArray, char c) {
        return Arrays.toString(signArray).indexOf(c);
    }
}