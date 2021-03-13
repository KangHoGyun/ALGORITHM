package solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Solution_1753 {
	static int V, E, K;
	static int[] cost;
	static final int INF = 987654321;
	static ArrayList<Info>[] arr;
	static class Info implements Comparable<Info>{
		int v, w;
		public Info(int v, int w) {
			super();
			this.v = v;
			this.w = w;
		}
		@Override
		public int compareTo(Info a) {
			return w - a.w;
		}
	}

	public static void bfs(int start) {
		boolean[] visited = new boolean[V + 1];
		PriorityQueue<Info> pq = new PriorityQueue<Info>();
		pq.add(new Info(start, 0));
		cost[start] = 0;
		while (!pq.isEmpty()) {
			int nx = pq.poll().v;
			
			if(visited[nx])
				continue;
			visited[nx] = true;
			for (int i = 0; i < arr[nx].size(); ++i) {
				int next = arr[nx].get(i).v;
				int nextCost = arr[nx].get(i).w;

				if (cost[next] > nextCost + cost[nx]) {
					cost[next] = nextCost + cost[nx];
					pq.add(new Info(next, cost[next]));
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		arr = new ArrayList[V + 1];
		cost = new int[V + 1];
		for (int i = 0; i < V + 1; ++i) {
			arr[i] = new ArrayList<>();
		}
		for (int i = 0; i < E; ++i) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			arr[u].add(new Info(v, w));
		}
		Arrays.fill(cost, INF);
		bfs(K);
		for (int i = 1; i <= V; ++i) {
			if (cost[i] == INF)
				sb.append("INF\n");
			else
				sb.append(cost[i] + "\n");
		}
		System.out.println(sb.toString());
	}
}
