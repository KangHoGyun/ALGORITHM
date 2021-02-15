package backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1182 {
	static int N, S, res;
	static int[] arr;
	static boolean[] visited;

	public static void recursion(int cnt, int sum) {
		if (cnt == N) {
			if (sum == S)
				res++;
			return;
		}
		recursion(cnt + 1, sum + arr[cnt]);
		recursion(cnt + 1, sum);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new int[N];
		visited = new boolean[N];
		res = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i)
			arr[i] = Integer.parseInt(st.nextToken());
		recursion(0, 0);
		if (S == 0)
			res--;
		System.out.println(res);
	}
}
