package b_1647;
import java.util.*;
import java.io.*;

class Edge implements Comparable<Edge> {
	
	private int distance;
	private int nodeA;
	private int nodeB;
	
	public Edge(int distance, int nodeA, int nodeB) {
		this.distance = distance;
		this.nodeA = nodeA;
		this.nodeB = nodeB;
	}
	
	public int getDistance() {
		return distance;
	}
	
	public int getNodeA() {
		return nodeA;
	}
	
	public int getNodeB() {
		return nodeB;
	}

	@Override
	public int compareTo(Edge o) {
		return this.distance - o.distance;
	}
}

public class B_1647 {
	static int[] parent;
	static ArrayList<Edge> edge = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;
		String[] split;
		
		input = br.readLine();
		split = input.split(" ");
		int n = Integer.parseInt(split[0]);
		int m = Integer.parseInt(split[1]);
		
		parent = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}
		
		for (int i = 0; i < m; i++) {
			input = br.readLine();
			split = input.split(" ");
			
			int a = Integer.parseInt(split[0]);
			int b = Integer.parseInt(split[1]);
			int c = Integer.parseInt(split[2]);
			
			edge.add(new Edge(c, a, b));
		}
		
		Collections.sort(edge);
		
		int result = 0;
		int index = 0;
		
		for (int i = 0; i < m; i++) {
			int cost = edge.get(i).getDistance();
			int a = edge.get(i).getNodeA();
			int b = edge.get(i).getNodeB();
			
			if (findParent(a) != findParent(b)) {
				unionParent(a, b);
				result += cost;
				index++;
			}
			else {
				continue;
			}
			
			if (index >= n - 2) {
				break;
			}
		}
		
		System.out.println(result);
		
		br.close();
	}
	
	public static int findParent(int x) {
		if (x == parent[x]) return x;
		return x = findParent(parent[x]);
	}

	public static void unionParent(int a, int b) {
		a = findParent(a);
		b = findParent(b);
		
		if (a < b) {
			parent[b] = a;
		}
		else {
			parent[a] = b;
		}
	}
}
