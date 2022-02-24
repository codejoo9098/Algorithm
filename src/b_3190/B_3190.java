package b_3190;
import java.util.*;

class SnakeTail {
	private int x;
	private int y;
	private boolean isRight;
	
	public SnakeTail(int x, int y, boolean isRight) {
		this.x = x;
		this.y = y;
		this.isRight = isRight;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public boolean getIsRight() {
		return isRight;
	}
}

class Direction {
	private int time;
	private boolean isRight;
	
	public Direction(int time, boolean isRight) {
		this.time = time;
		this.isRight = isRight;
	}
	
	public int getTime() {
		return time;
	}
	
	public boolean getIsRight() {
		return isRight;
	}
}

public class B_3190 {
	static boolean[][] snakeMap;
	static boolean[][] appleMap;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static int headDirection = 0;
	static int tailDirection = 0;
	static int n;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		snakeMap = new boolean[n + 1][n + 1];
		appleMap = new boolean[n + 1][n + 1];
		
		int locationSize = sc.nextInt();
		for (int i = 1; i <= locationSize; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			appleMap[x][y] = true;
		}
		
		int directionSize = sc.nextInt();
		Direction[] directionList = new Direction[directionSize + 1];
		sc.nextLine();
		for (int i = 1; i <= directionSize; i++) {
			String input = sc.nextLine();
			String[] split = input.split(" ");
			
			if (split[1].equals("D")) {
				directionList[i] = new Direction(Integer.parseInt(split[0]), true);
			}
			else {
				directionList[i] = new Direction(Integer.parseInt(split[0]), false);
			}
		}
		
		int time = 0;
		int headIndex = 1;
		int headX = 1, headY = 1;
		int tailX = 1, tailY = 1;
		Deque<SnakeTail> tail = new ArrayDeque<>();
		snakeMap[1][1] = true;
		
		while(true) {
			time++;
			if (isGameOver(headX + dx[headDirection], headY + dy[headDirection])) break;
			headX += dx[headDirection];
			headY += dy[headDirection];
			
			if (appleMap[headX][headY]) {
				appleMap[headX][headY] = false;
				snakeMap[headX][headY] = true;
			}
			else {
				snakeMap[headX][headY] = true;
				snakeMap[tailX][tailY] = false;
				
				if (!tail.isEmpty() && tail.getLast().getX() == tailX && tail.getLast().getY() == tailY) {
					SnakeTail temp = tail.removeLast();
					tailDirection = changeDirection(temp.getIsRight(), tailDirection);
				}
				
				tailX += dx[tailDirection];
				tailY += dy[tailDirection];
			}
			
			if (headIndex <= directionSize && time == directionList[headIndex].getTime()) {
				tail.addFirst(new SnakeTail(headX, headY, directionList[headIndex].getIsRight()));
				headDirection = changeDirection(directionList[headIndex].getIsRight(), headDirection);
				headIndex++;
			}
		}
		
		System.out.println(time);
		sc.close();
	}

	static int changeDirection(boolean isRight, int direction) {
		if (isRight) {
			if (direction == 3) direction = 0;
			else direction++;
		}
		else {
			if (direction == 0) direction = 3;
			else direction--;
		}
		
		return direction;
	}
	
	static boolean isGameOver(int x, int y) {
		if (x <= 0 || y <= 0) return true;
		if (x > n || y > n) return true;
		if (snakeMap[x][y]) return true;
		
		return false;
	}
}
