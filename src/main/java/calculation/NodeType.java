package calculation;

import calculation.calculations.*;

public enum NodeType implements Typical {

    //    @formatter:off
    BRACKET_IN {
        @Override public int getPriority() {return this.ordinal()>>1;}
        @Override public void interact() {
        }},
    BRACKET_OUT {
        @Override public int getPriority() {return this.ordinal()>>1;}
        @Override public void interact() {
        }},
    EXPONENT {
        @Override public int getPriority() {return this.ordinal()>>1;}
        @Override public void interact() {new Calculation_Exponentiation(this);}},
    ROOT {
        @Override public int getPriority() {return this.ordinal()>>1;}
        @Override public void interact() {new Calculation_Rooting(this);}},
    MULTIPLY {
        @Override public int getPriority() {return this.ordinal()>>1;}
        @Override public void interact() {new Calculation_Multiplication(this);}},
    DIVIDE {
        @Override public int getPriority() {return this.ordinal()>>1;}
        @Override public void interact() {new Calculation_Division(this);}},
    ADD {
        @Override public int getPriority() {return this.ordinal()>>1;}
        @Override public void interact() {new Calculation_Addition(this);}},
    SUBTRACT {
        @Override public int getPriority() {return this.ordinal()>>1;}
        @Override public void interact() {new Calculation_Subtraction(this);}},
    VALUE {
        @Override public int getPriority() {return this.ordinal()>>1;}
        @Override public void interact() {new Value(this);}},
    SPIN {
        @Override public int getPriority() {return this.ordinal()>>1;}
        @Override public void interact() {}},
    EVALUATE {
        @Override public int getPriority() {return this.ordinal()>>1;}
        @Override public void interact() {
        }},
    CLEAR {
        @Override public int getPriority() {return this.ordinal()>>1;}
        @Override public void interact() {
        }},
    UNDO{
        @Override public int getPriority() {return this.ordinal()>>1;}
        @Override public void interact(){}}
    //        @formatter:on
}

/*
 * https://stackoverflow.com/questions/18883646/java-enum-methods
 * https://www.developer.com/java/data/seven-ways-to-refactor-java-switch-statements.html
 *
 * */