import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class B_10799 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayDeque<Character> deque = new ArrayDeque<>();
		boolean isRaser = false;
		String pipe = br.readLine();
		int pipenum = 0;
		
		for (int i = 0; i < pipe.length(); i++) {
			
			if (pipe.charAt(i) == '(') {
				deque.addLast(pipe.charAt(i));
				
				if (isRaser) {
					isRaser = false;
				}
			}
			else if (pipe.charAt(i) == ')') {
				
				if (!isRaser) {
					isRaser = true;
					deque.removeLast();
					pipenum += deque.size();
				}
				else {
					deque.removeLast();
					pipenum += 1;
				}
			}
			
		}
		
		System.out.println(pipenum);
		br.close();
	}

}
