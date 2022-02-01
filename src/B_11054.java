import java.io.*;
import java.util.Arrays;

public class B_11054 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		int n = Integer.parseInt(input);
		int[] data = new int[n];
		int[] answer = new int[n];
		
		input = br.readLine();
		String[] split = input.split(" ");
		
		for (int i = 0; i < n; i++) {
			data[i] = Integer.parseInt(split[i]);
			answer[i] = 1;
		}
		
		int max = 0;
		for (int splitIndex = 0; splitIndex < n; splitIndex++) {
			
			for (int i = 0; i <= splitIndex; i++) {
				
				for (int j = 0; j < i; j++) {
					
					if (data[j] < data[i] && answer[j] >= answer[i]) {
						answer[i] = answer[j] + 1;
					}
				}
			}
			
			for (int i = splitIndex; i < n; i++) {
				
				for (int j = splitIndex; j < i; j++) {
					
					if (data[j] > data[i] && answer[j] >= answer[i]) {
						answer[i] = answer[j] + 1;
					}
				}
			}
			
			for (int i = 0; i < n; i++) {
				if (max < answer[i]) {
					max = answer[i];
				}
			}
			
			Arrays.fill(answer, 1);
		}
		
		System.out.println(max);
		br.close();
	}

}
