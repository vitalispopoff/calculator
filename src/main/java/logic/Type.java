package logic;

public enum Type implements logic.Solvable {

//	@formatter:off

//	0 : brackets  \\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

	BRACKET_IN	{ @Override public double solve (double operand1, double operand2) { return Double.NaN; } },
	BRACKET_OUT	{ @Override public double solve (double operand1, double operand2) { return Double.NaN; } },

//	1 : exponential //\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

	EXPONENT	{ @Override public double solve (double operand1, double operand2) { return Math.pow(operand1, operand2); } },
	ROOT		{ @Override public double solve (double operand1, double operand2) { return Math.pow(operand1, 1. / operand2); } },

//	2: multiplication  //\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

	MULTIPLY 	{ @Override public double solve (double operand1, double operand2) { return operand1 * operand2; } },
	DIVIDE 		{ @Override public double solve (double operand1, double operand2) { return operand1 / operand2; } },

//	3 : addition  \\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

	ADD 		{ @Override public double solve (double operand1, double operand2) { return operand1 + operand2; } },
	SUBTRACT 	{ @Override public double solve (double operand1, double operand2) { return operand1 - operand2; } },

//	4 : evaluation  //\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

	VALUE 		{ @Override public double solve (double operand1, double operand2) { return Double.NaN; } },
	EVALUATE 	{ @Override public double solve (double operand1, double operand2) { return Double.NaN; } }

//	@formatter:on

}