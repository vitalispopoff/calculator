package logic;

public interface Solvable {

	default double solve (double op1, double op2){return Double.NaN;}
}