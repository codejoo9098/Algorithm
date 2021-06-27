import java.util.Scanner;

public class B_11654 {

	public static void main(String[] args) {
		
		Scanner Input = new Scanner(System.in);
		String c = Input.next();
		//자바는 String을 배열처럼 다루지 않아서 charAt이용해야 하더라구..
		char s = c.charAt(0);//charAt 이용해서 저장을 해둔다.
		System.out.println((int)s);//int로 캐스팅하면 정수 출력하게 할 수 있다.
		
		Input.close();
	}

}
