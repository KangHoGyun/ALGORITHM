package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_14502 {
	static int N, M;
	static ArrayList<Info> zeroList = new ArrayList<>();
	static ArrayList<Info> virusList = new ArrayList<>();
	static int[][] arr;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	static class Info {
		int x, y;

		public Info(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	public static int bfs(int a, int b, int c) {
		int[][] tmpArr = new int[N][M];
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				tmpArr[i][j] = arr[i][j];
			}
		}
		tmpArr[zeroList.get(a).x][zeroList.get(a).y] = 1;
		tmpArr[zeroList.get(b).x][zeroList.get(b).y] = 1;
		tmpArr[zeroList.get(c).x][zeroList.get(c).y] = 1;
		for (int k = 0; k < virusList.size(); ++k) {
			Queue<Info> q = new LinkedList<>();
			q.add(new Info(virusList.get(k).x, virusList.get(k).y));
			while (!q.isEmpty()) {
				int hx = q.peek().x;
				int hy = q.peek().y;
				q.poll();
				for (int i = 0; i < 4; ++i) {
					int nx = hx + dx[i];
					int ny = hy + dy[i];
					if (nx < 0 || ny < 0 || nx >= N || ny >= M)
						continue;
					if(tmpArr[nx][ny] == 1 || tmpArr[nx][ny] == 2)
						continue;
					tmpArr[nx][ny] = 2;
					q.add(new Info(nx, ny));
				}
			}
		}
		int cnt = 0;
		for(int i=0; i<N; ++i) {
			for(int j=0; j<M; ++j) {
				if(tmpArr[i][j] == 0)
					cnt++;
			}
		}
		return cnt;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; ++j) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 0) {
					zeroList.add(new Info(i, j));
				} else if (arr[i][j] == 2) {
					virusList.add(new Info(i, j));
				}
			}
		}
		int zeroSize = zeroList.size();
		int res = 0;
		for (int i = 0; i < zeroSize - 2; ++i) {
			for (int j = i + 1; j < zeroSize - 1; ++j) {
				for (int k = j + 1; k < zeroSize; ++k) {
					res = Math.max(res, bfs(i, j, k));
				}
			}
		}
		System.out.println(res);
	}
}
