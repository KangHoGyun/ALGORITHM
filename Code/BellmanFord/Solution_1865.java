package bellmanford;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1865 {
	static int N, M, W;
	static final long INF = Long.MAX_VALUE;
	static long[] cost;
	static ArrayList<Info>[] arr;

	static class Info {
		int end, time;

		public Info(int end, int time) {
			super();
			this.end = end;
			this.time = time;
		}
	}
	
	public static void bellman() {
		boolean isCycle = false;
		cost[1] = 0;
		for(int i=0; i<N; ++i) {
			for(int j=1; j<=N; ++j) {
				for(int k=0; k<arr[j].size(); ++k) {
					int next = arr[j].get(k).end;
					int nextCost = arr[j].get(k).time;
					if(cost[j] !=INF && cost[next] > cost[j] + nextCost) {
						cost[next] = cost[j] + nextCost;
						if(i == N-1)
							isCycle = true;
					}
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < TC; ++tc) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			arr = new ArrayList[N + 1];
			cost = new long[N + 1];
			Arrays.fill(cost, INF);
			for (int i = 0; i < N + 1; ++i)
				arr[i] = new ArrayList<>();
			for(int i=0 ;i<M; ++i) {
				st = new StringTokenizer(br.readLine());
				int S = Integer.parseInt(st.nextToken());
				int E = Integer.parseInt(st.nextToken());
				int T = Integer.parseInt(st.nextToken());
				arr[S].add(new Info(E, T));
			}
			for(int i=0; i<W; ++i) {
				st = new StringTokenizer(br.readLine());
				int S = Integer.parseInt(st.nextToken());
				int E = Integer.parseInt(st.nextToken());
				int T = Integer.parseInt(st.nextToken());
				arr[S].add(new Info(E, -T));
			}
		}
	}
}
