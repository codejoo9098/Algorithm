import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.StringTokenizer;

public class B_5430 {

	public static void main(String[] args) {
		int testcase;
		String functionComb;
		int size;
		String aryString;
		boolean errorFlag = false;
		boolean isReversed = false;
		ArrayDeque<String> numList = new ArrayDeque<>();
		StringTokenizer st = null;
		Scanner sc = new Scanner(System.in);
		
		testcase = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < testcase; i++) {
			functionComb = sc.nextLine();
			size = sc.nextInt();
			sc.nextLine();
			aryString = sc.nextLine();
			
			errorFlag = false;
			aryString = aryString.substring(1, aryString.length() - 1);
			if (size != 0) {
				st = new StringTokenizer(aryString, ",");
			}
			else {
				
				if (functionComb.contains("D")) {
					System.out.println("error");
					continue;
				}
				else {
					System.out.println("[]");
					continue;
				}
			}
			
				
				for (int j = 0; j < size; j++) {
					numList.offerLast(st.nextToken());
				}
				
				for (int j = 0; j < functionComb.length(); j++) {
					
					if (functionComb.charAt(j) == 'R') {
						
						isReversed = !isReversed;
						
					}
					else {
						
						if (numList.isEmpty()) {
							errorFlag = true;
							break;
						}
						
						if (isReversed) {
							numList.pollLast();
						}
						else {
							numList.pollFirst();
						}
						
					}
				}
				
				if (!errorFlag) {
					if (isReversed) {
						
						//int finallistsize = numList.size();
						System.out.print("[");
						while (numList.size() >1) {
							System.out.print(numList.pollLast() + ",");
						}
						if (numList.size() != 0) {
							System.out.print(numList.pollLast());
						}
						System.out.println("]");
						
					} 
					else {
						//int finallistsize = numList.size();
						System.out.print("[");
						while (numList.size() >1) {
							System.out.print(numList.pollFirst() + ",");
						}
						if (numList.size() != 0) {
							System.out.print(numList.pollFirst());
						}
						System.out.println("]");
							
					}
				}
				else {
					System.out.println("error");
				}
				
				isReversed = false;
				
			
		}
		
		sc.close();
	}
}
