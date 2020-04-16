package _temp.input;

import _temp.calculation.Node;
import _temp.calculation.calculations.*;

import static _temp.calculation.Node.*;

public enum Symbol {
    CLEAR,
    EXPONENTIAL {
        public Node Symbol() {
            return new Calculation_Exponentiation();
        }
    },
    ROOT {
        public Node Symbol() {
            return new Calculation_Rooting();
        }
    },
    DIVIDE {
        public Node Symbol() {
            return new Calculation_Exponentiation();
        }
    },
    SEVEN {
        public void Symbol() {
            new ValueParser('7');
        }
    },
    EIGHT {
        public void Symbol() {
            new ValueParser('8');
        }
    },
    NINE {
        public void Symbol() {
            new ValueParser('9');
        }
    },
    MULTIPlY {
        public Node Symbol() {
            return new Calculation_Multiplication();
        }
    },
    FOUR {
        public void Symbol() {
            new ValueParser('4');
        }
    },
    FIVE {
        public void Symbol() {
            new ValueParser('5');
        }
    },
    SIX {
        public void Symbol() {
            new ValueParser('6');
        }
    },
    ADD {
        public Node Symbol() {
            return new Calculation_Addition();
        }
    },
    ONE {
        public void Symbol() {
            new ValueParser('1');
        }
    },
    TWO {
        public void Symbol() {
            new ValueParser('2');
        }
    },
    THREE {
        public void Symbol() {
            new ValueParser('3');
        }
    },
    SUBTRACT {
        public Node Symbol() {
            return new Calculation_Subtraction();
        }
    },
    NEGATIVE {
        public Node Symbol() {
            return new Calculation_Exponentiation();
        }
    },
    ZERO {
        public void Symbol() {
            new ValueParser('0');
        }
    },
    POINT {
        public void Symbol() {
            new ValueParser('.');
        }
    },
    EQUALS {
        public double Symbol() {
            return mainRoot.getValue();
        }
    },
}

// https://www.developer.com/java/data/seven-ways-to-refactor-java-switch-statements.html
