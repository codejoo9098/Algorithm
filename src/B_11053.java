import java.util.Scanner;

public class B_11053 {

	public static void main(String[] args) {
		int[] dp = new int[1001];
		Scanner sc = new Scanner(System.in);
		int maxCase;
		int testcase = sc.nextInt();
		sc.nextLine();
		int[] seq = new int[testcase];
		
		dp[0] = 1;

		for (int i = 0; i < testcase; i++) {
			seq[i] = sc.nextInt();
		}
		
		for (int i = 0; i < testcase; i++) {
			maxCase = dp[0];
			
			for (int j = 0; j < i; j++) {
				
				if (seq[j] < seq[i]) {
					
					if (maxCase <= dp[j]) {
						maxCase = dp[j] + 1;
					}
				}
			}
			
			dp[i] = maxCase;
		}
		
		int max = 0;
		for (int i = 0; i < testcase; i++) {
			if (max <= dp[i]) {
				max = dp[i];
			}
		}
		System.out.println(max);
		sc.close();
	}

}
