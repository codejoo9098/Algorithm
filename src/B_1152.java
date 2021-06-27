import java.util.Scanner;

public class B_1152 {

	public static void main(String[] args) {
		int n = 0;
		String str;
		Scanner Input = new Scanner(System.in);
		str = Input.nextLine();

		if (str.charAt(0) == ' '&&str.length() == 1) {
			System.out.println(0);
			System.exit(1);
		}
		/*
		 후.. 이 예외 하나때문에 틀렸습니다가 떳지..
		 영어 대소문자+띄어쓰기만으로 이루어져있다고 했으니까 띄어쓰기 하나 있는 경우의 수를 생각했어야됬었다.
		 다음부턴 조건 잘 분석하고 이런 극단적인 경우의 수도 생각해보자..
		 */
		for(int i = 1; i < str.length()-1; i++) {
			if (str.charAt(i) == ' ') {
				n++;
			}
		}
		
		System.out.println(n + 1);
		Input.close();
	}

}
