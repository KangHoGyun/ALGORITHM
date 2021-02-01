package solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1244 {
	public static int N;
	public static int num;
	public static int[] arr;
	public static Queue<Info> q = new LinkedList<>();

	static class Info {
		int gender;
		int index;

		public Info(int gender, int index) {
			this.gender = gender;
			this.index = index;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		num = Integer.parseInt(br.readLine());
		for (int i = 0; i < num; ++i) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int index = Integer.parseInt(st.nextToken());
			q.offer(new Info(gender, index));
		}

		for (int i = 0; i < num; ++i) {
			if (q.peek().gender == 1) {
				int cnt = 0;
				while (true) {
					int tmp = q.peek().index - 1 + cnt * q.peek().index;
					if (tmp > N - 1)
						break;
					if (arr[tmp] == 0)
						arr[tmp] = 1;
					else
						arr[tmp] = 0;
					cnt++;
				}
				q.poll();
			} else {
				int cnt = 1;
				if (arr[q.peek().index - 1] == 0)
					arr[q.peek().index - 1] = 1;
				else
					arr[q.peek().index - 1] = 0;
				while (true) {
					int tmp = q.peek().index - 1;
					if (tmp - cnt < 0 || tmp + cnt >= N)
						break;
					if (arr[tmp - cnt] == 0 && arr[tmp + cnt] == 0) {
						arr[tmp - cnt] = 1;
						arr[tmp + cnt] = 1;
					} else if (arr[tmp - cnt] == 1 && arr[tmp + cnt] == 1) {
						arr[tmp - cnt] = 0;
						arr[tmp + cnt] = 0;
					} else {
						break;
					}
					cnt++;
				}
				q.poll();
			}
		}
		for (int i = 1; i <= N; ++i) {
			System.out.print(arr[i - 1] + " ");
			if (i % 20 == 0)
				System.out.println();
		}
	}
}
