package divideandconquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1074 {
	static int N, r, c;
	static int cnt = 0;
	static int[] dx = { 0, 1, 0, 1 };
	static int[] dy = { 0, 0, 1, 1 };

	public static void recursion(int x, int y, int size) {
		if (x == r && y == c) {
			System.out.println(cnt);
			return;
		}

		if (r >= x && c >= y && r < x + size && c < y + size) {
			recursion(x, y, size / 2);
			recursion(x, y + size / 2, size / 2);
			recursion(x + size / 2, y, size / 2);
			recursion(x + size / 2, y + size / 2, size / 2);
		} else
			cnt += size * size;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		recursion(0, 0, (int) Math.pow(2, N));
	}
}
