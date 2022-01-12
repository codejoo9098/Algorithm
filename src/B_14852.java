import java.util.*;

public class B_14852 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[] ary = new long[n];
		long total = 0;
		
		ary[0] = 2;
		if (n > 1) {
			ary[1] = 7;
			
			total = ary[0] + ary[1];
		}
		
		for (int i = 2; i < n; i++) {
			ary[i] = (2 * total + ary[i - 2] + 2) % 1000000007;
			
			total += ary[i] % 1000000007;
		}
		
		System.out.println(ary[n - 1]);
		sc.close();
	}

}
