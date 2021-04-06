package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_19539 {
	static int N;
	static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		int res = 0;
		int sumDivideTwo = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
			res += arr[i];
			sumDivideTwo += arr[i] / 2;
		}
		if (res % 3 == 0) {
			if (sumDivideTwo >= res / 3) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		} else
			System.out.println("NO");
	}
}
