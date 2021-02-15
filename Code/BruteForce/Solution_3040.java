package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_3040 {
	static int[] arr;
	static int[] res;
	static boolean[] visited;

	public static void calc(int idx, int cnt) {
		if (cnt == 7) {
			int sum = 0;
			for (int i = 0; i < 9; ++i) {
				if (visited[i])
					sum += arr[i];
			}
			if (sum == 100) {
				int num = 0;
				for (int i = 0; i < 9; ++i) {
					if(visited[i])
						res[num++] = arr[i];
				}
			}
			return;
		}
		for (int i = idx; i < 9; ++i) {
			if (visited[i])
				continue;
			visited[i] = true;
			calc(i, cnt + 1);
			visited[i] = false;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[9];
		res = new int[7];
		visited = new boolean[9];
		for (int i = 0; i < 9; ++i) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		calc(0, 0);
		for (int i = 0; i < 7; ++i) {
			System.out.println(res[i]);
		}
	}
}
