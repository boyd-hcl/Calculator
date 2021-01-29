public class calculator {
	
	public static void main(String[] args) {
		System.out.println("Welcome to calculator! Enter an expression to evaluate it or enker \"k\" when finished");
		String input = "";
		while(!input.equals("k")) {
			input = System.console().readLine();
			if(input.equals("k")) {
				continue;
			}
			System.out.println(recursiveAddStep(input));
		}
	}
	
	public static double recursiveAddStep(String expression) {
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
	
	public static double recursiveMultiplyStep(String expression) {
		for(int i = 0; i < expression.length();i++) {
			if(expression.charAt(i)=='*') {
				return recursiveMultiplyStep(expression.substring(0, i)) * recursiveAddStep(expression.substring(i+1, expression.length()));
			}
			if(expression.charAt(i)=='/') {
				return recursiveMultiplyStep(expression.substring(0, i)) / recursiveAddStep(expression.substring(i+1, expression.length()));
			}
		}
		return (Double.parseDouble(expression));
	}
	
};
