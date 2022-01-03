import java.util.Scanner;

public class B_10258 {
	static long[] count;
	static String inputString;
	static int[] arySwitch;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase;
		int answer = 0;
		count = new long[32];
		arySwitch = new int[32];
		
		testcase = sc.nextInt();
		sc.nextLine();
		
		count[0] = 1;
		for (int i = 0; i < 31; i++) {
			count[i + 1] = 2 * count[i] + 1;
		}
		
		for (int p = 0; p < testcase; p++) {
			inputString = sc.nextLine();
			
			for (int i = 0; i < inputString.length(); i++) {
				arySwitch[i] = (int)(inputString.charAt(i) - '0');
			}
			
			for (int i = inputString.length() - 1; i > 0; i--) {
				if (arySwitch[i] == 1) {
					arySwitch[i - 1] = 0;
					arySwitch[i] = 0;
					answer += count[inputString.length() - 1 - i] + 1;
				}
			}
			
			if (arySwitch[0] == 1) {
				answer += count[inputString.length() - 1];
			}
			
			System.out.println(answer);
			for (int i = 0; i < 32; i++) {
				arySwitch[i] = 0;
			}
			answer = 0;
		}
		
		sc.close();
	}

}
