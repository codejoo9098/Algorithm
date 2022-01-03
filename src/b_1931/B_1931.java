package b_1931;
import java.util.*;

class Time {
	static Time[] temp;
	int start;
	int end;
	
	public Time(int start, int end) {
		this.start = start;
		this.end = end;
	}
	
	public static void mergeSort(int first, int last, Time[] timeList) {
		int mid = (first + last) / 2;
		
		if (first < last) {
			mergeSort(first, mid, timeList);
			mergeSort(mid + 1, last, timeList);
			
			int p = first;
			int q = mid + 1;
			int index = first;
			
			while(p <= mid || q <= last) {
				
				if (q > last || (p <= mid && timeList[p].end < timeList[q].end)) {
					temp[index++] = timeList[p++];
				}
				else if ((p <= mid && q <= last)&&(timeList[p].end == timeList[q].end)) {
					if (timeList[p].start < timeList[q].end) {
						temp[index++] = timeList[p++];
					}
					else {
						temp[index++] = timeList[q++];
					}
				}
				else {
					temp[index++] = timeList[q++];
				}
			}
			
			for (int i = first; i <= last; i++) {
				timeList[i] = temp[i];
			}
		}
	}
}

public class B_1931 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int answer = 0;
		int num = sc.nextInt();
		Time timeList[] = new Time[num];
		Time.temp = new Time[num];
		
		for (int i = 0; i < num; i++) {
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			
			timeList[i] = new Time(n1, n2);
			Time.temp[i] = new Time(0, 0);
		}
		
		Time.mergeSort(0, num - 1, timeList);
		
		int currentEnd = 0;
		
		for (int i = 0; i < num; i++) {
			
			if (currentEnd <= timeList[i].start) {
				currentEnd = timeList[i].end;
				answer++;
			}
		}
		
		System.out.println(answer);
		sc.close();
	}
}
