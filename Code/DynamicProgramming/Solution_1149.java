package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1149 {
	static int N;
	static int arr[][];
	static int dp[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][3];
		dp = new int[N][3];
		for (int i = 0; i < N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < 3; ++i) {
			dp[0][i] = arr[0][i];
		}
		for (int i = 1; i < N; ++i) {
			for (int j = 0; j < 3; ++j) {
				dp[i][j] = Math.min(dp[i - 1][(j + 1) % 3] + arr[i][j], dp[i - 1][(j + 2) % 3] + arr[i][j]);
			}
		}
		int res = 987654321;
		for (int i = 0; i < 3; ++i) {
			res = Math.min(res, dp[N - 1][i]);
		}
		System.out.println(res);
	}
}
