public class calculator {
	public static void main(String[] args) {
		int a = 0;
		int b = 0;
		int i;
		for(i = 0; 0 <= args[0].charAt(i)-'0' && args[0].charAt(i)-'0' <=9 ; i++) {
			a = a*10+args[0].charAt(i)-'0';
		}
		int c = args[0].charAt(i);
		for(i++; i < args[0].length(); i++) {
			b = b*10 + args[0].charAt(i);
		}
		switch (c){
		case '+':
			System.out.println(a+b);
			break;
		case '-':
			System.out.println(a-b);
			break;
		case '*':
			System.out.println(a*b);
			break;
		case '/':
			System.out.println(a/b);
			break;
		}
	}
};
