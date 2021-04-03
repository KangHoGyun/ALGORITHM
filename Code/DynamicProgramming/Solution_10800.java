package ssafyCote;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution_10800 {
	static int N;
	static class Info implements Comparable<Info> {
		int num, size, ball;

		public Info(int num, int size, int ball) {
			super();
			this.num = num;
			this.size = size;
			this.ball = ball;
		}

		@Override
		public int compareTo(Info o) {
			return o.size - size;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		ArrayList<Info> arr = new ArrayList<>();
		int[] res = new int[N + 1];
		for (int i = 0; i < N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int size = Integer.parseInt(st.nextToken());
			arr.add(new Info(num, size, i + 1));
		}
		Collections.sort(arr);
		for (int i = 0; i < N - 1; ++i) {
			int num = arr.get(i).num;
			int size = arr.get(i).size;
			int ball = arr.get(i).ball;
			for (int j = i + 1; j < N; ++j) {
				int num2 = arr.get(j).num;
				int size2 = arr.get(j).size;
				if (num == num2)
					continue;
				if (size != size2) {
					res[ball] += size2;
				}
			}
		}
		for(int i=1; i<=N; ++i) {
			sb.append(res[i] + "\n");
		}
		System.out.println(sb);
	}
}
