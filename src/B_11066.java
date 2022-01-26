import java.io.*;

public class B_11066 {
	final static int MAX = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String input = br.readLine();
		int testcase = Integer.parseInt(input);
		String[] split;
		long[] data;
		long[] sum;
		long[][] dp;
		
		for (int tc = 0; tc < testcase; tc++) {
			input = br.readLine();
			int n = Integer.parseInt(input);
			data = new long[n + 1];
			sum = new long[n + 1];
			dp = new long[n + 1][n + 1];
			
			input = br.readLine();
			split = input.split(" ");
			
			for (int i = 1; i <= n; i++) {
				data[i] = Integer.parseInt(split[i - 1]);
				sum[i] = sum[i - 1] + data[i];
			}
			
			for (int k = 1; k <= n; k++) {
				
				for (int from = 1; from + k <= n; from++) {
					int to = from + k;
					dp[from][to] = MAX;
					
					for (int divide = from; divide < to; divide++) {
						dp[from][to] = Math.min(dp[from][to], dp[from][divide] + dp[divide + 1][to] + sum[to] - sum[from - 1]);
					}
				}
			}
			
			bw.write(Long.toString(dp[1][n]) + "\n");
			bw.flush();
		}
		
		br.close();
		bw.close();
	}

}
