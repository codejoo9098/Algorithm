import java.util.Scanner;

public class B_1309 {
	static int[] num = new int[100001];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		num[1] = 3;
		num[2] = 7;

		System.out.println(getNum(n));
		sc.close();
	}

	private static int getNum(int n) {
		if (n == 1) {
			return num[1];
		}
		
		if (n == 2) {
			return num[2];
		}
		
		if (num[n] != 0) {
			return num[n];
		}
		else {
			num[n] = (2 * getNum(n - 1) + getNum(n - 2)) % 9901;
			return num[n];
		}
	}

}
