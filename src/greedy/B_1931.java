package greedy;
import java.util.*;

class Time implements Comparable<Time> {
	int start;
	int end;
	
	public Time(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public int compareTo(Time o) {
		if (this.end != o.end) {
			return this.end - o.end;
		}
		
		return this.start - o.start;
	}
}

public class B_1931 {
	static int lastTime = 0;
	static int answer = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		Time[] timeLine = new Time[n];
		for (int i = 0; i < n; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			
			timeLine[i] = new Time(start, end);
		}
		
		Arrays.sort(timeLine);
		
		for (int i = 0; i < n; i++) {
			if (timeLine[i].start >= lastTime) {
				lastTime = timeLine[i].end;
				answer++;
			}
		}
		
		System.out.println(answer);
		sc.close();
	}

}
