package b_1753;
import java.util.*;
import java.io.*;

class Node implements Comparable<Node> {
	private int index;
	private int distance;
	
	public Node(int index, int distance) {
		this.index = index;
		this.distance = distance;
	}
	
	public int getIndex() {
		return index;
	}
	
	public int getDistance() {
		return distance;
	}

	@Override
	public int compareTo(Node o) {
		return this.distance - o.distance;
	}
}

public class B_1753 {
	final static int MAX = 10000000;
	static int[] shortestDistance;
	static ArrayList<Node>[] graph;
	
	public static void dijkstra(int start) {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		queue.offer(new Node(start, 0));
		shortestDistance[start] = 0;
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			int dis = node.getDistance();
			int now = node.getIndex();
			
			if (shortestDistance[now] < dis) continue;
			if (graph[now] == null) continue;
			
			for (int i = 0; i < graph[now].size(); i++) {
				int cost = shortestDistance[now] + graph[now].get(i).getDistance();
				
				if (cost < shortestDistance[graph[now].get(i).getIndex()]) {
					shortestDistance[graph[now].get(i).getIndex()] = cost;
					queue.offer(new Node(graph[now].get(i).getIndex(), cost));
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String input;
		String[] split;
		
		input = br.readLine();
		split = input.split(" ");
		int n = Integer.parseInt(split[0]);
		int e = Integer.parseInt(split[1]);
		
		graph = new ArrayList[n + 1];
		shortestDistance = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<Node>();
		}
		
		input = br.readLine();
		int start = Integer.parseInt(input);
		
		for (int i = 0; i < e; i++) {
			input = br.readLine();
			split = input.split(" ");
			
			int a = Integer.parseInt(split[0]);
			int b = Integer.parseInt(split[1]);
			int c = Integer.parseInt(split[2]);
			
			graph[a].add(new Node(b, c));
		}
		
		Arrays.fill(shortestDistance, MAX);
		
		dijkstra(start);
		
		for (int i = 1; i <= n; i++) {
			if (shortestDistance[i] == MAX) {
				bw.write("INF\n");
			}
			else {
				bw.write(Integer.toString(shortestDistance[i]) + '\n');
			}
		}
		
		bw.flush();
		br.close();
		bw.close();
	}

}
