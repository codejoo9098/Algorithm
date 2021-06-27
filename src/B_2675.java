import java.util.Scanner;

public class B_2675 {

	public static void main(String[] args) {
		int testcase = 0;
		int num = 0;
		String str;
		String newstr = ""; //아무것도 없는 문자열은 이렇게 설정해야 한다. null넣으면 null이 그대로 붙어서나온다.
		Scanner in = new Scanner(System.in);

		testcase = in.nextInt();
		in.nextLine();
		
		for (int i = 0; i < testcase; i++) {
			
			num = in.nextInt(); //기억해야 되는게 입력값은 엔터치고 오는게 아니라 스페이스바 치고 온다는 것이다. 엔터쳤을때 생각하고 코드짜면 컴파일 에러난다.
			str = in.next(); //next()는 앞뒤 공백 상관없이 무조건 1단어를 받는다. "  Apple " 이것도 그냥 Apple을 받는
			
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
