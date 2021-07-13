import java.util.Scanner;

public class B_11727 {
	static int cases[] = new int[1001];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		cases[1] = 1;
		cases[2] = 3;

		System.out.println(getCases(n));
		sc.close();
	}

	private static int getCases(int n) {
		if (n == 1) {
			return cases[1];
		}
		if (n == 2) {
			return cases[2];
		}
		
		if (cases[n] != 0) {
			return cases[n];
		}
		else {
			cases[n] = (getCases(n - 1) + 2 * getCases(n - 2)) % 10007;
			return cases[n];
		}
	}

}
