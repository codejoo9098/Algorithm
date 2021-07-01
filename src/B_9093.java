import java.util.Scanner;

public class B_9093 {

	public static void main(String[] args) {
		int testcase;
		String sentence;
		String[] splitedWord;
		Scanner sc = new Scanner(System.in);
		
		testcase = sc.nextInt();
		sc.nextLine();
		
		for (int i = 0; i < testcase; i++) {
			sentence = sc.nextLine();
			splitedWord = sentence.split(" ");
			
			reverseWord(splitedWord);
			System.out.println("");
		}
		
		sc.close();
	}

	private static void reverseWord(String[] splitedWord) {
		String temp = "";
		int size;
		
		for (int i = 0; i < splitedWord.length; i++) {
			size = splitedWord[i].length();
			
			for (int j = 0; j < size; j++) {
				temp += splitedWord[i].charAt(size - 1 - j);
			}
			
			splitedWord[i] = temp;
			temp = "";
			System.out.print(splitedWord[i] + " ");
		}
		
	}

}
