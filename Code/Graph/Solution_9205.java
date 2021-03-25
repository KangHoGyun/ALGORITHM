package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_9205 {
	static int N;
	static int[][] arr;

	public static boolean bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.add(0);
		boolean[] visited = new boolean[N + 2];
		visited[0] = true;
		while (!q.isEmpty()) {
			int now = q.poll();
			for (int i = 1; i < N + 2; ++i) {
				int distX = Math.abs(arr[now][0] - arr[i][0]);
				int distY = Math.abs(arr[now][1] - arr[i][1]);
				if (distX + distY <= 1000) {
					if (!visited[i]) {
						visited[i] = true;
						q.add(i);
						if (i == N + 1)
							return true;
					}
				}
			}
		}
		return false;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < TC; ++tc) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N + 2][2];
			for (int i = 0; i < N + 2; ++i) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}
			if (bfs())
				sb.append("happy\n");
			else
				sb.append("sad\n");
		}
		System.out.println(sb);
	}
}
