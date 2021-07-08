import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;


public class B_17299 {

	public static void main(String[] args) throws IOException {
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testcase = Integer.parseInt(br.readLine());
		int[] num = new int[testcase];
		int[] result = new int[testcase];
		int[] answer = new int[testcase];
		int[] count = new int[1000001];
		String strNum = br.readLine();
		String[] split = strNum.split(" ");
		
		for (int i = 0; i < testcase; i++) {
			num[i] = Integer.parseInt(split[i]);
			
			count[num[i]] += 1;
		}
		
		
		for (int i = 0; i < testcase; i++) {
			
			if (!stack.isEmpty()) {
				
				while(!stack.isEmpty() && count[num[stack.peekLast()]] < count[num[i]]) {
					answer[stack.removeLast()] = num[i];
				}
				
				stack.addLast(i);
				
			}
			else {
				stack.addLast(i);
			}
		}
		
		while(!stack.isEmpty()) {
			answer[stack.removeLast()] = -1;
		}
		
		for (int i = 0; i < result.length; i++) {
			bw.write(answer[i] + " ");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

}
