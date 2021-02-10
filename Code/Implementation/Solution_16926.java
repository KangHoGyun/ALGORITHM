package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_16926 {
	static int N, M, R, cnt;
	static int[][] arr;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void rotate() {
		for (int i = 0; i < R; ++i) {
			for (int j = 0; j < cnt; ++j) {
				int d = 0;
				int hx = j;
				int hy = j;
				int tmp = arr[hx][hy];

				while (d < 4) {
					int nx = hx + dx[d];
					int ny = hy + dy[d];
					if (nx >= j && ny >= j && nx < N - j && ny < M - j) {
						arr[hx][hy] = arr[nx][ny];
						hx = nx;
						hy = ny;
					} else
						d++;
				}
				arr[j + 1][j] = tmp;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; ++j) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		cnt = Math.min(N, M) / 2;
		rotate();
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
