package data;

public enum Type /*implements logic.Solvable*/ {

//	@formatter:off

//	0 : brackets  \\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

	BRACKET_IN	{ public double solve (double operand1, double operand2) { return Double.NaN; } },
	BRACKET_OUT	{ public double solve (double operand1, double operand2) { return Double.NaN; } },

//	1 : exponential //\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

	EXPONENT	{ public double solve (double operand1, double operand2) { return Math.pow(operand1, operand2); } },
	ROOT		{ public double solve (double operand1, double operand2) { return Math.pow(operand1, 1. / operand2); } },

//	multiplication  //\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

	MULTIPLY 	{ public double solve (double operand1, double operand2) { return operand1 * operand2; } },
	DIVIDE 		{ public double solve (double operand1, double operand2) { return operand1 / operand2; } },

//	addition  \\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

	ADD 		{ public double solve (double operand1, double operand2) { return operand1 + operand2; } },
	SUBTRACT 	{ public double solve (double operand1, double operand2) { return operand1 - operand2; } },

//	evaluation  //\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

	VALUE 		{ public double solve (double operand1, double operand2) { return Double.NaN; } },
	EVALUATE 	{ public double solve (double operand1, double operand2) { return Double.NaN; } }

//	@formatter:on

}