
import java.util.Scanner;

public class B_1158 {

	public static void main(String[] args) {
		int n, k;
		int state = -1;
		int index = 0;
		int count = 0;
		//LinkedList<Integer> list = new LinkedList<>();
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		k = sc.nextInt();
		
		int prenum[] = new int[n];
		int result[] = new int[n];
		boolean[] isChecked = new boolean[n];
		for (int i = 0; i < n; i++) {
			prenum[i] = i + 1;
		}
		
		while(index != n) {

			while(count < k) {
				state++;
				
				if (!isChecked[state % n]) {
					count++;
				}
			}
			
			
			result[index] = prenum[state % n];
			isChecked[state % n] = true;
			index++;
			count = 0;
		}
		
		System.out.print("<");
		for (int i = 0; i < n - 1; i++) {
			System.out.print(result[i] + ", ");
		}
		System.out.print(result[n - 1] + ">");
		
		sc.close();
	}

}
