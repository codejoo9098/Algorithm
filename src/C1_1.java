
import java.util.ArrayList;
import java.util.List;

/*
You should use the statndard input/output

in order to receive a score properly.

Do not use file input and output

Please be very careful. 
*/

import java.util.Scanner;

/*
   As the name of the class should be Solution , using Solution.java as the filename is recommended.
   In any case, you can execute your program by running 'java Solution' command.
 */
class C1_1 {
	static int Answer;

	public static void main(String args[]) throws Exception	{
		int index = 0;
		boolean isJumpPossible = false;
		int position = 0;
		int num, maxJump;
		//List<Integer> ary = new ArrayList<>();
		/*
		   The method below means that the program will read from input.txt, instead of standard(keyboard) input.
		   To test your program, you may save input data in input.txt file,
		   and call below method to read from the file when using nextInt() method.
		   You may remove the comment symbols(//) in the below statement and use it.
		   But before submission, you must remove the freopen function or rewrite comment symbols(//).
		 */		

		/*
		   Make new scanner from standard input System.in, and read data.
		 */
		Scanner sc = new Scanner(System.in);
		//Scanner sc = new Scanner(new FileInputStream("input.txt"));

		int T = sc.nextInt();
		sc.nextLine();
		for(int test_case = 0; test_case < T; test_case++) {
			num = sc.nextInt();
			sc.nextLine();
			
			int[] ary = new int[num];
			
			for (int i = 0; i < ary.length; i++) {
				ary[i] = sc.nextInt();
			}
			sc.nextLine();
			
			maxJump = sc.nextInt();
			
			while(position != ary[num - 1]) {
				
				while(true) {
					
					if (index < num && ary[index] <= position + maxJump) {
						index++;
						isJumpPossible = true;
					}
					else {
						
						try {
							position = ary[index - 1];
							break;
						} catch (NullPointerException  e) {
							break;
						}
						
					}
				}
				
				if (isJumpPossible == false) {
					Answer = -1;
					break;
				}
				
				Answer++;
				isJumpPossible = false;
			}
			// Answer = 0;
			/////////////////////////////////////////////////////////////////////////////////////////////
			/*
			   Implement your algorithm here.
			   The answer to the case will be stored in variable Answer.
			 */
			/////////////////////////////////////////////////////////////////////////////////////////////

			// Print the answer to standard output(screen).
			System.out.println("Case #"+(test_case+1));
			System.out.println(Answer);
			Answer = 0;
			position = 0;
			index = 0;
		}
	}
}