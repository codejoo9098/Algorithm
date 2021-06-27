import java.util.Scanner;

class Compute{
	int x;
	int y;
	int z;
}

public class B_17256 {

	public static void main(String[] args) {
		Compute a = new Compute();
		Compute b = new Compute();
		Compute c = new Compute();

		Scanner sc = new Scanner(System.in);
		
		a.x = sc.nextInt();
		a.y = sc.nextInt();
		a.z = sc.nextInt();
		sc.nextLine();
		
		c.x = sc.nextInt();
		c.y = sc.nextInt();
		c.z = sc.nextInt();
		sc.nextLine();
		
		b.x = c.x - a.z;
		b.y = c.y/a.y;
		b.z = c.z-a.x;
		
		System.out.print(b.x + " " + b.y + " " + b.z);
		sc.close();
	}

}
