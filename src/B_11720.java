import java.util.Scanner;

public class B_11720 {

	public static void main(String[] args) {
		int n = 0;
		int k = 0;
		char c = '0';
		int sum = 0;
		String str;
		Scanner Input = new Scanner(System.in);
		
		n = Input.nextInt();
		Input.nextLine();
		
		str = Input.nextLine();
		
		for (int i = 0; i < n; i++) {
			k = str.charAt(i) - c; //charAt이 아스키코드인 char형이라는 것을 이용하면 편리하다. 근데 그거 말고 함수쓰는것도 괜찮을듯
			sum += k;
		}
		
		System.out.println(sum);
		Input.close();
	}

}
