import java.util.ArrayDeque;
import java.util.Scanner;

public class B_4949 {

	public static void main(String[] args) {
		String str;
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			str = sc.nextLine();
			
			if (str.equals(".")) {
				break;
			}
			
			System.out.println(checkBalanced(str));
		}
		
		sc.close();

	}
	
	public static String checkBalanced(String str) {
		boolean isBalanced = true;
		ArrayDeque<String> stack = new ArrayDeque<>();
	
		
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(') {
				stack.addFirst("(");
			}
			
			if (str.charAt(i) == '[') {
				stack.addFirst("[");
			}
			
			try {
				if (str.charAt(i) == ')') {
					
					if (stack.getFirst().equals("(")) {
						stack.removeFirst();
					}
					else {
						isBalanced = false;
						break;
					}
				}
				
				
				if (str.charAt(i) == ']') {
					
					if (stack.getFirst().equals("[")) {
						stack.removeFirst();
					}
					else {
						isBalanced = false;
						break;
					}
				}
			} catch (Exception e) {
				isBalanced = false;
				break;
			}
		}
		
		if (!(stack.isEmpty())) {
			isBalanced = false;
		}
		
		if (isBalanced) {
			return "yes";
		}
		else {
			return "no";
		}
	}

}
