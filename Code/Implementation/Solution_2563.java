package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2563 {
	static int N;
	static int[][] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		int res = 0;
		arr = new int[100][100];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			for (int j = x; j < x + 10; ++j) {
				for (int k = y; k < y + 10; ++k) {
					arr[j][k] = 1;
				}
			}
		}
		for (int j = 0; j < 100; ++j) {
			for (int k = 0; k < 100; ++k) {
				if (arr[j][k] == 1)
					res += arr[j][k];
			}
		}
		System.out.println(res);
	}
}
