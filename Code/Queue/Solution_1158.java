package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1158 {
	static int N, K;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		Queue<Integer> q = new LinkedList<>();
		int res[] = new int[N];
		for(int i=1; i<=N; ++i) {
			q.offer(i);
		}
		int cnt = 0;
		while(!q.isEmpty()) {
			for(int i=0; i<K - 1; ++i) {
				q.add(q.poll());
			}
			res[cnt++] = q.poll();
		}
		System.out.print("<");
		for(int i=0; i<N; ++i) {
			if(i==N-1)
				System.out.print(res[i] +">");
			else
				System.out.print(res[i] + ", ");
		}
	}
}
