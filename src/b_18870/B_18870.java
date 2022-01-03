package b_18870;

import java.io.*;
import java.util.*;

class Location {
	int index;
	int value;
	
	public Location(int index, int value) {
		this.index = index;
		this.value = value;
	}
	
	public int getIndex() {
		return index;
	}
	
	public int getValue() {
		return value;
	}
}

public class B_18870 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String line = br.readLine();
		int n = Integer.parseInt(line);
		Location[] ary = new Location[n];
		int[] answerList = new int[n];
		
		line = br.readLine();
		String[] split = line.split(" ");
		for (int i = 0; i < n; i++) {
			int k = Integer.parseInt(split[i]);
			ary[i] = new Location(i, k);
		}
		
		Arrays.sort(ary, new Comparator<Location>() {
			
			@Override
			public int compare(Location o1, Location o2) {
				return o1.getValue() - o2.getValue();
			}
		});
		
		int num = 0;
		answerList[ary[0].getIndex()] = num;
		
		for (int i = 1; i < n; i++) {
			if (ary[i - 1].getValue() == ary[i].getValue()) {
				answerList[ary[i].getIndex()] = num;
			}
			else {
				num++;
				answerList[ary[i].getIndex()] = num;
			}
		}
		
		for (int i = 0; i < n; i++) {
			bw.write(answerList[i] + " ");
		}
		
		bw.flush();
		br.close();
		bw.close();
	}

}
