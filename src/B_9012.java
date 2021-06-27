import java.util.ArrayDeque;
import java.util.Scanner;

public class B_9012 {

	public static void main(String[] args) {
		int num;
		Scanner sc = new Scanner(System.in);

		num = sc.nextInt();
		sc.nextLine();
		
		String[] str = new String[num];
		
		for (int i = 0; i < num; i++) {
			str[i] = sc.nextLine();
			System.out.println(checkVPS(str[i]));
		}
		
		sc.close();
	}
	
	public static String checkVPS(String str) {
		boolean isVPS = true;
		ArrayDeque<String> stack = new ArrayDeque<>();
		
		for (int i = 0; i < str.length(); i++) {
			try {
				
				if (str.charAt(i) == '(') {
					stack.addFirst("(");
				}
				else {
					stack.removeFirst();
				}
				
			} catch (Exception e) {
				isVPS = false;
				break;
			}
			
		}
		
		if (stack.size() != 0) {
			isVPS = false;
		}
		
		if (isVPS) {
			return "YES";
		}
		else {
			return "NO";
		}
	}

}
