import java.util.Scanner;

public class B_1932 {
	static int[][] ary;
	static boolean[][] isCalcutated;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		ary = new int[num][num];
		isCalcutated = new boolean[num][num];
		
		for (int i = 0; i < num; i++) {
			
			for (int j = 0; j <= i; j++) {
				ary[i][j] = sc.nextInt();
			}
		}
		
		isCalcutated[0][0] = true;
		
		for (int i = 0; i < num; i++) {
			getMaxRoute(num - 1, i);
		}
		
		int max = 0;
		for (int i = 0; i < num; i++) {
			if (max <= ary[num - 1][i]) {
				max = ary[num - 1][i];
			}
		}
		
		System.out.println(max);
		sc.close();
	}
	
	public static int getMaxRoute(int x, int y) {
		int sum1 = 0;
		int sum2 = 0;
		
		isCalcutated[x][y] = true;
		
		if (x == 0) {
			return ary[0][0];
		}
		
		if (y == 0) {
			if (isCalcutated[x - 1][y]) {
				sum1 = ary[x - 1][y] + ary[x][y];
			}
			else {
				sum1 = getMaxRoute(x - 1, y) + ary[x][y];
			}
		}
		else if (y != x) {
			if (isCalcutated[x - 1][y]) {
				sum1 = ary[x - 1][y] + ary[x][y];
			}
			else {
				sum1 = getMaxRoute(x - 1, y) + ary[x][y];
			}
			
			if (isCalcutated[x - 1][y - 1]) {
				sum2 = ary[x - 1][y - 1] + ary[x][y];
			}
			else {
				sum2 = getMaxRoute(x - 1, y - 1) + ary[x][y];
			}
		}
		else if (y == x) {
			if (isCalcutated[x - 1][y - 1]) {
				sum1 = ary[x - 1][y - 1] + ary[x][y];
			}
			else {
				sum1 = getMaxRoute(x - 1, y - 1) + ary[x][y];
			}
		}
		
		if (sum1 <= sum2) {
			ary[x][y] = sum2;
			return sum2;
		}
		else {
			ary[x][y] = sum1;
			return sum1;
		}
	}
	
}
