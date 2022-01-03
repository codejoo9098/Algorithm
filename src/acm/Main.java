package acm;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int power[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		n *= 2;
		power = new int[n];
		
		for (int i = 0; i < n; i++) {
			power[i] = sc.nextInt();
		}
		
		Arrays.sort(power);
		
		int scoreMin = 300000;
		int temp = 0;
		for (int i = 0; i < n / 2; i++) {
			temp = power[i] + power[n - 1 - i];
			if (temp < scoreMin) {
				scoreMin = temp;
			}
		}
		
		System.out.println(scoreMin);
		sc.close();
	}

}
