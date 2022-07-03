package greedy;
import java.util.*;

public class B_11047 {
	static int[] coinList = new int[11];
	static int num, money;
	static int answer = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		
		num = sc.nextInt();
		money = sc.nextInt();
		for (int i = 1; i <= num; i++) {
			coinList[i] = sc.nextInt();
		}
		
		for (int i = num; i >= 1; i--) {
			if (money == 0) break;
			if (money < coinList[i]) continue; 
			
			while(money >= coinList[i]) {
				money -= coinList[i];
				answer++;
			}
		}
		
		System.out.println(answer);
		sc.close();
	}

}
