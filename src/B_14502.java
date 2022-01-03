import java.util.*;

public class B_14502 {
	static int n, m;
	
	static int restNum = 0;
	static int max = 0;
	static int[][] possibleWall;
	
	static int[][] map;
	static int[][] launchMap;
	
	static int index = 0;
	static int[][] locationOfvirus;
	
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		locationOfvirus = new int[2][10];
		possibleWall = new int[2][64];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
				
				if (map[i][j] == 0) {
					possibleWall[0][restNum] = i;
					possibleWall[1][restNum] = j;
					
					restNum++;
				}
				
				if (map[i][j] == 2) {
					locationOfvirus[0][index] = i;
					locationOfvirus[1][index] = j;
					
					index++;
				}
			}
		}
		
		int i, j, k;	
		for (i = 0; i < restNum; i++) {
			for (j = i + 1; j < restNum; j++) {
				for (k = j + 1; k < restNum; k++) {
					makeNewMap();
					launchMap[possibleWall[0][i]][possibleWall[1][i]] = 1;
					launchMap[possibleWall[0][j]][possibleWall[1][j]] = 1;
					launchMap[possibleWall[0][k]][possibleWall[1][k]] = 1;
					
					for (int l = 0; l < index; l++) {
						dfs(locationOfvirus[0][l], locationOfvirus[1][l]);
					}
					
					int temp = checkAnswer();
					if (temp >= max) {
						max = temp;
					}
				}
			}
		}
		
		System.out.println(max);
		sc.close();
	}
	
	static void makeNewMap() {
		launchMap = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				launchMap[i][j] = map[i][j];
			}
		}
	}

	static void dfs(int x, int y) {
		launchMap[x][y] = 2;
		
		for (int i = 0; i < 4; i++) {
			if (checkRoute(x + dx[i], y + dy[i])) {
				dfs(x + dx[i], y + dy[i]);
			}
		}
	}
	
	static int checkAnswer() {
		int answer = 0;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (launchMap[i][j] == 0) {
					answer++;
				}
			}
		}
		
		return answer;
	}
	
	static boolean checkRoute(int x, int y) {
		if (x < 0 || y < 0) return false;
		if (x > n - 1 || y > m - 1) return false;
		if (launchMap[x][y] != 0) return false;
		
		return true;
	}
}
