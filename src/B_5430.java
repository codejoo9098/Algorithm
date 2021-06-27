import java.util.Scanner;
import java.util.Vector;

public class B_5430 {

	public static void main(String[] args) {
		int testcase;
		String functionComb;
		int size;
		String aryString;
		String[] splitAry;
		int temp;
		Vector<Integer> numList = new Vector<>();
		Scanner sc = new Scanner(System.in);
		
		testcase = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < testcase; i++) {
			functionComb = sc.nextLine();
			size = sc.nextInt();
			aryString = sc.nextLine();
			
			aryString = aryString.substring(0, aryString.length() - 1);
			try {
				splitAry = aryString.split(",");
				
				for (int j = 0; j < splitAry.length; j++) {
					temp = Integer.parseInt(splitAry[i]);
					numList.add(temp);
				}
				
			} catch (Exception e) {
				System.out.println("error");
				break;
			}
		}
	}

}
