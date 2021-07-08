
import java.util.ArrayList;
import java.util.Scanner;

public class B_17413 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int index = 0;
		boolean isTag = false;
		ArrayList<String> split = new ArrayList<>();
		
		for (int i = 0; i < str.length(); i++) {
			
			if (str.charAt(i) == '<') {
				isTag = true;
			}
			else if (str.charAt(i) == '>') {
				isTag = false;
			}
			else if (str.charAt(i) == ' ' && !isTag){
				split.add(str.substring(index, i));
				index = i + 1;
			}
		}
		split.add(str.substring(index, str.length()));
		
		String[] answer = new String[split.size()];
		
		for (int i = 0; i < split.size(); i++) {
			answer[i] = reverseString(split.get(i));
		}
		
		for (int i = 0; i < split.size(); i++) {
			System.out.print(answer[i] + " ");
		}
		
		sc.close();
	}

	private static String reverseString(String temp) {
		String result = "";
		int index = 0;
		
		while(index != temp.length()) {
			
			if (temp.charAt(index) == '<') {
				int start = index;
				
				while(temp.charAt(index) != '>') {
					index++;
				}
				
				result += temp.substring(start, index + 1);
				index++;
			}
			else {
				int start = index;
				
				while(temp.charAt(index) != '<') {
					index++;
					
					if (index == temp.length()) {
						break;
					}
				}
				
				result += reversing(temp.substring(start, index));
			}
		}
		
		return result;
	}

	private static String reversing(String substring) {
		String temp = "";
		for (int i = 0; i < substring.length(); i++) {
			temp += substring.charAt(substring.length() - 1 - i);
		}
		
		return temp;
	}

}
