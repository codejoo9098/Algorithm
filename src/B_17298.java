import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;


public class B_17298 {

	public static void main(String[] args) throws IOException {
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testcase = Integer.parseInt(br.readLine());
		String strnum = br.readLine();
		String split[] = strnum.split(" ");
		int[] num = new int[testcase];
		int[] result = new int[testcase];
		
		for (int i = 0; i < testcase; i++) {
			num[i] = Integer.parseInt(split[i]);
		}
		
		for (int i = 0; i < testcase; i++) {
			
			if (!stack.isEmpty()) {
				
				while(!stack.isEmpty() && num[stack.peekLast()] < num[i]) {
					result[stack.removeLast()] = num[i];
				}
				
				stack.addLast(i);
				
			}
			else {
				stack.addLast(i);
			}
		}
		
		while(!stack.isEmpty()) {
			result[stack.removeLast()] = -1;
		}
		
		for (int i = 0; i < result.length; i++) {
			bw.write(result[i] + " ");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

}
