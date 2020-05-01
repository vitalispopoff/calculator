package calculation;

import calculation.calculations.*;

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
            Nodeable cache = new Calculation_Exponentiation();
            cache.setType(this);
            return cache;
        }
    },
    ROOT {
        @Override
        public Nodeable interact() {
            Nodeable cache = new Calculation_Rooting();
            cache.setType(this);
            return cache;
        }
    },
    MULTIPLY {
        @Override
        public Nodeable interact() {
            Nodeable cache = new Calculation_Multiplication();
            cache.setType(this);
            return cache;
        }
    },
    DIVIDE {
        @Override
        public Nodeable interact() {
            Nodeable cache = new Calculation_Division();
            cache.setType(this);
            return cache;
        }
    },
    ADD {
        @Override
        public Nodeable interact() {
            Nodeable cache = new Calculation_Addition();
            cache.setType(this);
            return cache;
        }
    },
    SUBTRACT {
        @Override
        public Nodeable interact() {
            Nodeable cache = new Calculation_Subtraction();
            cache.setType(this);
            return cache;
        }
    },
    VALUE {
        @Override
        public Nodeable interact() {
            Nodeable cache =new Value();
            cache.setType(this);
            return cache;
        }
    },
    SPIN {
        @Override
        public Nodeable interact() {
            Value.currentValue.switchSign();
            return Value.currentValue;
        }
    },
    EVALUATE {
        @Override
        public Nodeable interact() {
            return null;
        }
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