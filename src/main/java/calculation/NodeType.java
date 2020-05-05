package calculation;

import gui.Button;

public enum NodeType implements Typical {


    BRACKET_IN {
        @Override
        public void interact(Button button) {
        }
    },
    BRACKET_OUT {
        @Override
        public void interact(Button button) {
        }
    },
    EXPONENT {
        @Override
        public void interact(Button button) {
//            return new Calculation_Exponentiation(this);
        }
    },
    ROOT {
        @Override
        public void interact(Button button) {
//            return new Calculation_Rooting(this);
        }
    },
    MULTIPLY {
        @Override
        public void interact(Button button) {
//            return new Calculation_Multiplication(this);
        }
    },
    DIVIDE {
        @Override
        public void interact(Button button) {
//            return new Calculation_Division(this);
        }
    },
    ADD {
        @Override
        public void interact(Button button) {
//            return new Calculation_Addition(this);
        }
    },
    SUBTRACT {
        @Override
        public void interact(Button button) {
//            return new Calculation_Subtraction(this);
        }
    },
    VALUE {
        @Override
        public void interact(Button button) {
//            return new Value(this);
        }
    },
    SPIN {
        @Override
        public void interact(Button button) {
//            return new Value(this);
        }
    },
    EVALUATE {
        @Override
//        public void interact(Button button) { return new Value(this/*::interact*/); } // !TODO this::interact calls for closer inspection !
        public void interact(Button button) {
//            Nodeable cache = new Value(this, mainQueue.convertToTree());
//            MainPanel.display.setText(mainQueue.convertToTree().toString());
//            return null;
        }
    },
    CLEAR {
        @Override
        public void interact(Button button) {
//            return null;
        }
    },
    UNDO {
        @Override
        public void interact(Button button) {
//            return null;
        }
    }

}