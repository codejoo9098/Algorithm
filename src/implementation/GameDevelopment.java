package implementation;
import java.util.*;

class Person {
	final static int[] dx = {-1, 0, 1, 0};
	final static int[] dy = {0, 1, 0, -1};
	int x, y, direction;
	
	public Person(int x, int y, int direction) {
		this.x = x;
		this.y = y;
		this.direction = direction;
	}
	
	public void moveForward() {
		x += dx[direction];
		y += dy[direction];
	}
	
	public void moveBackward() {
		x -= dx[direction];
		y -= dy[direction];
	}
	
	public void changeDirection() {
		if (direction == 0) direction = 3;
		else direction--;
	}
}

public class GameDevelopment {
	static Person person;
	static int answer = 0;
	static int n, m;
	static boolean visitedMap[][] = new boolean[55][55];
	static boolean gameMap[][] = new boolean[55][55];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		int p1 = sc.nextInt();
		int p2 = sc.nextInt();
		int p3 = sc.nextInt();
		person = new Person(p1, p2, p3);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int input = sc.nextInt();
				if (input == 0) gameMap[i][j] = true;
			}
		}
		
		while(true) {
			boolean isAnyRoute = false;
			
			for (int i = 0; i < 4; i++) {
				person.changeDirection();
				person.moveForward();
				if (isPossibleRoute(person.x, person.y)) {
					answer++;
					visitedMap[person.x][person.y] = true;
					isAnyRoute = true;
					break;
				}
				else {
					person.moveBackward();
				}
			}
			
			if (!isAnyRoute) {
				person.moveBackward();
				if (isGameOver(person.x, person.y)) {
					System.out.println(answer);
					break;
				}
			}
		}
		
		sc.close();
	}

	public static boolean isPossibleRoute(int x, int y) {
		if (x < 0 || y < 0) return false;
		if (x >= n || y >= m) return false;
		if (!gameMap[x][y] || visitedMap[x][y]) return false;
		
		return true;
	}
	
	public static boolean isGameOver(int x, int y) {
		if (x < 0 || y < 0) return true;
		if (x >= n || y >= m) return true;
		if (!gameMap[x][y]) return true;
		
		return false;
	}
}
