
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class B_1406 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Stack<Character> leftStack = new Stack<>();
		Stack<Character> rightStack = new Stack<>();
		String str;
		char command;
		String commandLine;
		char alpha;
		int testcase;
		
		str = br.readLine();
		
		for (int i = 0; i < str.length(); i++) {
			leftStack.push(str.charAt(i));
		}
		
		testcase = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < testcase; i++) {
			commandLine = br.readLine();
			command = commandLine.charAt(0);
			
			switch (command) {
				case 'L': {
					
					if (!leftStack.isEmpty()) {
						rightStack.push(leftStack.pop());
					}
					break;
				
				}
				case 'D':{
					
					if (!rightStack.isEmpty()) {
						leftStack.push(rightStack.pop());
					}
					break;
					
				}
				case 'B': {
					
					if (!leftStack.isEmpty()) {
						leftStack.pop();
					}
					break;
					
				}
				case 'P': {
					alpha = commandLine.charAt(2);
					
					leftStack.push(alpha);
					break;
				}
			}
		}
		
		while(!leftStack.isEmpty()) {
			rightStack.push(leftStack.pop());
		}
		
		while (!rightStack.isEmpty()) {
			bw.write(rightStack.pop());
		}
		
		bw.flush();
		br.close();
		
	}

}
