package calculation;

public enum Words {

    BRACKET_IN {
        @Override
        public void interact() {
            new Node();
        }
    },
    BRACKET_OUT {
        @Override
        public void interact() {
            new Node();
        }
    },
    EXPONENT {
        @Override
        public void interact() {
            new Node();
        }
    },
    ROOT {
        @Override
        public void interact() {
            new Node();
        }
    },
    MULTIPLY {
        @Override
        public void interact() {
            new Node();
        }
    },
    DIVIDE {
        @Override
        public void interact() {
            new Node();
        }
    },
    ADD {
        @Override
        public void interact() {
            new Node();
        }
    },
    SUBTRACT {
        @Override
        public void interact() {
            new Node();
        }
    },
    VALUE {
        @Override
        public void interact() {
            new Node();
        }
    },
    EVALUATE {
        @Override
        public void interact() {
            new Node();
        }
    },
    CLEAR {
        @Override
        public void interact() {
            new Node();
        }
    },
    SIGN {
        @Override
        public void interact() {
            new Node();
        }
    };

    public abstract void interact();
}

/*
 * https://stackoverflow.com/questions/18883646/java-enum-methods
 * https://www.developer.com/java/data/seven-ways-to-refactor-java-switch-statements.html
 *
 * */