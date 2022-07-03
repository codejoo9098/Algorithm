package greedy;
import java.util.*;

public class B_1541 {
	static long answer = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		
		String[] split = input.split("-");
		
		for (int i = 0; i < split.length; i++) {
			String[] value = split[i].split("\\+");
			
			if (i == 0) {
				for (int j = 0; j < value.length; j++) {
					answer += Long.parseLong(value[j]);
				}
				
				continue;
			}
			
			for (int j = 0; j < value.length; j++) {
				answer -= Long.parseLong(value[j]);
			}
		}
		
		System.out.println(answer);
		sc.close();
	}

}
