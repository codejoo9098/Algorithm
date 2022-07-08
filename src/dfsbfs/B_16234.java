package dfsbfs;
import java.util.*;

public class B_16234 {
	final static int[] dx = {1, -1, 0, 0};
	final static int[] dy = {0, 0, 1, -1};
	
	static int n, l, r;
	static int[][] countryMap = new int[50][50];
	static boolean[][] visitedMap = new boolean[50][50];
	static boolean[][] isVisitedArea = new boolean[50][50];
	static int answer = 0;
	static int count = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		l = sc.nextInt();
		r = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				countryMap[i][j] = sc.nextInt();
			}
		}
		
		while(true) {
			boolean isMovingOccur = false;
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					int value = 0;
					count = 0;
					
					if (visitedMap[i][j]) continue;
					value += dfs(i, j);
					
					if (count == 1) continue;
					
					isMovingOccur = true;
					value /= count;
					
					dfs(i, j, value);
				}
			}
			
			visitedMap = new boolean[50][50];
			isVisitedArea = new boolean[50][50];
			if (isMovingOccur) answer++;
			else break;
		}
		
		System.out.println(answer);
		sc.close();
	}
	
	static int dfs(int row, int column) {
		int value = countryMap[row][column];
		visitedMap[row][column] = true;
		count++;
		
		for (int i = 0; i < 4; i++) {
			int nx = row + dx[i];
			int ny = column + dy[i];
			
			if (isPossibleRoute(nx, ny)) {
				int diff = Math.abs(countryMap[row][column] - countryMap[nx][ny]);
				
				if (diff>= l && diff <= r) {
					value += dfs(nx, ny);
				}
			}
		}
		
		return value;
	}
	
	static void dfs(int row, int column, int value) {
		isVisitedArea[row][column] = true;
		
		for (int i = 0; i < 4; i++) {
			int nx = row + dx[i];
			int ny = column + dy[i];
			
			if (isPossible(nx, ny)) {
				int diff = Math.abs(countryMap[row][column] - countryMap[nx][ny]);
				
				if (diff>= l && diff <= r) {
					dfs(nx, ny, value);
				}
			}
		}
		
		countryMap[row][column] = value;
	}

	static boolean isPossibleRoute(int row, int column) {
		if (row < 0 || column < 0) return false;
		if (row >= n || column >= n) return false;
		if (visitedMap[row][column]) return false;
		
		return true;
	}
	
	static boolean isPossible(int row, int column) {
		if (row < 0 || column < 0) return false;
		if (row >= n || column >= n) return false;
		if (isVisitedArea[row][column]) return false;
		
		return true;
	}
}
