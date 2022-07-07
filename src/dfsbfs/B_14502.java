package dfsbfs;
import java.util.*;

class Location {
	int x, y;
	
	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class B_14502 {
	final static int[] dx = {1, -1, 0, 0};
	final static int[] dy = {0, 0, 1, -1};
	
	static ArrayList<Location> virusList = new ArrayList<>();
	static ArrayList<Location> targetWallList = new ArrayList<>();
	static ArrayList<Boolean> isVisitedList = new ArrayList<>();
	
	static int[][] initialMap = new int[9][9];
	static int[][] targetMap = new int[9][9];
	
	static int n, m;
	static int answer = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				initialMap[i][j] = sc.nextInt();
				
				if (initialMap[i][j] == 0) {
					targetWallList.add(new Location(i, j));
					isVisitedList.add(false);
				}
				else if (initialMap[i][j] == 2) {
					virusList.add(new Location(i, j));
				}
			}
		}
		
		resetMap();
		getAnswer(0, targetWallList.size(), 3);
		System.out.println(answer);
		
		sc.close();
	}

	static void resetMap() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				targetMap[i][j] = initialMap[i][j];
			}
		}
	}
	
	static void getAnswer(int start, int n, int r) {
		if (r == 0) {
			for (int i = 0; i < targetWallList.size(); i++) {
				if (isVisitedList.get(i)) {
					targetMap[targetWallList.get(i).x][targetWallList.get(i).y] = 1;
				}
			}
			
			for (int i = 0; i < virusList.size(); i++) {
				dfs(virusList.get(i).x, virusList.get(i).y);
			}
			
			answer = Math.max(answer, countSafeArea());
			resetMap();
			
			return;
		}
		
		for (int i = start; i < n; i++) {
			isVisitedList.set(i, true);
			getAnswer(i + 1, n, r - 1);
			isVisitedList.set(i, false);
		}
	}
	
	static void dfs(int x, int y) {
		targetMap[x][y] = 2;
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (isPossibleRoute(nx, ny)) {
				dfs(nx, ny);
			}
		}
	}
	
	static boolean isPossibleRoute(int x, int y) {
		if (x < 0 || y < 0) return false;
		if (x >= n || y >= m) return false;
		if (targetMap[x][y] == 1 || targetMap[x][y] == 2) return false;
		
		return true;
	}
	
	static int countSafeArea() {
		int count = 0;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (targetMap[i][j] == 0) count++;
			}
		}
		
		return count;
	}
}
