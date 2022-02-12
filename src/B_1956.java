import java.util.*;
import java.io.*;

public class B_1956 {
	final static int MAX = 40000000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;
		String[] split;
		
		input = br.readLine();
		split = input.split(" ");
		int v = Integer.parseInt(split[0]);
		int e = Integer.parseInt(split[1]);
		int[][] graph = new int[v + 1][v + 1];
		
		for (int i = 1; i <= v; i++) {
			for (int j = 1; j <= v; j++) {
				if (i == j) {
					graph[i][j] = 0;
				}
				else {
					graph[i][j] = MAX;
				}
			}
		}
		
		for (int i = 0; i < e; i++) {
			input = br.readLine();
			split = input.split(" ");
			
			int a = Integer.parseInt(split[0]);
			int b = Integer.parseInt(split[1]);
			int c = Integer.parseInt(split[2]);
			
			graph[a][b] = c;
		}
		
		for (int k = 1; k <= v; k++) {
			for (int a = 1; a <= v; a++) {
				for (int b = 1; b <= v; b++) {
					graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
				}
			}
		}
		
		int min = MAX;
		for (int i = 1; i <= v; i++) {
			for (int j = 1; j <= v; j++) {
				if (i != j) {
					min = Math.min(graph[i][j] + graph[j][i], min);
				}
			}
		}
		
		if (min >= MAX) {
			System.out.println(-1);
		}
		else {
			System.out.println(min);
		}
		
		br.close();
	}

}
