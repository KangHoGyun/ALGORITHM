package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution_17103 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		int MAX = 1000000;
		boolean[] check = new boolean[MAX + 1];
		ArrayList<Integer> arr = new ArrayList<>();
		for (int i = 2; i <= MAX; ++i) {
			if (!check[i]) {
				arr.add(i);
				for (int j = i + i; j <= MAX; j += i) {
					check[j] = true;
				}
			}
		}
		for (int tc = 0; tc < T; ++tc) {
			int N = Integer.parseInt(br.readLine());
			int ans = 0;
			for (int x : arr) {
				int y = N - x;
				if (x <= y && !check[y]) {
					ans++;
				}
			}
			sb.append(ans + "\n");
		}
		System.out.println(sb);
	}
}
