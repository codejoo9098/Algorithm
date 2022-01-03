package b_11000;
import java.util.*;

class Time implements Comparable<Time> {
	int start;
	int end;
	
	Time(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public int compareTo(Time o) {
		if (this.end != o.end) {
			return this.end - o.end;
		}
		else {
			return this.start - o.start;
		}
		
	}
}

public class B_11000 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayDeque<Time> selectedDeque = new ArrayDeque<>();
		ArrayDeque<Time> abandonedDeque = new ArrayDeque<>();
		int num = sc.nextInt();
		int answer = 0;
		Time[] timeList = new Time[num];
		
		for (int i = 0; i < num; i++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			timeList[i] = new Time(n, m);
		}
		
		Arrays.sort(timeList);
		for (int i = 0; i < num; i++) {
			selectedDeque.addLast(timeList[i]);
		}
		
		int endTime = 0;
		while (true) {
			int size = selectedDeque.size();
			
			for (int i = 0; i < size; i++) {
				Time temp = selectedDeque.removeFirst();
				if (endTime <= temp.start) {
					endTime = temp.end;
				}
				else {
					abandonedDeque.addLast(temp);
				}
			}
			
			answer++;
			if (abandonedDeque.isEmpty()) {
				break;
			}
			else {
				selectedDeque = abandonedDeque;
				abandonedDeque = new ArrayDeque<>();
				endTime = 0;
			}
		}
		
		System.out.println(answer);
		sc.close();
	}

}
