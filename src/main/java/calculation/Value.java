package calculation;

public class Value extends Node {

/*    public Value() {
        super();
    }*/

    public Value(Typical type, Double value){
        super();
        this.type = type;
        this.value = value;
    }

    public Value(Typical type) {
        super(type);
    }

    @Override
    protected Double calculate(Nodeable localLeft, Nodeable localRite) {
        return value;
    }
}