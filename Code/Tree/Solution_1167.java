package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_1167 {
	static int N, maxIdx;
	static long maxWeight;
	static ArrayList<Info>[] arr;
	static boolean[] visited;

	static class Info {
		int v, weight;

		public Info(int v, int weight) {
			this.v = v;
			this.weight = weight;
		}
	}

	public static void dfs(int start, int weight) {
		visited[start] = true;

		if (weight > maxWeight) {
			maxWeight = weight;
			maxIdx = start;
		}

		for (int i = 0; i < arr[start].size(); ++i) {
			if (!visited[arr[start].get(i).v]) {
				dfs(arr[start].get(i).v, weight + arr[start].get(i).weight);
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		arr = new ArrayList[N + 1];
		visited = new boolean[N + 1];
		for (int i = 0; i <= N; ++i)
			arr[i] = new ArrayList<Info>();

		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			ArrayList<Integer> tmp = new ArrayList<>();
			while (st.hasMoreTokens()) {
				tmp.add(Integer.parseInt(st.nextToken()));
			}
			int idx = 1;
			while (true) {
				if (tmp.get(idx) == -1)
					break;
				arr[tmp.get(0)].add(new Info(tmp.get(idx), tmp.get(idx + 1)));
				arr[tmp.get(idx)].add(new Info(tmp.get(0), tmp.get(idx + 1)));
				idx += 2;
			}
		}
		dfs(1, 0);
		visited = new boolean[N + 1];
		dfs(maxIdx, 0);
		System.out.println(maxWeight);
	}
}
