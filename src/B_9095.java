
import java.util.Scanner;

public class B_9095 {
	static int[] dp = new int[12];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		int num[] = new int[testcase];
		
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		
		for (int i = 0; i < testcase; i++) {
			num[i] = sc.nextInt();
			System.out.println(getCases(num[i]));
		}
		
		sc.close();
	}

	private static int getCases(int n) {
		if (n == 1) {
			return dp[1];
		}
		if (n == 2) {
			return dp[2];
		}
		if (n == 3) {
			return dp[3];
		}
		
		if (dp[n] != 0) {
			return dp[n];
		}
		else {
			dp[n] = getCases(n - 1) + getCases(n - 2) + getCases(n - 3);
			return dp[n];
		}
	}

}
