package dfsbfs;
import java.util.*;

public class IceDrink {
	final static int[] dx = {1, -1, 0, 0};
	final static int[] dy = {0, 0, 1, -1};
	
	static char[][] map = new char[1005][1005];
	static boolean[][] visitedMap = new boolean[1005][1005];
	static int n, m;
	static int answer = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input;

		n = sc.nextInt();
		m = sc.nextInt();
		sc.nextLine();
		
		for (int i = 0; i < n; i++) {
			input = sc.nextLine();
			
			for (int j = 0; j < m; j++) {
				map[i][j] = input.charAt(j);
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == '0' && !visitedMap[i][j]) {
					dfs(i, j);
					answer++;
				}
			}
		}
		
		System.out.println(answer);
		sc.close();
	}
	
	public static void dfs(int row, int column) {
		visitedMap[row][column] = true;
		
		for (int i = 0; i < 4; i++) {
			int nx = row + dx[i];
			int ny = column + dy[i];
			
			if (isPossibleRoute(nx, ny)) {
				dfs(nx, ny);
			}
		}
	}

	public static boolean isPossibleRoute(int row, int column) {
		if (row < 0 || column < 0) return false;
		if (row >= n || column >= m) return false;
		if (map[row][column] != '0') return false;
		if (visitedMap[row][column]) return false;
		
		return true;
	}
}
