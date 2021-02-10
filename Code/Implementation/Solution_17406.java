package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_17406 {
	static int N, M, K, cnt;
	static int[][] arr, arr2;
	static int moveDir[][] = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	static ArrayList<Info> list = new ArrayList<>();
	static boolean[] visited;
	static int[] number;
	static int res = 987654321;

	static class Info {
		int r, c, s;

		public Info(int r, int c, int s) {
			this.r = r;
			this.c = c;
			this.s = s;
		}
	}

	public static void Permutation(int cnt) {
		if (cnt == K) {
			for (int i = 1; i <= N; ++i) {
				for (int j = 1; j <= M; ++j) {
					arr2[i][j] = arr[i][j];
				}
			}
			for (int i = 0; i < K; ++i) {
				rotate(list.get(number[i]).r, list.get(number[i]).c, list.get(number[i]).s);
			}
			res = Math.min(res, getMin());
			return;
		}
		for (int i = 0; i < K; ++i) {
			if (visited[i])
				continue;
			visited[i] = true;
			number[cnt] = i;
			Permutation(cnt + 1);
			visited[i] = false;
		}
	}

	public static int getMin() {
		int minCnt = 987654321;
		for (int i = 1; i <= N; ++i) {
			int minTmp = 0;
			for (int j = 1; j <= M; ++j) {
				minTmp += arr2[i][j];
			}
			minCnt = Math.min(minCnt, minTmp);
		}
		return minCnt;
	}

	public static void rotate(int r, int c, int s) {
		for (int i = s; i > 0; i--) {
			int y = r - i, x = c - i;
			int dir = 0;
			int temp = arr2[y][x];
			while (dir < 4) {
				int ny = y + moveDir[dir][0];
				int nx = x + moveDir[dir][1];

				if (ny < r - i || nx < c - i || ny > r + i || nx > c + i) {
					dir++;
				} else {
					arr2[y][x] = arr2[ny][nx];
					y = ny;
					x = nx;
				}
			}
			arr2[y][x + 1] = temp;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N + 1][M + 1];
		arr2 = new int[N + 1][M + 1];
		visited = new boolean[K];
		number = new int[K];
		for (int i = 1; i <= N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; ++j) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < K; ++i) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			list.add(new Info(r, c, s));
		}
		Permutation(0);
		System.out.println(res);
	}
}
