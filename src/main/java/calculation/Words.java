package calculation;

import calculation.calculations.*;

public enum Words {

    BRACKET_IN {
        @Override
        public void interact() {
        }
    },
    BRACKET_OUT {
        @Override
        public void interact() {
        }
    },
    EXPONENT {
        @Override
        public void interact() {
            new Calculation_Exponentiation();
        }
    },
    ROOT {
        @Override
        public void interact() {
            new Calculation_Rooting();
        }
    },
    MULTIPLY {
        @Override
        public void interact() {
            new Calculation_Multiplication();
        }
    },
    DIVIDE {
        @Override
        public void interact() {
            new Calculation_Division();
        }
    },
    ADD {
        @Override
        public void interact() {
            new Calculation_Addition();
        }
    },
    SUBTRACT {
        @Override
        public void interact() {
            new Calculation_Subtraction();
        }
    },
    VALUE {
        @Override
        public void interact() {
            new Value();
        }
    },
    EVALUATE {
        @Override
        public void interact() {
        }
    },
    CLEAR {
        @Override
        public void interact() {
        }
    },
    SIGN {
        @Override
        public void interact() {
        }
    };

    public abstract void interact();
}

/*
 * https://stackoverflow.com/questions/18883646/java-enum-methods
 * https://www.developer.com/java/data/seven-ways-to-refactor-java-switch-statements.html
 *
 * */