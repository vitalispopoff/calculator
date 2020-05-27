package logic;

//	@formatter:off

public enum Type implements /*logic.*/Solvable {

//	0 : brackets  \\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

	BRACKET_IN,
	BRACKET_OUT,

//	1 : exponential //\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

	EXPONENT	{ @Override public double solve (double op1, double op2) { return Math.pow(op1, op2); } },
	ROOT		{ @Override public double solve (double op1, double op2) { return Math.pow(op1, 1. / op2); } },

//	2: multiplication  //\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

	MULTIPLY 	{ @Override public double solve (double op1, double op2) { return op1 * op2; } },
	DIVIDE 		{ @Override public double solve (double op1, double op2) { return op1 / op2; } },

//	3 : addition  \\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

	ADD 		{ @Override public double solve (double op1, double op2) { return op1 + op2; } },
	SUBTRACT 	{ @Override public double solve (double op1, double op2) { return op1 - op2; } },

//	4 : evaluation  //\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

	VALUE,
	EVALUATE

//	@formatter:on

}