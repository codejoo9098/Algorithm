import java.util.ArrayDeque;
import java.util.Scanner;

public class B_7562 {
	static ArrayDeque<Integer> xDeque;
	static ArrayDeque<Integer> yDeque;
	static boolean isFound = false;
	static int x2, y2;
	static int[][] chess;
	static int size;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		xDeque = new ArrayDeque<>();
		yDeque = new ArrayDeque<>();
		int x1, y1;
		
		for (int i = 0; i < testcase; i++) {
			size = sc.nextInt();
			chess = new int[size][size];
			
			x1 = sc.nextInt();
			y1 = sc.nextInt();
			
			x2 = sc.nextInt();
			y2 = sc.nextInt();
			
			if (x1 == x2 && y1 == y2) {
				System.out.println("0");
				continue;
			}
			
			xDeque.add(x1);
			yDeque.add(y1);
			chess[x1][y1] = 1;
			
			getDistance(x1, y1);
			System.out.println(chess[x2][y2] - 1);
			
			isFound = false;
			xDeque.clear();
			yDeque.clear();
		}
		
		sc.close();
	}

	private static void getDistance(int x, int y) {
		if (x + 2 < size && y + 1 < size) {
			if (chess[x + 2][y + 1] == 0) {
				chess[x + 2][y + 1] = chess[x][y] + 1;
				xDeque.addFirst(x + 2);
				yDeque.addFirst(y + 1);
				
				if (x + 2 == x2 && y + 1 == y2) {
					isFound = true;
					return;
				}
			}
		}
		
		if (x + 1 < size && y + 2 < size) {
			if (chess[x + 1][y + 2] == 0) {
				chess[x + 1][y + 2] = chess[x][y] + 1;
				xDeque.addFirst(x + 1);
				yDeque.addFirst(y + 2);
				
				if (x + 1 == x2 && y + 2 == y2) {
					isFound = true;
					return;
				}
			}
		}
		
		if (x - 1 >= 0 && y + 2 < size) {
			if (chess[x - 1][y + 2] == 0) {
				chess[x - 1][y + 2] = chess[x][y] + 1;
				xDeque.addFirst(x - 1);
				yDeque.addFirst(y + 2);
				
				if (x - 1 == x2 && y + 2 == y2) {
					isFound = true;
					return;
				}
			}
		}
		
		if (x - 2 >= 0 && y + 1 < size) {
			if (chess[x - 2][y + 1] == 0) {
				chess[x - 2][y + 1] = chess[x][y] + 1;
				xDeque.addFirst(x - 2);
				yDeque.addFirst(y + 1);
				
				if (x - 2 == x2 && y + 1 == y2) {
					isFound = true;
					return;
				}
			}
		}
		
		if (x - 2 >= 0 && y - 1 >= 0) {
			if (chess[x - 2][y - 1] == 0) {
				chess[x - 2][y - 1] = chess[x][y] + 1;
				xDeque.addFirst(x - 2);
				yDeque.addFirst(y - 1);
				
				if (x - 2 == x2 && y - 1 == y2) {
					isFound = true;
					return;
				}
			}
		}
		
		if (x - 1 >= 0 && y - 2 >= 0) {
			if (chess[x - 1][y - 2] == 0) {
				chess[x - 1][y - 2] = chess[x][y] + 1;
				xDeque.addFirst(x - 1);
				yDeque.addFirst(y - 2);
				
				if (x - 1 == x2 && y - 2 == y2) {
					isFound = true;
					return;
				}
			}
		}
		
		if (x + 1 < size && y - 2 >= 0) {
			if (chess[x + 1][y - 2] == 0) {
				chess[x + 1][y - 2] = chess[x][y] + 1;
				xDeque.addFirst(x + 1);
				yDeque.addFirst(y - 2);
				
				if (x + 1 == x2 && y - 2 == y2) {
					isFound = true;
					return;
				}
			}
		}
		
		if (x + 2 < size && y - 1 >= 0) {
			if (chess[x + 2][y - 1] == 0) {
				chess[x + 2][y - 1] = chess[x][y] + 1;
				xDeque.addFirst(x + 2);
				yDeque.addFirst(y - 1);
				
				if (x + 2 == x2 && y - 1 == y2) {
					isFound = true;
					return;
				}
			}
		}
		
		if (!xDeque.isEmpty() && !yDeque.isEmpty()) {
			xDeque.removeLast();
			yDeque.removeLast();
		}
		
		if (!xDeque.isEmpty() && !yDeque.isEmpty()) {
			getDistance(xDeque.getLast(), yDeque.getLast());
		}
		
		if (isFound) {
			return;
		}
	}

}
