import java.util.Scanner;

public class B_1157 {

	public static void main(String[] args) {
		int n = 0;
		int max = 0;
		int count = 0;
		char maxalpha = 0;
		Scanner sc = new Scanner(System.in);
		int[] alpha = new int[26];
		String str = sc.nextLine();
		
		for (int i = 0; i < str.length(); i++) {
			if ((str.charAt(i) >= 'A')&&(str.charAt(i) <= 'Z')) {//Z이하를 설정 안했는데 A보다 a가 커서 Z이하 설정 안하면 a가 대문자로 들어가게되요..
				n = ((int)(str.charAt(i) - (int)'A'));
				alpha[n]++;
			}
			else {
				n = ((int)(str.charAt(i) - (int)'a'));
				alpha[n]++;
			}
		}
		
		for (int i = 0; i < alpha.length; i++) {
			if (max <= alpha[i]) {
				max = alpha[i];
				maxalpha = (char)i;
			}
		}
		
		for (int i = 0; i < alpha.length; i++) {
			if (max == alpha[i]) {
				count++;
			}
		}
		
		if (count >= 2) {
			System.out.println("?");
			System.exit(0);
		}
		else {
			maxalpha += 'A';
			System.out.println(maxalpha);
		}
		
		sc.close();
	}

}
