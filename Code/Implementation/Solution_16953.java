package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_16953 {
	static int N, M, R;
	static int[][] arr, tmp;
	static int[] number;

	public static void calculation(int num, int cnt) {
		while (cnt > 0) {		
			if (num == 1) {
				for (int i = 0; i < N; ++i)
					for (int j = 0; j < M; ++j)
						tmp[i][j] = arr[N - 1 - i][j];

				for (int i = 0; i < N; ++i)
					for (int j = 0; j < M; ++j)
						arr[i][j] = tmp[i][j];
				cnt--;
				
			} else if (num == 2) {
				for (int i = 0; i < N; ++i)
					for (int j = 0; j < M; ++j)
						tmp[i][j] = arr[i][M - 1 - j];

				for (int i = 0; i < N; ++i)
					for (int j = 0; j < M; ++j)
						arr[i][j] = tmp[i][j];
				cnt--;
			} else if (num == 3) {
				for (int i = 0, x = 0; i < M; i++, x++) {
					for (int j = N - 1, y = 0; j >= 0; j--, y++)
						tmp[x][y] = arr[j][i];
				}

				int temp = N;
				N = M;
				M = temp;

				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++)
						arr[i][j] = tmp[i][j];
				}
				cnt--;
			} else if (num == 4) {
				for (int i = M - 1, x = 0; i >= 0; i--, x++) {
					for (int j = 0, y = 0; j < N; j++, y++)
						tmp[x][y] = arr[j][i];
				}

				int temp = N;
				N = M;
				M = temp;

				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++)
						arr[i][j] = tmp[i][j];
				}
				cnt--;
			} else if (num == 5) {

				for (int i = 0; i < N / 2; ++i)
					for (int j = 0; j < M / 2; ++j)
						tmp[i][j + M / 2] = arr[i][j];

				for (int i = 0; i < N / 2; ++i)
					for (int j = 0; j < M / 2; ++j)
						tmp[i + N / 2][j + M / 2] = arr[i][j + M / 2];

				for (int i = 0; i < N / 2; ++i)
					for (int j = 0; j < M / 2; ++j)
						tmp[i + N / 2][j] = arr[i + N / 2][j + M / 2];

				for (int i = 0; i < N / 2; ++i)
					for (int j = 0; j < M / 2; ++j)
						tmp[i][j] = arr[i + N / 2][j];

				for (int i = 0; i < N; ++i)
					for (int j = 0; j < M; ++j)
						arr[i][j] = tmp[i][j];
				cnt--;
			} else if (num == 6) {

				for (int i = 0; i < N / 2; ++i)
					for (int j = 0; j < M / 2; ++j)
						tmp[i + N / 2][j + M / 2] = arr[i + N / 2][j];

				for (int i = 0; i < N / 2; ++i)
					for (int j = 0; j < M / 2; ++j)
						tmp[i][j + M / 2] = arr[i + N / 2][j + M / 2];

				for (int i = 0; i < N / 2; ++i)
					for (int j = 0; j < M / 2; ++j)
						tmp[i + N / 2][j] = arr[i][j];

				for (int i = 0; i < N / 2; ++i)
					for (int j = 0; j < M / 2; ++j)
						tmp[i][j] = arr[i][j + M / 2];

				for (int i = 0; i < N; ++i)
					for (int j = 0; j < M; ++j)
						arr[i][j] = tmp[i][j];
				cnt--;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		arr = new int[100][100];
		tmp = new int[100][100];
		number = new int[R];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; ++j) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		int idx = 0;
		while (st.hasMoreTokens()) {
			number[idx++] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < R; ++i) {
			calculation(number[i], 1);
		}
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
