package calculation;

public class Value extends Node {

    Value(double value) {super(value);}

    //    @formatter:off
    Value() {super();}
    Value(Node left, Node rite) {System.out.println("wrong constructor");}
    //    @formatter:on

}