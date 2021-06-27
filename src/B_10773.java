
import java.util.Scanner;

class IntStack {
	private int Num[];
	private int manyitems;
	
	public IntStack(int init) {
		Num = new int[init];
		manyitems = 0;
	}
	
	public void push(int PushNum) {
		Num[manyitems] = PushNum;
		manyitems++;
	}
	
	public void pop() {
		Num[manyitems - 1] = 0;
		manyitems--;
	}
	
	public int sum() {
		int total = 0;
		
		for (int i = 0; i < manyitems; i++) {
			total += Num[i];
		}
		
		return total;
	}
}

public class B_10773 {

	public static void main(String[] args) {
		int NumCase;
		int InputNum;
		Scanner sc = new Scanner(System.in);
		
		NumCase = sc.nextInt();
		IntStack p1 = new IntStack(NumCase);
		
		for (int i = 0; i < NumCase; i++) {
			InputNum = sc.nextInt();
			
			if (InputNum == 0) {
				p1.pop();
			}
			else {
				p1.push(InputNum);
			}
		}
		
		System.out.println(p1.sum());
		sc.close();
	}

}
