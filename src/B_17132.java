import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

class House {
	public int homeNumber;
	public int satisfaction;
	
	public House(int homeNumber, int satisfaction) {
		this.homeNumber = homeNumber;
		this.satisfaction = satisfaction;
	}
}


public class B_17132 {
	static ArrayList<House>[] houseInfo;
	static int min = 201;
	static int minSum = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int houseNum = Integer.parseInt(br.readLine());
		String split[];
		houseInfo = new ArrayList[houseNum + 1];
		int startPoint = 0;
		int visitedPoint = 0;
		
		for (int i = 1; i <= houseNum; i++) {
			houseInfo[i] = new ArrayList<House>();
		}
		
		for (int i = 0; i < houseNum - 1; i++) {
			String str = br.readLine();
			split = str.split(" ");
			
			int n1 = Integer.parseInt(split[0]);
			int n2 = Integer.parseInt(split[1]);
			int n3 = Integer.parseInt(split[2]);
			
			houseInfo[n1].add(new House(n2, n3));
			houseInfo[n2].add(new House(n1, n3));
		}
		
		for (int i = 1; i <= houseNum; i++) {
			if (houseInfo[i].size() == 1) {
				startPoint = i;
				break;
			}
		}
		
		searchSatisfaction(startPoint, -1);
		
		visitedPoint = startPoint;
		startPoint = houseInfo[startPoint].get(0).homeNumber;
		min = 201;
		
		for (int i = 1; i < houseNum; i++) {
			searchSatisfaction(startPoint, visitedPoint);
			
			if (houseInfo[startPoint].get(0).homeNumber != visitedPoint) {
				visitedPoint = startPoint;
				startPoint = houseInfo[startPoint].get(0).homeNumber;
			}
			else if (houseInfo[startPoint].size() > 1 && houseInfo[startPoint].get(1).homeNumber != visitedPoint){
				visitedPoint = startPoint;
				startPoint = houseInfo[startPoint].get(1).homeNumber;
			}
			
			min = 201;
		}
		
		System.out.println(minSum);
		br.close();
	}
	
	static void searchSatisfaction(int startPoint, int visitedPoint) {
		if (houseInfo[startPoint].size() == 1 && houseInfo[startPoint].get(0).homeNumber == visitedPoint) {
			return;
		}
		
		if (houseInfo[startPoint].get(0).homeNumber != visitedPoint) {
			if (houseInfo[startPoint].get(0).satisfaction < min) {
				min = houseInfo[startPoint].get(0).satisfaction;
			}
			
			minSum += min;
			searchSatisfaction(houseInfo[startPoint].get(0).homeNumber, startPoint);
		}
		else {
			if (houseInfo[startPoint].get(1).satisfaction < min) {
				min = houseInfo[startPoint].get(1).satisfaction;
			}
			
			minSum += min;
			searchSatisfaction(houseInfo[startPoint].get(1).homeNumber, startPoint);
		}
	}

}
