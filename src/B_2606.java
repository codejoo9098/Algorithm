import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class B_2606 {
	static ArrayList<Integer>[] list;
	static ArrayDeque<Integer> deque;
	static ArrayDeque<Integer> infestedCom;
	static boolean[] isVisited;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int comNum = sc.nextInt();
		int pairNum = sc.nextInt();

		infestedCom = new ArrayDeque<>();
		deque = new ArrayDeque<>();
		list = new ArrayList[comNum + 1];
		isVisited = new boolean[comNum + 1];
		
		for (int i = 1; i <= comNum; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 1; i <= pairNum; i++) {
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			
			list[n1].add(n2);
			list[n2].add(n1);
		}
		
		isVisited[1] = true;
		
		getInfestedComputer(1);
		System.out.println(infestedCom.size());
		sc.close();
	}

	private static void getInfestedComputer(int cur) {
		for (int i = 0; i < list[cur].size(); i++) {
			
			if (!isVisited[list[cur].get(i)]) {
				isVisited[list[cur].get(i)] = true;
				deque.addFirst(list[cur].get(i));
			}
		}
		
		if (!deque.isEmpty()) {
			int temp = deque.removeLast();
			infestedCom.addFirst(temp);
			getInfestedComputer(temp);
		}
	}

}
