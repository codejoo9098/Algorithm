import java.util.Scanner;

public class B_1717 {
	static int parent[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n, testcase;
		
		n = sc.nextInt();
		testcase = sc.nextInt();
		
		parent = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			parent[i] = i;
		}
		
		for (int i = 0; i < testcase; i++) {
			int p1, p2, p3;
			
			p1 = sc.nextInt();
			p2 = sc.nextInt();
			p3 = sc.nextInt();
			
			if (p1 == 0) {
				int oldParent = findParent(p2);
				int newParent = findParent(p3);
				
				parent[oldParent] = newParent;
			}
			else {
				if (findParent(p2) == findParent(p3)) {
					System.out.println("YES");
				}
				else {
					System.out.println("NO");
				}
			}
		}
		
		sc.close();
	}
	
	static int findParent(int target) {
		if (target == parent[target]) {
			return parent[target];
		}
		else {
			return parent[target] = findParent(parent[target]);
		}
	}

}
