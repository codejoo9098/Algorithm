
import java.util.Scanner;
import java.util.Stack;

public class B_1406 {

	public static void main(String[] args) {
		Stack<Character> leftStack = new Stack<>();
		Stack<Character> rightStack = new Stack<>();
		String str;
		char command;
		char alpha;
		int testcase;
		Scanner sc = new Scanner(System.in);
		
		str = sc.nextLine();
		
		for (int i = 0; i < str.length(); i++) {
			leftStack.push(str.charAt(i));
		}
		
		testcase = sc.nextInt();
		sc.nextLine();
		
		for (int i = 0; i < testcase; i++) {
			command = sc.next().charAt(0);
			
			if (command == 'L') {
				
				if (!leftStack.isEmpty()) {
					rightStack.push(leftStack.pop());
				}
				
			}
			else if (command == 'D') {
				
				if (!rightStack.isEmpty()) {
					leftStack.push(rightStack.pop());
				}
				
			}
			else if (command == 'B') {
				
				if (!leftStack.isEmpty()) {
					leftStack.pop();
				}
				
			}
			else if (command == 'P') {
				alpha = sc.next().charAt(0);
				
				leftStack.push(alpha);
			}
			
			sc.nextLine();
		}
		
		while(!leftStack.isEmpty()) {
			rightStack.push(leftStack.pop());
		}
		
		while (!rightStack.isEmpty()) {
			System.out.print(rightStack.pop());
		}
		
		sc.close();
	}

}
