package calculation;

public enum Words {

    ADD{
        @Override
        public Nodeable dupa(){
            return new Node();
        }
    },
    VALUE{
        @Override
        public Nodeable dupa(){
            return new Node();
        }
    };

    public abstract Nodeable dupa();
}

/*
* https://stackoverflow.com/questions/18883646/java-enum-methods
* https://www.developer.com/java/data/seven-ways-to-refactor-java-switch-statements.html
*
* */