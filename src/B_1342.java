import java.util.Scanner;
//한글자, 두글자 무조건 생각하기!
public class B_1342 {

	public static void main(String[] args) {
		int n = 0;
		int k = 0;
		int num = 1;
		int sum = 0;
		boolean check = true;
		char[] text = new char[10];
		
		String str;
		Scanner Input = new Scanner(System.in);
		
		str = Input.nextLine();
		
		for (int i = 0; i < str.length(); ++i) {
			
			for (int j = 0; j < i; j++) {
				if (str.charAt(i) == str.charAt(j)) {
					check = false;
					break;
				}
			}
			
			if (check == true) {
				n++;
				text[k] = str.charAt(i);
				k++;
			}
			
			check = true;
		}
		
		int[] word = new int[n];
		for (int i = 0; i < n; i++) {
			
			for (int j = 0; j < str.length(); j++) {
				
				if (text[i] == str.charAt(j)) {
					word[i]++;
				}
			}
		}
		
		for (int i = 0; i < n; i++) {
			sum += word[i];
		}
		
		for (int i = 0; i < n; ++i) {
			
		}
	}

}
