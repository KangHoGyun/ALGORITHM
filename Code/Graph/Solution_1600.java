package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1600 {
	static final int[] dx = { 0, 1, 0, -1 };
	static final int[] dy = { 1, 0, -1, 0 };
	static final int[] hx = { -2, -1, 1, 2, 2, 1, -1, -2 };
	static final int[] hy = { 1, 2, 2, 1, -1, -2, -2, -1 };
	static final int INF = 987654321;
	static int K, W, H, res;
	static int[][] arr;
	static boolean[][][] visited;

	static class Info {
		int x, y, dist, cnt;

		public Info(int x, int y, int dist, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.dist = dist;
			this.cnt = cnt;
		}
	}

	public static void bfs() {
		Queue<Info> q = new LinkedList<>();
		q.add(new Info(0, 0, 0, 0));
		visited[0][0][0] = true;
		while (!q.isEmpty()) {
			int px = q.peek().x;
			int py = q.peek().y;
			int pdist = q.peek().dist;
			int pcnt = q.peek().cnt;
			q.poll();
			if (px == H - 1 && py == W - 1) {
				res = Math.min(res, pdist);
			}
			for (int i = 0; i < 12; ++i) {
				int nx = 0;
				int ny = 0;
				int ncnt = pcnt;
				if (i < 4) {
					nx = px + dx[i];
					ny = py + dy[i];
				} else {
					if (pcnt >= K)
						continue;
					nx = px + hx[i - 4];
					ny = py + hy[i - 4];
					ncnt++;
				}
				if (nx < 0 || ny < 0 || nx >= H || ny >= W)
					continue;
				if (arr[nx][ny] == 1 || visited[nx][ny][ncnt])
					continue;
				visited[nx][ny][ncnt] = true;
				q.add(new Info(nx, ny, pdist + 1, ncnt));
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken()); // 가로
		H = Integer.parseInt(st.nextToken()); // 세로
		arr = new int[H][W];
		visited = new boolean[H][W][31];
		res = INF;
		for (int i = 0; i < H; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; ++j) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		bfs();
		if(res == INF)
			System.out.println("-1");
		else
			System.out.println(res);
	}
}
