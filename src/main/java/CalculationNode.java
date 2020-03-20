public class CalculationNode extends CalculationTree {

    CalculationNode(){
        super();
    }

    CalculationNode(double value){
        super(value);
    }

    @Override
    double setValue(){return value;}
}
