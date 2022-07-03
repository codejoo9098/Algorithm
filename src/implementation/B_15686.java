package implementation;
import java.util.*;

class Location {
	int x, y;
	
	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class B_15686 {
	static int n, m;
	static int answer = 10000000;
	static ArrayList<Location> houseList = new ArrayList<>();
	static ArrayList<Location> chickenList = new ArrayList<>();
	static ArrayList<Boolean> isVisited = new ArrayList<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				int num = sc.nextInt();
				
				if (num == 1) {
					houseList.add(new Location(i, j));
				}
				else if (num == 2) {
					chickenList.add(new Location(i, j));
					isVisited.add(false);
				}
			}
		}
		
		getAnswer(0, chickenList.size(), m);
		System.out.println(answer);
		sc.close();
	}

	static void getAnswer(int start, int n, int r) {
		if (r == 0) {
			getChickenDistance();
			return;
		}
		
		for (int i = start; i < n; i++) {
			isVisited.set(i, true);
			getAnswer(i + 1, n, r - 1);
			isVisited.set(i, false);
		}
	}
	
	static void getChickenDistance() {
		int distanceTotal = 0;
		
		for (int i = 0; i < houseList.size(); i++) {
			int distance = 10000000;
			
			for (int j = 0; j < chickenList.size(); j++) {
				if (!isVisited.get(j)) continue;
				
				distance = Math.min(distance, Math.abs(houseList.get(i).x - chickenList.get(j).x) + Math.abs(houseList.get(i).y - chickenList.get(j).y));
			}
			
			distanceTotal += distance;
			if (answer < distanceTotal) break;
		}
		
		answer = Math.min(answer, distanceTotal);
	}
}
