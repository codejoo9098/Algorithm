import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Location {
	int x;
	int y;
	
	public Location (int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public boolean equals(Object obj) {
		Location location = (Location)obj;
		
		if (location.x == this.x && location.y == this.y) {
			return true;
		}
		else {
			return false;
		}
	}
}

public class B_2179 {
	static boolean isRoute[][];
	static int length[][];
	static Queue<Location> queue;
	static int n, m;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str;
		queue = new LinkedList<>();
		n = sc.nextInt();
		m = sc.nextInt();
		sc.nextLine();
		
		isRoute = new boolean[n + 1][m + 1];
		length = new int[n + 1][m + 1];
		
		for (int i = 1; i <= n; i++) {
			str = sc.nextLine();
			
			for (int j = 0; j < m; j++) {
				if (str.charAt(j) == '1') {
					isRoute[i][j + 1] = true;
				}
				else {
					isRoute[i][j + 1] = false;
				}
			}
		}
		
		length[1][1] = 1;
		queue.offer(new Location(1, 1));
		System.out.println(getLength());
		
		sc.close();
	}

	private static int getLength() {
		int[] dx = {1, 0, -1, -0};
		int[] dy = {0, 1, 0, -1};
		
		while(!queue.isEmpty()) {
			Location temp = queue.poll();
			
			if (temp.equals(new Location(n, m))) {
				return length[n][m];
			}
			
			for (int i = 0; i < 4; i++) {
				int x = temp.x + dx[i];
				int y = temp.y + dy[i];
				
				if (x >= 1 && x <= n && y >= 1 && y <= m) {
					
					if (isRoute[x][y] && length[x][y] == 0) {
						length[x][y] = length[temp.x][temp.y] + 1;
						queue.offer(new Location(x, y));
					}
				}
			}
			
			
		}
		return 1;
	}

}
