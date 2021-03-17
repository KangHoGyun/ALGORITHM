package backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_14889 {
	static int N;
	static int res = 987654321;
	static int[][] arr;
	static boolean[] visited;

	public static void combination(int idx, int cnt) {
		if (cnt == N / 2) {
			int teamOne = 0;
			int teamTwo = 0;
			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					if (visited[i] == true && visited[j] == true) {
						teamOne += arr[i][j];
						teamOne += arr[j][i];
					}
					else if (visited[i] == false && visited[j] == false) {
						teamTwo += arr[i][j];
						teamTwo += arr[j][i];
					}
				}
			}

			int tmp = Math.abs(teamOne - teamTwo);
			res = Math.min(tmp, res);
			return;
		}
		for (int i = idx; i < N; ++i) {
			if (visited[i])
				continue;
			visited[i] = true;
			combination(i + 1, cnt + 1);
			visited[i] = false;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		visited = new boolean[N];
		for (int i = 0; i < N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; ++j) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		combination(0, 0);
		System.out.println(res);
	}
}
