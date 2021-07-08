import java.util.ArrayDeque;
import java.util.Scanner;

public class B_1935 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayDeque<Double> stack = new ArrayDeque<>();
		int size = sc.nextInt();
		sc.nextLine();
		int[] num = new int[size];
		
		String str = sc.nextLine();
		for (int i = 0; i < size; i++) {
			num[i] = sc.nextInt();
		}

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
				stack.addLast((double) num[str.charAt(i) - 'A']);
			}
			else if (str.charAt(i) == '+'){
				double temp = stack.removeLast();
				stack.addLast(stack.removeLast() + temp);
			}
			else if (str.charAt(i) == '-'){
				double temp = stack.removeLast();
				stack.addLast(stack.removeLast() - temp);
			}
			else if (str.charAt(i) == '*') {
				double temp = stack.removeLast();
				stack.addLast(stack.removeLast() * temp);
			}
			else if (str.charAt(i) == '/') {
				double temp = stack.removeLast();
				stack.addLast(stack.removeLast() / temp);
			}
		}
		
		System.out.printf("%.2f", stack.removeLast());
		sc.close();
	}

}
