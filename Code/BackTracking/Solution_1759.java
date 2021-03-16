package backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1759 {
	static int L, C;
	static char []arr;
	static boolean []check;
	static boolean []visited;
	static StringBuilder sb = new StringBuilder();
	static void combination(int idx, int cnt) {
		if(cnt == L) {
			int checkCnt1 = 0;
			int checkCnt2 = 0;
			for(int i=0; i<C; ++i) {
				if(visited[i]) {
					if(check[i]) {
						checkCnt1++;
					}else {
						checkCnt2++;
					}
				}
			}
			if(checkCnt1 >=1 && checkCnt2 >=2) {
				for(int i=0; i<C; ++i) {
					if(visited[i])
						sb.append(arr[i]);
				}
				sb.append("\n");
			}
			return;
		}
		for(int i=idx; i<C; ++i) {
			if(visited[i])
				continue;
			visited[i] = true;
			combination(i + 1, cnt + 1);
			visited[i] = false;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[C];
		check = new boolean[C];
		visited = new boolean[C];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<C; ++i) {
			arr[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(arr);
		for(int i=0; i<C; ++i) {
			if(arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u')
				check[i] = true;
		}
		combination(0, 0);
		System.out.println(sb);
	}
}
