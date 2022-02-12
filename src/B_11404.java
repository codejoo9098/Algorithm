import java.util.*;
import java.io.*;

public class B_11404 {
	final static int MAX = 1000000000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String input;
		String[] split;
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		int[][] graph = new int[n + 1][n + 1];
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == j) {
					graph[i][j] = 0;
				}
				else {
					graph[i][j] = MAX;
				}
			}
		}
		
		for (int i = 1; i <= m; i++) {
			input = br.readLine();
			split = input.split(" ");
			
			int a = Integer.parseInt(split[0]);
			int b = Integer.parseInt(split[1]);
			int c = Integer.parseInt(split[2]);
			
			graph[a][b] = Math.min(graph[a][b], c);
		}
		
		for (int k = 1; k <= n; k++) {
			for (int a = 1; a <= n; a++) {
				for (int b = 1; b <= n; b++) {
					graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
				}
			}
		}
		
		for (int i = 1; i <= n; i++) {
			
			for (int j = 1; j <= n; j++) {
				if (graph[i][j] == MAX) {
					graph[i][j] = 0;
				}

				System.out.print(graph[i][j] + " ");
			}
			
			System.out.println("");
		}
		
		bw.flush();
		br.close();
		bw.close();
	}

}
