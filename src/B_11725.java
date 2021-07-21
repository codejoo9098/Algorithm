import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class B_11725 {
	static int n;
	static ArrayList<Integer>[] list;
	static int[] parent;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str;
		String[] split;
		int num1, num2;
		n = Integer.parseInt(br.readLine());

		list = new ArrayList[n + 1];
		parent = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for (int i = 1; i < n; i++) {
			str = br.readLine();
			split = str.split(" ");
			
			num1 = Integer.parseInt(split[0]);
			num2 = Integer.parseInt(split[1]);
			
			list[num1].add(num2);
			list[num2].add(num1);
		}
		
		getResult(1, -1);

		for (int i = 2; i <= n; i++) {
			System.out.println(parent[i]);
		}
		
		br.close();
		bw.flush();
		bw.close();
	}

	private static void getResult(int cur, int parentNum) {
		
		for (int i = 0; i < list[cur].size(); i++) {
			
			if (list[cur].get(i) != parentNum) {
				parent[list[cur].get(i)] = cur;
				getResult(list[cur].get(i), cur);
			}
		}
		
	}

}
