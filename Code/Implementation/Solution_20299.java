package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_20299 {
	static int N, S, M;
	static int cnt = 0; //승인 된 팀의 개수
	static ArrayList<Integer> aL = new ArrayList<>(); // 개개인의 점수를 저장
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //신청한 조의 개수
		S = Integer.parseInt(st.nextToken()); // 각 조의 점수 합에 대한 가입 조건
		M = Integer.parseInt(st.nextToken()); // 각 조의 개개인 점수에 대한 가입 조건
		
		for(int i=0; i<N; ++i) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()); //각 조의 첫 번째 점수
			int b = Integer.parseInt(st.nextToken()); //각 조의 두 번째 점수
			int c = Integer.parseInt(st.nextToken()); //각 조의 세 번째 점수
			if(a+b+c >= S && a>=M && b>= M && c>= M) { //각각의 점수의 합이 S이상이고, 각각의 점수가 M이상인 경우
				aL.add(a); //aL이라는 ArrayList에 넣어준다.
				aL.add(b);
				aL.add(c); //조의 개수를 1개 증가시킨다.
				cnt++;
			}
		}
		sb.append(cnt + "\n");
		for(int i=0; i<aL.size(); ++i) {
			sb.append(aL.get(i) + " ");
		}
		System.out.println(sb.toString());
	}
}