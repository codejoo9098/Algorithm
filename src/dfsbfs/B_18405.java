package dfsbfs;
import java.util.*;

class Virus {
	int num, x, y, count;
	
	public Virus(int num, int x, int y, int count) {
		this.num = num;
		this.x = x;
		this.y = y;
		this.count = count;
	}
}

public class B_18405 {
	final static int[] dx = {1, -1, 0, 0};
	final static int[] dy = {0, 0, 1, -1};
	
	static int n, k;
	static int time, row, column;
	static int[][] virusMap;
	
	static Deque<Virus> deque = new ArrayDeque<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		k = sc.nextInt();
		virusMap = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				virusMap[i][j] = sc.nextInt();
			}
		}
		
		time = sc.nextInt();
		row = sc.nextInt();
		column = sc.nextInt();
		
		for (int i = 1; i <= k; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					if (virusMap[j][k] == i) {
						deque.addFirst(new Virus(i, j, k, 0));
					}
				}
			}
		}
		
		while(!deque.isEmpty()) {
			Virus virus = deque.removeLast();
			
			if (virus.count == time) break;
			
			for (int i = 0; i < 4; i++) {
				int nx = virus.x + dx[i];
				int ny = virus.y + dy[i];
				
				if (isPossibleRoute(nx, ny)) {
					virusMap[nx][ny] = virus.num;
					deque.addFirst(new Virus(virus.num, nx, ny, virus.count + 1));
				}
			}
		}
		
		System.out.println(virusMap[row - 1][column - 1]);
		sc.close();
	}

	static boolean isPossibleRoute(int x, int y) {
		if (x < 0 || y < 0) return false;
		if (x >= n || y >= n) return false;
		if (virusMap[x][y] != 0) return false;
		
		return true;
	}
}
