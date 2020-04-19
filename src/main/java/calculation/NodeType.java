package calculation;

import calculation.calculations.*;

public enum NodeType implements Typical {

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
            new Calculation_Exponentiation(this);
        }
    },
    ROOT {
        @Override
        public void interact() {
            new Calculation_Rooting(this);
        }
    },
    MULTIPLY {
        @Override
        public void interact() {
            new Calculation_Multiplication(this);
        }
    },
    DIVIDE {
        @Override
        public void interact() {
            new Calculation_Division(this);
        }
    },
    ADD {
        @Override
        public void interact() {
            new Calculation_Addition(this);
        }
    },
    SUBTRACT {
        @Override
        public void interact() {
            new Calculation_Subtraction(this);
        }
    },
    VALUE {
        @Override
        public void interact() {
            new Value(this);
        }
    },
    SPIN {
        @Override
        public void interact() {
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
    UNDO {
        @Override
        public void interact() {
        }
    };

    @Override
    public int getPriority() {
        return this.ordinal() >> 1;
    }
}

/*
 * https://stackoverflow.com/questions/18883646/java-enum-methods
 * https://www.developer.com/java/data/seven-ways-to-refactor-java-switch-statements.html
 * */