public class calculator {
	
	public static void main(String[] args) {
		System.out.println("Welcome to calculator! Enter an expression to evaluate it or enker \"k\" when finished");
		String input = "";
		while(!input.equals("k")) {
			input = System.console().readLine();
			if(input.equals("k")) {
				continue;
			}
			System.out.println(processExpression(input));
		}
	}
	
	public static double processExpression(String expression) {
		int a = 0;
		int b = 0;
		int i;
		for(i = 0; 0 <= expression.charAt(i)-'0' && expression.charAt(i)-'0' <=9 ; i++) {
			a = a*10+expression.charAt(i)-'0';
		}
		int c = expression.charAt(i);
		for(i++; i < expression.length(); i++) {
			b = b*10 + expression.charAt(i)-'0';
		}
		switch (c){
		case '+':
			return (a+b);
		case '-':
			return (a-b);
		case '*':
			return (a*b);
		case '/':
			return (a/b);
		}
		return 0;
	}
	
};
