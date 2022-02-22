package b_15686;
import java.util.*;

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

public class B_15686 {
	static Location[] chicken = new Location[14];
	static Location[] house = new Location[101];
	static boolean[] isVisited = new boolean[14];
	static int min = 10000000;
	static int n, m;
	static int houseSize, chickenSize;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		sc.nextLine();
		
		int houseIndex = 0;
		int chickenIndex = 0;
		for (int i = 1; i <= n; i++) {
			String input = sc.nextLine();
			String[] split = input.split(" ");
			
			for (int j = 1; j <= n; j++) {
				int temp = Integer.parseInt(split[j - 1]);
				
				if (temp == 1) {
					++houseIndex;
					house[houseIndex] = new Location(i, j);
				}
				else if (temp == 2) {
					++chickenIndex;
					chicken[chickenIndex] = new Location(i, j);
				}
			}
		}
		
		houseSize = houseIndex;
		chickenSize = chickenIndex;
		
		getCombinationAnswer(1, m);
		System.out.println(min);
		
		sc.close();
	}
	
	public static int getDistance(Location p1, Location p2) {
		int width = Math.abs(p1.getX() - p2.getX());
		int height = Math.abs(p1.getY() - p2.getY());
		
		return width + height;
	}

	public static void getCombinationAnswer(int depth, int remain) {
		if (remain == 0) {
			getMinDistance();
			return;
		}
		
		if (depth == chickenSize + 1) {
			return;
		}
		
		isVisited[depth] = true;
		getCombinationAnswer(depth + 1, remain - 1);
		
		isVisited[depth] = false;
		getCombinationAnswer(depth + 1, remain);	
	}
	
	public static void getMinDistance() {
		int total = 0;
		
		for (int i = 1; i <= houseSize; i++) {
			int distance = 10000000;
			
			for (int j = 1; j <= chickenSize; j++) {
				if (isVisited[j] && getDistance(house[i], chicken[j]) <= distance) {
					distance = getDistance(house[i], chicken[j]);
				}
			}
			
			total += distance;
		}
		
		if (total <= min) {
			min = total;
		}
	}
}
