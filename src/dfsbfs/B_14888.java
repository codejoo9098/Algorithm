package dfsbfs;
import java.util.*;

public class B_14888 {
	static int minAnswer = Integer.MAX_VALUE;
	static int maxAnswer = Integer.MIN_VALUE;
	static int n;
	static int[] inputList = new int[11];
	static int[] operatorList = new int[4];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			inputList[i] = sc.nextInt();
		}
		
		for (int i = 0; i < 4; i++) {
			operatorList[i] = sc.nextInt();
		}
		
		dfs(1, inputList[0]);
		
		System.out.println(maxAnswer);
		System.out.println(minAnswer);
		
		sc.close();
	}

	static void dfs(int index, int value) {
		if (index == n) {
			minAnswer = Math.min(minAnswer, value);
			maxAnswer = Math.max(maxAnswer, value);
			
			return;
		}
		
		if (operatorList[0] != 0) {
			operatorList[0]--;
			dfs(index + 1, value + inputList[index]);
			operatorList[0]++;
		}
		
		if (operatorList[1] != 0) {
			operatorList[1]--;
			dfs(index + 1, value - inputList[index]);
			operatorList[1]++;
		}
		
		if (operatorList[2] != 0) {
			operatorList[2]--;
			dfs(index + 1, value * inputList[index]);
			operatorList[2]++;
		}
		
		if (operatorList[3] != 0) {
			operatorList[3]--;
			dfs(index + 1, value / inputList[index]);
			operatorList[3]++;
		}
	}
}
