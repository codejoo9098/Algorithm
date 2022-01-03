import java.util.*;


public class B_1541 {

	public static void main(String[] args) {
		int answer = 0;
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		String split[] = input.split("-");
		
		for (int i = 0; i < split.length; i++) {
			int temp = 0;
			String numSplit[] = split[i].split("\\+");
			
			for (int j = 0; j < numSplit.length; j++) {
				temp += Integer.parseInt(numSplit[j]);
			}
			
			if (i == 0) {
				answer += temp;
			}
			else {
				answer -= temp;
			}
		}
		
		System.out.println(answer);
		sc.close();
	}

}
