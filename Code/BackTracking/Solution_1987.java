package backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1987 {
	static int R, C, res, cnt;
	static char[][] arr;
	static boolean[] alpha;
	static boolean check;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void dfs(int x, int y) {
		alpha[arr[x][y] - 'A'] = true;
		cnt++;
		res = Math.max(cnt, res);

		for (int i = 0; i < 4; ++i) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < 0 || ny < 0 || nx >= R || ny >= C)
				continue;;
			if (!alpha[arr[nx][ny] - 'A']) {
				dfs(nx, ny);
				alpha[arr[nx][ny] - 'A'] = false;
				cnt--;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[R][C];
		alpha = new boolean[26];
		for (int i = 0; i < R; ++i) {
			String str = br.readLine();
			for (int j = 0; j < C; ++j) {
				arr[i][j] = str.charAt(j);
			}
		}
		dfs(0, 0);
		System.out.println(res);
	}
}
