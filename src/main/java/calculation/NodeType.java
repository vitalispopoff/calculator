package calculation;

import static memory.Memory.*;

import gui.Button;
import memory.Memory;
import calculation.calculations.*;

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
         new Calculation_Exponentiation(button);
        }
    },
    ROOT {
        @Override
        public void interact(Button button) {
           new Calculation_Rooting(button);
        }
    },
    MULTIPLY {
        @Override
        public void interact(Button button) {
             new Calculation_Multiplication(button);
        }
    },
    DIVIDE {
        @Override
        public void interact(Button button) {
            new Calculation_Division(button);
        }
    },
    ADD {
        @Override
        public void interact(Button button) {
            new Calculation_Addition(button);
        }
    },
    SUBTRACT {
        @Override
        public void interact(Button button) {
             new Calculation_Subtraction(button);
        }
    },
    VALUE {
        @Override
        public void interact(Button button) {
            Memory.addToParserCache(button.getSymbol());
        }
    },
    SPIN {
        @Override
        public void interact(Button button) {
            if (button.getType() == this) Memory.switchSign();
        }
    },
    EVALUATE {
        @Override
//        public void interact(Button button) { return new Value(this/*::interact*/); } // !TODO this::interact calls for closer inspection !
        public void interact(Button button) {
            Nodeable.dumpParserCache();
            mainQueue.convertToTree();
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