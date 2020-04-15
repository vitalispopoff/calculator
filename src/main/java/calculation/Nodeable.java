package calculation;

import java.util.Arrays;
import static gui.Settings.*;

public interface Nodeable {

    static void dupa(char c) {
        System.out.println("dupa");
    }

    static void NodeSelection(char c) {
        if (isValidSign(numberSigns, c) != -1)
            ;                                     //  new ValueParser(button.getText().charAt(0));     // ! method instead of constructor ?
        /*else {
            switch (isValidSign(operationSigns, '&')) {
                case 0:                                                             //  new Queuer((Node) new Calculation_Multiplication());System.out.println("multiplication button clicked");

                    break;
                case 1:                                                             //  new Queuer((Node) new Calculation_Addition());System.out.println("addition button clicked");

                    break;
                case 2:                                                             //  new Queuer((Node) new Calculation_Subtraction());System.out.println("subtraction button clicked");

                    break;
                case 3:                                                             //  new Queuer((Node) new Calculation_Division());System.out.println("division button clicked");

                    break;
                case 4:                                                             //  mainRoot.setValue();  // TODO equals (exec calculation)break;

                    break;
                case 5:                                                             //  System.out.println(getLocationOnScreen());    // TODO clear

                    break;
                case 6:                                                             //  new Queuer((Node) new Calculation_Exponentiation());System.out.println("exponentiation button clicked");

                    break;
                case 7:                                                             //  new Queuer((Node) new Calculation_Rooting());System.out.println("rooting button clicked");

                    break;
            }
        }*/     // disposable
    }

    static int isValidSign(char[] signArray, char c) {
        return Arrays.toString(signArray).indexOf(c);
    }
}