import java.io.*;
import java.util.Arrays;

public class B_2110 {
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String input;
		String[] split;
		
		input = br.readLine();
		split = input.split(" ");
		int n = Integer.parseInt(split[0]);
		int c = Integer.parseInt(split[1]);
		int[] ary = new int[n];
		
		for (int i = 0; i < n; i++) {
			input = br.readLine();
			ary[i] = Integer.parseInt(input);
		}
		
		Arrays.sort(ary);
		
		int start = 1;
		int end = ary[n - 1] - ary[0];
		
		binarySearch(ary, start, end, c);
		
		bw.write(Integer.toString(result));
		
		bw.flush();
		br.close();
		bw.close();
	}

	static void binarySearch(int[] ary, int start, int end, int c) {
		
		while(start <= end) {
			int count = 1;
			int mid = (start + end) / 2;
			int home = ary[0];
			
			for (int i = 0; i < ary.length; i++) {
				if (ary[i] - home >= mid) {
					count++;
					home = ary[i];
				}
			}
			
			if (count >= c) {
				result = mid;
				start = mid + 1;
			}
			else {
				end = mid - 1;
			}
		}
		
	}
}
