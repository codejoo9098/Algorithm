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
			
			for (int j1 = i1 + 1; j1 <= n - 3; j1++) { //j1의 시작은 i1 + 1이라는걸 알았어야한다. 이걸 실수하고 0부터 시작이라고 썼다.
				//이렇게 for이 중첩되면 스타트에서 실수할 수 있다. 어떤것에서 시작을 하는지 잘 살펴보자.
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
					//sum[1],[0] = 1;이 여기 왔다면 안됬었다. sum[2],[3]이 끝나지도 않았는데 혼자 1이 되어버리기 때문이다.
				}
				sum[1] = 1;
			}
			sum[0] = 1;
		}
		
		System.out.println(max);
		sc.close();
	}

}
