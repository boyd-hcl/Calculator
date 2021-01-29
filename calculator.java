public class calculator {
	
	public static void main(String[] args) {
		System.out.println("Welcome to calculator! \n"
				+ "This calculator supports extended expressions with addition, subtraction, multiplication, division, and exponents. \n"
				+ "Enter an expression to evaluate it or enker \"k\" when finished");
		String input = "";
		while(!input.equals("k")) {
			input = System.console().readLine();
			if(input.equals("k")) {
				continue;
			}
			System.out.println(recursiveAddStep(input));
		}
	}
	
	private static double recursiveAddStep(String expression) {
		for(int i = 0; i < expression.length(); i++) {
			if(expression.charAt(i)=='+') {
				return recursiveMultiplyStep(expression.substring(0, i)) + recursiveAddStep(expression.substring(i+1, expression.length()));
			}
			if(expression.charAt(i)=='-') {
				return recursiveMultiplyStep(expression.substring(0, i)) - recursiveAddStep(expression.substring(i+1, expression.length()));
			}
		}
		return recursiveMultiplyStep(expression);
	}
	
	private static double recursiveMultiplyStep(String expression) {
		for(int i = 0; i < expression.length();i++) {
			if(expression.charAt(i)=='*') {
				return recursiveMultiplyStep(expression.substring(0, i)) * recursiveMultiplyStep(expression.substring(i+1, expression.length()));
			}
			if(expression.charAt(i)=='/') {
				return recursiveMultiplyStep(expression.substring(0, i)) / recursiveMultiplyStep(expression.substring(i+1, expression.length()));
			}
		}
		return (recursiveExponentStep(expression));
	}
	
	
	private static double ln(double value) {
		if(value < 0) {
			return ln( 0 - value);
		}
		double logBase = 0;
		while(value > 10.0) {
			value/=2.718281828;
			logBase+=1;
		}
		double logPart = 1;
		double logPartPart = -1;
		for(int i = 0; i < 20; i++) {
			logPartPart/=value;
			logPartPart*=-1;
			logPartPart/=(i+1);
			logPart+=logPartPart;
		}
		return logBase+logPart;
	}
	
	public static double mToTheB(double m, double b) {
		double result = 1;
		for(int i = 0; i < (int) b; i++) {
			result *= m;
		}
		double fractionalPartOfB = b - (int)b;
		double term = 1;
		double logm = ln(m);
		double partExp = 1;
		for(int i = 1; i < m; i++) {
			partExp += term;
			term *= logm * fractionalPartOfB / i;
		}
		return result*partExp/2;
	}
	
	public static double recursiveExponentStep(String expression) {
		for(int i = 0; i < expression.length(); i++) {
			if(expression.charAt(i) == '^') {
				return mToTheB(Double.parseDouble(expression.substring(0, i)), recursiveExponentStep(expression.substring(i+1, expression.length())));
			}
		}
		return Double.parseDouble(expression);
	}
	
};
