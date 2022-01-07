import java.io.*;
import java.util.*;

public class B_1654 {
	static long result = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String input;
		String[] split;
		
		input = br.readLine();
		split = input.split(" ");
		
		int k = Integer.parseInt(split[0]);
		long n = Integer.parseInt(split[1]);
		long[] ary = new long[k];
		
		for (int i = 0; i < k; i++) {
			input = br.readLine();
			int temp = Integer.parseInt(input);
			ary[i] = temp;
		}
		
		Arrays.sort(ary);
		long start = 1;
		long end = ary[k - 1];
		
		binarySearch(ary, start, end, n);
		
		System.out.println(result);
		
		bw.flush();
		br.close();
		bw.close();
	}

	private static void binarySearch(long[] ary, long start, long end, long n) {
		
		while(start <= end) {
			long count = 0;
			long mid = (start + end) / 2;
			
			for (int i = 0; i < ary.length; i++) {
				count += ary[i] / mid;
			}
			
			if (count >= n) {
				if (result <= mid) {
					result = mid;
				}
				start = mid + 1;
			}
			else {
				end = mid - 1;
			}
		}
	}

}
