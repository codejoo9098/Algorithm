import java.util.Scanner;

public class B_10809 {

	public static void main(String[] args) {
		int[] alpha = new int[26];
		char ch = 'a';
		Scanner in = new Scanner(System.in);
		String str;
		
		str = in.nextLine();
		for (int i = 0; i < alpha.length; ++i) {
			alpha[i] = -1;
		}
		
		for (int i = 0; i < str.length(); ++i) {
			if (alpha[(int)(str.charAt(i) - ch)] == -1) //if를 걸어둬야지 중복을 방지할 수 있다.
				alpha[(int)(str.charAt(i) - ch)] = i; 
		}
		
		for (int i = 0; i < alpha.length; ++i) {
			System.out.print(alpha[i] + " ");
		}
		
		in.close();
	}

}
