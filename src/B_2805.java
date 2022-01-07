import java.util.*;
import java.io.*;

public class B_2805 {
	static long result = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String input;
		String[] split;
		
		input = br.readLine();
		split = input.split(" ");
		
		int n = Integer.parseInt(split[0]);
		long k = Integer.parseInt(split[1]);
		long ary[] = new long[n];
		
		input = br.readLine();
		split = input.split(" ");
		long max = 0;
		for (int i = 0; i < n; i++) {
			ary[i] = Integer.parseInt(split[i]);
			
			if (ary[i] >= max) {
				max = ary[i];
			}
		}
		
		long start = 1;
		long end = max;
		binarySearch(ary, start, end, k);
		
		bw.write(String.valueOf(result));
		
		bw.flush();
		br.close();
		bw.close();
	}

	private static void binarySearch(long[] ary, long start, long end, long target) {
		while(start <= end) {
			long total = 0;
			long mid = (start + end) / 2;
			
			for (int i = 0; i < ary.length; i++) {
				if (ary[i] < mid) {
					continue;
				}
				else {
					total += (ary[i] - mid);
				}
			}
			
			if (total >= target) {
				result = mid;
				start = mid + 1;
			}
			else {
				end = mid - 1;
			}
		}
		
	}

}
