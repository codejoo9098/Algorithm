package implementation;
import java.util.*;

class ChangeInfo {
	int changeTime;
	char changeDirection;
	
	public ChangeInfo(int changeTime, char changeDirection) {
		this.changeTime = changeTime;
		this.changeDirection = changeDirection;
	}
}

class Position {
	final static int[] dx = {0, 1, 0, -1};
	final static int[] dy = {1, 0, -1, 0};
	
	int directionIndex = 0;
	int row = 1;
	int column = 1;
	
	public Position() {}
	public Position(int row, int column, int directionIndex) {
		this.row = row;
		this.column = column;
		this.directionIndex = directionIndex;
	}
	
	public void moveForward() {
		row += dx[directionIndex];
		column += dy[directionIndex];
	}
	
	public void changeDirection(char ch) {
		if (ch == 'D') {
			if (directionIndex == 3) directionIndex = 0;
			else directionIndex++;
		}
		else {
			if (directionIndex == 0) directionIndex = 3;
			else directionIndex--;
		}
	}
}

public class B_3190 {
	static int time = 0;
	static int n;
	
	static boolean[][] snakeMap = new boolean[105][105];
	static boolean[][] appleMap = new boolean[105][105];
	
	static Position headPos = new Position();
	static Position tailPos = new Position();
	
	static Deque<ChangeInfo> headChangeList = new ArrayDeque<>();
	static Deque<Position> tailChangeList = new ArrayDeque<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input;
		n = sc.nextInt();
		
		input = sc.nextInt();
		for (int i = 0; i < input; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			appleMap[x][y] = true;
		}
		sc.nextLine();
		
		input = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < input; i++) {
			String line = sc.nextLine();
			String[] split = line.split(" ");
			
			int t = Integer.parseInt(split[0]);
			char ch = split[1].charAt(0);
			
			headChangeList.addFirst(new ChangeInfo(t, ch));
		}
		
		snakeMap[1][1] = true;
		while(true) {
			ChangeInfo info = headChangeList.peekLast();
			if (info != null && info.changeTime == time) {
				headChangeList.removeLast();
				headPos.changeDirection(info.changeDirection);
				tailChangeList.addFirst(new Position(headPos.row, headPos.column, headPos.directionIndex));
			}
			
			time++;
			headPos.moveForward();	
			if (isGameOver(headPos.row, headPos.column)) {
				System.out.println(time);
				break;
			}
			
			snakeMap[headPos.row][headPos.column] = true;
			if (appleMap[headPos.row][headPos.column]) {
				appleMap[headPos.row][headPos.column] = false;
				continue;
			}
			
			Position pos = tailChangeList.peekLast();
			if (pos != null && pos.row == tailPos.row && pos.column == tailPos.column) {
				tailChangeList.removeLast();
				tailPos.directionIndex = pos.directionIndex;
			}
			snakeMap[tailPos.row][tailPos.column] = false;
			tailPos.moveForward();
		}
		
		sc.close();
	}
	
	static boolean isGameOver(int row, int column) {
		if (row < 1 || column < 1) return true;
		if (row > n || column > n) return true;
		if (snakeMap[row][column]) return true;
		
		return false;
	}
}
