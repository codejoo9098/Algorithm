
import java.util.Scanner;

class Tree {
	int num;
	Tree leftSibling;
	Tree rightSibling;
	
	public Tree(int num) {
		this.num = num;
		this.leftSibling = null;
		this.rightSibling = null;
	}
	
	public static void getPosition(int target, Tree tree) {
		
		if(target < tree.num) {
			if (tree.leftSibling == null) {
				tree.leftSibling = new Tree(target);
			}
			else {
				getPosition(target, tree.leftSibling);
			}
		}
		else {
			if (tree.rightSibling == null) {
				tree.rightSibling = new Tree(target);
			}
			else {
				getPosition(target, tree.rightSibling);
			}
		}
		
	}
	
	public static void postOrder(Tree tree) {
		if (tree.leftSibling != null) {
			postOrder(tree.leftSibling);
		}
		if (tree.rightSibling != null) {
			postOrder(tree.rightSibling);
		}
		System.out.println(tree.num);
	}
}

public class B_5639 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		Tree tree = new Tree(num);
		
		while(sc.hasNextInt()) {
			num = sc.nextInt();
			
			Tree.getPosition(num, tree);
		}
		
		Tree.postOrder(tree);
		
		sc.close();
	}

}
