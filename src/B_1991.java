import java.util.Scanner;

public class B_1991 {
	static int[][] num;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		
		String inputString;
		char parent;
		
		num = new int[n][2];
		for (int i = 0; i < n; i++) {
			inputString = sc.nextLine();
			
			parent = inputString.charAt(0);
			num[parent - 'A'][0] = inputString.charAt(2);
			num[parent - 'A'][1] = inputString.charAt(4);
		}

		preOrder(0);
		System.out.println("");
		inOrder(0);
		System.out.println("");
		postOrder(0);
		sc.close();
	}
	
	public static void preOrder(int cur) {
		System.out.print((char)(cur + 'A'));
		if (num[cur][0] != '.') {
			preOrder(num[cur][0] - 'A');
		}
		if (num[cur][1] != '.') {
			preOrder(num[cur][1] - 'A');
		}
	}
	
	public static void inOrder(int cur) {
		if (num[cur][0] != '.') {
			inOrder(num[cur][0] - 'A');
		}
		System.out.print((char)(cur + 'A'));
		if (num[cur][1] != '.') {
			inOrder(num[cur][1] - 'A');
		}
	}
	
	public static void postOrder(int cur) {
		if (num[cur][0] != '.') {
			postOrder(num[cur][0] - 'A');
		}
		if (num[cur][1] != '.') {
			postOrder(num[cur][1] - 'A');
		}
		System.out.print((char)(cur + 'A'));
	}

}
