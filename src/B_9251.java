import java.util.*;

public class B_9251 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String first = sc.nextLine();
		String second = sc.nextLine();
		
		int firstLength = first.length();
		int secondLength = second.length();
		int[][] dp = new int[firstLength + 1][secondLength + 1];
		
		for (int i = 1; i <= firstLength; i++) {
			
			for (int j = 1; j <= secondLength; j++) {
				if (first.charAt(i - 1) != second.charAt(j - 1)) {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
				else {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				}
			}
		}
		
		System.out.println(dp[firstLength][secondLength]);
		sc.close();
	}

}
