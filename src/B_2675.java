import java.util.Scanner;

public class B_2675 {

	public static void main(String[] args) {
		int testcase = 0;
		int num = 0;
		String str;
		String newstr = ""; //�ƹ��͵� ���� ���ڿ��� �̷��� �����ؾ� �Ѵ�. null������ null�� �״�� �پ���´�.
		Scanner in = new Scanner(System.in);

		testcase = in.nextInt();
		in.nextLine();
		
		for (int i = 0; i < testcase; i++) {
			
			num = in.nextInt(); //����ؾ� �Ǵ°� �Է°��� ����ġ�� ���°� �ƴ϶� �����̽��� ġ�� �´ٴ� ���̴�. ���������� �����ϰ� �ڵ�¥�� ������ ��������.
			str = in.next(); //next()�� �յ� ���� ������� ������ 1�ܾ �޴´�. "  Apple " �̰͵� �׳� Apple�� �޴�
			
			for (int j = 0; j < str.length(); j++) {
				
				for (int k = 0; k < num; k++) {
					
					newstr += str.charAt(j);
					
				}
			}
			
			System.out.println(newstr);
			newstr = "";
		}
		
		in.close();
	}

}
