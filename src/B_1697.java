import java.util.*;

public class B_1697 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean[] isFound = new boolean[100001];
		boolean isPossible = false;
		int[] time = new int[100001];
		ArrayDeque<Integer> deque = new ArrayDeque<>();
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		deque.addFirst(n);
		isFound[n] = true;
		
		while(!deque.isEmpty()) {
			int target = deque.removeLast();
			if (target == k) {
				System.out.println(time[target]);
				isPossible = true;
				break;
			}
			
			if (target - 1 >= 0 && !isFound[target - 1]) {
				time[target - 1] = time[target] + 1;
				isFound[target - 1] = true;
				deque.addFirst(target - 1);
			}
			
			if (target + 1 <= 100000 && !isFound[target + 1]) {
				time[target + 1] = time[target] + 1;
				isFound[target + 1] = true;
				deque.addFirst(target + 1);
			}
			
			if (target * 2 <= 100000 && !isFound[target * 2]) {
				time[target * 2] = time[target] + 1;
				isFound[target * 2] = true;
				deque.addFirst(target * 2);
			}
		}
		
		if (!isPossible) {
			System.out.println(-1);
		}
		sc.close();
	}

}
