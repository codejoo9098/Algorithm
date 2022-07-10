package dfsbfs;
import java.util.*;

public class B_18428 {
	static boolean answer = false;
	static char[][] map = new char[6][6];
	static char[][] temp = new char[6][6];
	static int n;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input;
		n = sc.nextInt();
		sc.nextLine();
		
		for (int i = 0; i < n; i++) {
			input = sc.nextLine();
			String[] split = input.split(" ");
			
			for (int j = 0; j < n; j++) {
				map[i][j] = split[j].charAt(0);
			}
		}
		
		
		dfs(0);
		
		if (answer) System.out.println("YES");
		else System.out.println("NO");
		
		sc.close();
	}

	private static void dfs(int count) {
		if (count == 3) {
			getAnswer();
			return;
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 'X') {
					map[i][j] = 'O';
					count++;
					
					dfs(count);
					
					count--;
					map[i][j] = 'X';
				}
			}
		}
	}

	private static void getAnswer() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				temp[i][j] = map[i][j];
			}
		}
		
		boolean isPossible = true;
		
		Loop1:
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (temp[i][j] == 'T' && !observeStudent(i, j)) {
					isPossible = false;
					break Loop1;
				}
			}
		}
		
		if (isPossible) answer = true;
	}
	
	public static boolean observeStudent(int row, int column) {
		for (int i = row - 1; i >= 0; i--) {
			if (temp[i][column] == 'S') return false;
			if (temp[i][column] == 'O') break;
		}
		
		for (int i = row + 1; i < n; i++) {
			if (temp[i][column] == 'S') return false;
			if (temp[i][column] == 'O') break;
		}
		
		for (int i = column - 1; i >= 0; i--) {
			if (temp[row][i] == 'S') return false;
			if (temp[row][i] == 'O') break;
		}
		
		for (int i = column + 1; i < n; i++) {
			if (temp[row][i] == 'S') return false;
			if (temp[row][i] == 'O') break;
		}
		
		return true;
	}
}
