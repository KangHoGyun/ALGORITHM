package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3109 {
	static int R, C;
	static char[][] arr;
	static boolean[][] visited;
	static boolean[] arrived;
	static int[] dx = { -1, 0, 1 };
	static int[] dy = { 1, 1, 1 };
	static boolean check;

	public static void dfs(int x, int y) {
		if(check)
			return;
		visited[x][y] = true;
		for (int i = 0; i < 3; ++i) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < 0 || nx >= R)
				continue;
			if (ny == C - 1) {
				if (!arrived[nx]) {
					arrived[nx] = true;
					check = true;
				}
				return;
			}
			if (arr[nx][ny] == '.' && !visited[nx][ny]) {
				dfs(nx, ny);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[R][C];
		visited = new boolean[R][C];
		arrived = new boolean[R];
		for (int i = 0; i < R; ++i) {
			String str = br.readLine();
			for (int j = 0; j < C; ++j) {
				arr[i][j] = str.charAt(j);
			}
		}
		int res = 0;
		for(int i=0; i<R; ++i) {
			check = false;
			dfs(i, 0);
		}
		for(int i=0; i<R; ++i) {
			if(arrived[i])
				res++;
		}
		System.out.println(res);
	}
}
