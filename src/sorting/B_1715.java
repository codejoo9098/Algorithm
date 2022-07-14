package sorting;
import java.util.*;

public class B_1715 {
	static PriorityQueue<Integer> queue = new PriorityQueue<>();
	static int n, answer;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int temp = sc.nextInt();
			queue.add(temp);
		}
		
		while(queue.size() > 1) {
			int p1 = queue.remove();
			int p2 = queue.remove();
			
			answer += p1 + p2;
			queue.add(p1 + p2);
		}
		
		sc.close();
		System.out.println(answer);
	}
}