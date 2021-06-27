import java.util.Scanner;

public class B_17127 {

	public static void main(String[] args) {
		int n;
		int[] sum = {1, 1, 1, 1};
		int max = 0;
		int total = 0;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		sc.nextLine();
		
		int[] ary = new int[n];
		for (int i = 0; i < n; i++) {
			ary[i] = sc.nextInt();
		}
		
		for (int i1 = 0; i1 <= n - 4; i1++) {
			
			for (int i2 = 0; i2 <= i1; i2++) {
				sum[0] *= ary[i2];
			}
			
			for (int j1 = i1 + 1; j1 <= n - 3; j1++) { //j1�� ������ i1 + 1�̶�°� �˾Ҿ���Ѵ�. �̰� �Ǽ��ϰ� 0���� �����̶�� ���.
				//�̷��� for�� ��ø�Ǹ� ��ŸƮ���� �Ǽ��� �� �ִ�. ��Ϳ��� ������ �ϴ��� �� ���캸��.
				for (int j2 = i1 + 1; j2 <= j1; j2++) {
					sum[1] *= ary[j2];
				}
				
				for (int k1 = j1 + 1; k1 <= n - 2; k1++) {
					
					for (int k2 = j1 + 1; k2 <= k1; k2++) {
						sum[2] *= ary[k2];
					}
					
					for (int p1 = k1 + 1; p1 <= n - 1; p1++) {
						sum[3] *= ary[p1];
					}
					
					total = (sum[0] + sum[1] + sum[2] + sum[3]);
					if (max <= total) {
						max = total;
					}
					
					sum[2] = 1;
					sum[3] = 1;
					//sum[1],[0] = 1;�� ���� �Դٸ� �ȉ����. sum[2],[3]�� �������� �ʾҴµ� ȥ�� 1�� �Ǿ������ �����̴�.
				}
				sum[1] = 1;
			}
			sum[0] = 1;
		}
		
		System.out.println(max);
		sc.close();
	}

}
