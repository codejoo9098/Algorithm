package b_2565;
import java.util.*;

class Location {
	int x;
	int y;
	
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
	
	public static boolean checkAnswer(Location p1, Location p2) {
		if ((p1.getX() - p2.getX()) * (p1.getY() - p2.getY()) >= 0) {
			return true;
		}
		else {
			return false;
		}
	}
}

public class B_2565 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Location[] locationList = new Location[n];
		int[] answer = new int[n];
		
		for (int i = 0; i < n; i++) {
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			
			locationList[i] = new Location(n1, n2);
		}
		Arrays.fill(answer, 1);
		
		Arrays.sort(locationList, new Comparator<Location>() {

			@Override
			public int compare(Location o1, Location o2) {
				return o1.getX() - o2.getX();
			}
		});
		
		for (int i = 0; i < n; i++) {
			
			for (int j = 0; j < i; j++) {
				if (locationList[j].getY() < locationList[i].getY() && answer[j] >= answer[i]) {
					answer[i] = answer[j] + 1;
				}
			}
		}
		
		int max = 0;
		for (int i = 0; i < n; i++) {
			if (max < answer[i]) {
				max = answer[i];
			}
		}
		
		System.out.println(n - max);
		sc.close();
	}

}
