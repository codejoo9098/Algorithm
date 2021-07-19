import java.util.Scanner;

public class B_11725 {
	static int n;
	static int[][] temp;
	static int[][] num;
	static int[] result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		sc.nextLine();

		temp = new int[n + 1][2];
		num = new int[n + 1][2];
		result = new int[n + 1];
		
		for (int i = 1; i < n; i++) {
			temp[i][0] = sc.nextInt();
			temp[i][1] = sc.nextInt();
		}
		
		getResult(1);
		sc.close();
	}

	private static void getResult(int cur) {
		
		for (int i = 1; i < n; i++) {
			
			for (int j = 0; j < 2; j++) {
				
				if (temp[i][j] == cur) {
					
					if (j == 0) {
						
						if (num[cur][0] == 0) {
							num[cur][0] = temp[i][1];
						}
						else {
							num[cur][1] = temp[i][1];
						}
						
						getResult(temp[i][1]);
						
					}
					else {
						
						if (num[cur][0] == 0) {
							num[cur][0] = temp[i][0];
						}
						else {
							num[cur][1] = temp[i][0];
						}
						
						getResult(temp[i][0]);
						
					}
					
				}
			}
			
		}
	}

}
