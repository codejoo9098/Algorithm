import java.util.Scanner;
import java.util.Vector;

public class B_1021 {

	public static void main(String[] args) {
		int dequesize;
		int numsize;
		int[] targetNum;
		int temp;
		int count = 0;
		Vector<Integer> queue = new Vector<>();
		Scanner sc = new Scanner(System.in);

		dequesize = sc.nextInt();
		numsize = sc.nextInt();
		sc.nextLine();
		targetNum = new int[numsize];
		
		for (int i = 1; i <= dequesize; i++) {
			queue.add(i);
		}
		
		for (int i = 0; i < numsize; i++) {
			targetNum[i] = sc.nextInt();
		}
		sc.nextLine();
		
		
		for (int i = 0; i < targetNum.length; i++) {
			
			if (targetNum[i] != queue.get(0)) {
				
				if (queue.indexOf(targetNum[i]) <= (queue.size()/2)) {
					
					while (queue.get(0) != targetNum[i]) {
						temp = queue.remove(0);
						queue.add(temp);
						count++;
					}
					
					queue.remove(0);
					
				}
				else {
					
					while (queue.get(queue.size() - 1) != targetNum[i]) {
						temp = queue.remove(queue.size() - 1);
						queue.add(0, temp);
						count++;
					}
					
					temp = queue.remove(queue.size() - 1);
					count++;
				}
			}
			else {
				queue.remove(0);
			}
		}
		
		System.out.println(count);
		sc.close();
	}

}
