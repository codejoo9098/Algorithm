import java.util.Scanner;

public class B_1003 {
	static int fibo[] = new int[50];
	static int zero[] = new int[50];
	static int one[] = new int[50];
	static int zerocount = 0;
	static int onecount = 0;

	public static void main(String[] args) {
		zero[0] = 1;
		zero[1] = 0;
		one[0] = 0;
		one[1] = 1;
		
		Scanner sc = new Scanner(System.in);	
		int num;
		int testcase = sc.nextInt();
		for (int i = 0; i < testcase; i++) {
			num = sc.nextInt();
			fibonacci(num);
			System.out.println(zero[num] + " " + one[num]);
		}
		
		sc.close();
	}
	
	
	public static int fibonacci(int num) {
		
		if (num == 0) {
			return 0;
		}
		else if (num == 1) {
			return 1;
		}
		
		if (fibo[num] != 0) {
			return fibo[num];
		}
		else {
			fibo[num] = fibonacci(num - 2) + fibonacci(num - 1);
			zero[num] = zero[num - 2] + zero[num - 1];
			one[num] = one[num - 2] + one[num - 1];
			return fibo[num];
		}
	}

}
