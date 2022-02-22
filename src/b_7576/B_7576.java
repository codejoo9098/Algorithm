package b_7576;
import java.util.*;
import java.io.*;

class Location {
	private int x;
	private int y;
	
	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
}

public class B_7576 {
	static int[][] tomato;
	static int width, height;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Deque<Location> tomatoDeque = new ArrayDeque<>();
		String input;
		String[] split;
		
		input = br.readLine();
		split = input.split(" ");
		
		width = Integer.parseInt(split[1]);
		height = Integer.parseInt(split[0]);
		tomato = new int[width][height];
		
		for (int i = 0; i < width; i++) {
			input = br.readLine();
			split = input.split(" ");
			
			for (int j = 0; j < height; j++) {
				tomato[i][j] = Integer.parseInt(split[j]);
				if (tomato[i][j] == 1) {
					tomatoDeque.addFirst(new Location(i, j));
				}
			}
		}
		// 입력 부분 문제없음
		
		while(!tomatoDeque.isEmpty()) {
			Location currentLocation = tomatoDeque.removeLast();
			int x = currentLocation.getX();
			int y = currentLocation.getY();
			
			if (isPossibleRoute(x + 1, y)) {
				tomato[x + 1][y] = tomato[x][y] + 1;
				tomatoDeque.addFirst(new Location(x + 1, y));
			}
			
			if (isPossibleRoute(x, y + 1)) {
				tomato[x][y + 1] = tomato[x][y] + 1;
				tomatoDeque.addFirst(new Location(x, y + 1));
			}
			
			if (isPossibleRoute(x - 1, y)) {
				tomato[x - 1][y] = tomato[x][y] + 1;
				tomatoDeque.addFirst(new Location(x - 1, y));
			}
			
			if (isPossibleRoute(x, y - 1)) {
				tomato[x][y - 1] = tomato[x][y] + 1;
				tomatoDeque.addFirst(new Location(x, y - 1));
			}
		}
		
		boolean isPossible = true;
		int max = 0;
		
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				if (tomato[i][j] > max) {
					max = tomato[i][j];
				}
				
				if (tomato[i][j] == 0) {
					isPossible = false;
				}
			}
		}
		
		if (isPossible) {
			System.out.println(max - 1);
		}
		else {
			System.out.println(-1);
		}
		
		br.close();
	}

	static boolean isPossibleRoute(int x, int y) {
		if (x < 0 || y < 0) return false;
		if (x >= width || y >= height) return false;
		if (tomato[x][y] != 0) return false;
		
		return true;
	}
}
