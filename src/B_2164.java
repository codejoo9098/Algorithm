import java.util.ArrayDeque;
import java.util.Scanner;

public class B_2164 {

	public static void main(String[] args) {
		int num;
		int temp;
		ArrayDeque<Integer> deque = new ArrayDeque<>();
		Scanner sc = new Scanner(System.in);
		
		num = sc.nextInt();
		for (int i = 1; i <= num; i++) {
			deque.addLast(i);
		}
		
		while(deque.size() != 1) {
			deque.removeFirst();
			temp = deque.removeFirst();
			deque.addLast(temp);
		}
		
		System.out.println(deque.getFirst());
		sc.close();
	}

}
