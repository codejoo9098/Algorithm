import java.util.Scanner;

public class B_11720 {

	public static void main(String[] args) {
		int n = 0;
		int k = 0;
		char c = '0';
		int sum = 0;
		String str;
		Scanner Input = new Scanner(System.in);
		
		n = Input.nextInt();
		Input.nextLine();
		
		str = Input.nextLine();
		
		for (int i = 0; i < n; i++) {
			k = str.charAt(i) - c; //charAt�� �ƽ�Ű�ڵ��� char���̶�� ���� �̿��ϸ� ���ϴ�. �ٵ� �װ� ���� �Լ����°͵� ��������
			sum += k;
		}
		
		System.out.println(sum);
		Input.close();
	}

}
