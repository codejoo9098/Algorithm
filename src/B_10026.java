import java.util.*;

public class B_10026 {
	static char[][] map;
	static char[][] blindMap;
	static boolean[][] isVisited;
	static int n;
	
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int normalAnswer = 0;
		int blindAnswer = 0;
		n = sc.nextInt();
		sc.nextLine();
		
		map = new char[n][n];
		blindMap = new char[n][n];
		isVisited = new boolean[n][n];
		
		for (int i = 0; i < n; i++) {
			String input = sc.nextLine();
			
			for (int j = 0; j < n; j++) {
				char temp = input.charAt(j);
				map[i][j] = temp;
				
				if (temp == 'R' || temp == 'G') {
					blindMap[i][j] = 'R';
				}
				else {
					blindMap[i][j] = 'B';
				}
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!isVisited[i][j]) {
					if (map[i][j] == 'R') {
						normalDfs(i, j, 'R');
					}
					else if (map[i][j] == 'G') {
						normalDfs(i, j, 'G');
					}
					else {
						normalDfs(i, j, 'B');
					}
					
					normalAnswer++;
				}
			}
		}
		
		map = blindMap;
		isVisited = new boolean[n][n];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!isVisited[i][j]) {
					if (map[i][j] == 'R') {
						normalDfs(i, j, 'R');
					}
					else {
						normalDfs(i, j, 'B');
					}
					
					blindAnswer++;
				}
			}
		}
		
		System.out.println(normalAnswer + " " + blindAnswer);
		sc.close();
	}

	static void normalDfs(int x, int y, char type) {
		isVisited[x][y] = true;
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (checkRoute(nx, ny, type)) normalDfs(nx, ny, type);
		}
	}
	
	static boolean checkRoute(int x, int y, char type) {
		if (x < 0 || y < 0) return false;
		if (x > n - 1 || y > n - 1) return false;
		if (map[x][y] != type) return false;
		if (isVisited[x][y]) return false;
		
		return true;
	}
}
