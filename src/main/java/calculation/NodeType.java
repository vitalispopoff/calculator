package calculation;

import calculation.calculations.*;

import static memory.Memory.mainQueue;

public enum NodeType implements Typical {


    BRACKET_IN {
        @Override
        public Nodeable interact() {
            return null;
        }
    },
    BRACKET_OUT {
        @Override
        public Nodeable interact() {
            return null;
        }
    },
    EXPONENT {
        @Override
        public Nodeable interact() {
            return new Calculation_Exponentiation(this);
        }
    },
    ROOT {
        @Override
        public Nodeable interact() {
            return new Calculation_Rooting(this);
        }
    },
    MULTIPLY {
        @Override
        public Nodeable interact() {
            return new Calculation_Multiplication(this);
        }
    },
    DIVIDE {
        @Override
        public Nodeable interact() {
            return new Calculation_Division(this);
        }
    },
    ADD {
        @Override
        public Nodeable interact() {
            return new Calculation_Addition(this);
        }
    },
    SUBTRACT {
        @Override
        public Nodeable interact() {
            return new Calculation_Subtraction(this);
        }
    },
    VALUE {
        @Override
        public Nodeable interact() {
            return new Value(this);
        }
    },
    SPIN {
        @Override
        public Nodeable interact() {
            return new Value(this);
        }
    },
    EVALUATE {
        @Override
        public Nodeable interact() { return null; }
    },
    CLEAR {
        @Override
        public Nodeable interact() {
            return null;
        }
    },
    UNDO {
        @Override
        public Nodeable interact() {
            return null;
        }
    }

}