import java.util.Scanner;

public class B_1152 {

	public static void main(String[] args) {
		int n = 0;
		String str;
		Scanner Input = new Scanner(System.in);
		str = Input.nextLine();

		if (str.charAt(0) == ' '&&str.length() == 1) {
			System.out.println(0);
			System.exit(1);
		}
		/*
		 ��.. �� ���� �ϳ������� Ʋ�Ƚ��ϴٰ� ����..
		 ���� ��ҹ���+���⸸���� �̷�����ִٰ� �����ϱ� ���� �ϳ� �ִ� ����� ���� �����߾�߉����.
		 �������� ���� �� �м��ϰ� �̷� �ش����� ����� ���� �����غ���..
		 */
		for(int i = 1; i < str.length()-1; i++) {
			if (str.charAt(i) == ' ') {
				n++;
			}
		}
		
		System.out.println(n + 1);
		Input.close();
	}

}
