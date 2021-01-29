public class calculator {
	
	public static void main(String[] args) {
		System.out.println("Welcome to calculator! \n"
				+ "This calculator supports extended expressions with addition, subtraction, multiplication, and division. \n"
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
		for(int i = expression.length()-1; i > 0; i--) {
			if(expression.charAt(i)=='+') {
				return recursiveAddStep(expression.substring(0, i)) + recursiveMultiplyStep(expression.substring(i+1, expression.length()));
			}
			if(expression.charAt(i)=='-') {
				return recursiveAddStep(expression.substring(0, i)) - recursiveMultiplyStep(expression.substring(i+1, expression.length()));
			}
		}
		return recursiveMultiplyStep(expression);
	}
	
	private static double recursiveMultiplyStep(String expression) {
		for(int i = expression.length()-1; i > 0;i--) {
			if(expression.charAt(i)=='*') {
				return recursiveMultiplyStep(expression.substring(0, i)) * Double.parseDouble(expression.substring(i+1, expression.length()));
			}
			if(expression.charAt(i)=='/') {
				return recursiveMultiplyStep(expression.substring(0, i)) / Double.parseDouble(expression.substring(i+1, expression.length()));
			}
		}
		return (Double.parseDouble(expression));
	}
	
	
};
