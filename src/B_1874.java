import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class B_1874 {

	public static void main(String[] args) {
		int num;
		int currentinput = 1;
		boolean isSequence = true;
		ArrayDeque<Integer> deque = new ArrayDeque<>();
		ArrayList<String> operation = new ArrayList<>();
		Scanner sc = new Scanner(System.in);

		num = sc.nextInt();
		int[] ary = new int[num];
		for (int i = 0; i < num; i++) {
			ary[i] = sc.nextInt();
		}
		
		for (int i = 0; i < ary.length; i++) {
			
			if (currentinput <= ary[i]) {
				
				while (currentinput <= ary[i]) {
					deque.addFirst(currentinput);
					operation.add("+");
					currentinput++;
				}
				
				deque.removeFirst();
				operation.add("-");				
			}
			else if (deque.getFirst() == ary[i]) {
				
				deque.removeFirst();
				operation.add("-");
				
			}
			else {
				isSequence = false;
				break;
			}
		}
		
		if (isSequence) {
			
			for (int i = 0; i < operation.size(); i++) {
				System.out.println(operation.get(i));
			}
			
		}
		else {
			System.out.println("NO");
		}
		
		sc.close();
	}

}
