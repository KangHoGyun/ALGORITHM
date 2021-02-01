package Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_17478 {
	public static int N;
	public static StringBuilder sb = new StringBuilder();

	public static String rec(int cnt) {
		if (cnt == N + 1)
			return "";
		StringBuilder tmp = new StringBuilder();
		StringBuilder minus = new StringBuilder();
		for (int i = 1; i < cnt; ++i) {
			minus.append("____");
		}
		tmp.append(minus);
		tmp.append('"' + "재귀함수가 뭔가요?" + '"' + '\n');
		tmp.append(minus);
		tmp.append('"' + "잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어." + '\n');
		tmp.append(minus + "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n");
		tmp.append(minus + "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어." + '"' + '\n');
		System.out.print(tmp.toString());

		tmp.delete(0, tmp.length());
		return tmp.toString() + rec(cnt + 1);

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
		System.out.print(rec(1));
		StringBuilder res = new StringBuilder();
		StringBuilder minus = new StringBuilder();
		for (int i = 0; i < N; ++i) {
			minus.append("____");
		}
		res.append(minus);
		res.append('"' + "재귀함수가 뭔가요?" + '"' + '\n');
		res.append(minus);
		res.append('"' + "재귀함수는 자기 자신을 호출하는 함수라네" + '"' + '\n');
		System.out.print(res.toString());
		for (int i = 0; i < N; ++i) {
			StringBuilder res2 = new StringBuilder();
			StringBuilder minus2 = new StringBuilder();
			for (int j = i; j < N; ++j) {
				minus2.append("____");
			}
			res2.append(minus2 + "라고 답변하였지.");
			System.out.println(res2.toString());
		}
		System.out.println("라고 답변하였지.");
	}
}
