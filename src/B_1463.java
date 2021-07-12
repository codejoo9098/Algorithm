import java.util.Scanner;

public class B_1463 {
		static int[] seq = new int[1000001];
		
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		System.out.println(getSeq(num));
		sc.close();
	}

	private static int getSeq(int num) {
		if (num == 1) {
			return seq[1];
		}
		
		if (seq[num - 1] == 0) {
			seq[num - 1] = getSeq(num - 1);
		}
		seq[num] = seq[num - 1] + 1;
		int min = seq[num - 1] + 1;
		
		if (num % 2 == 0) {
			
			if (seq[num/2] != 0) {
				seq[num] = getMin(seq[num/2] + 1, seq[num - 1] + 1);
				min = getMin(seq[num/2] + 1, seq[num - 1] + 1);
			}
			else {
				seq[num/2] = getSeq(num/2);
				seq[num] = getMin(seq[num/2] + 1, seq[num - 1] + 1);
				min = getMin(seq[num/2] + 1, seq[num - 1] + 1);
			}
			
		}
		
		if (num % 3 == 0) {
			
			if (seq[num/3] != 0) {
				seq[num] = getMin(seq[num/3] + 1, min);
			}
			else {
				seq[num/3] = getSeq(num/3);
				seq[num] = getMin(seq[num/3] + 1, min);
			}
			
		}
		
		return seq[num];
	}
	
	private static int getMin(int a, int b) {
		if (a < b) {
			return a;
		}
		else {
			return b;
		}
	}

}
