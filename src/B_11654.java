import java.util.Scanner;

public class B_11654 {

	public static void main(String[] args) {
		
		Scanner Input = new Scanner(System.in);
		String c = Input.next();
		//�ڹٴ� String�� �迭ó�� �ٷ��� �ʾƼ� charAt�̿��ؾ� �ϴ���..
		char s = c.charAt(0);//charAt �̿��ؼ� ������ �صд�.
		System.out.println((int)s);//int�� ĳ�����ϸ� ���� ����ϰ� �� �� �ִ�.
		
		Input.close();
	}

}
