package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_3085 {
	static int N;
	static char[][] arr;

	static class Info {
		char color;
		int deep;

		public Info(char color, int deep) {
			super();
			this.color = color;
			this.deep = deep;
		}
	}

	public static int init() {
		Stack<Info> stk = new Stack<>();
		int maxSize = 0;
		for(int i=0; i<N; ++i) { // 행 조사
			stk.add(new Info(arr[i][0], 1));
			for(int j=1; j<N; ++j) {
				if(stk.peek().color == arr[i][j]) {
					stk.add(new Info(arr[i][j], stk.peek().deep+1));
				}else {
					stk.add(new Info(arr[i][j], 1));
				}
			}
			for(int j=0; j<N; ++j) {
				int tmp = stk.peek().deep;
				maxSize = Math.max(tmp, maxSize);
				stk.pop();
			}
		}
		stk.clear();
		for(int i=0; i<N; ++i) { // 열 조사
			stk.add(new Info(arr[0][i], 1));
			for(int j=1; j<N; ++j) {
				if(stk.peek().color == arr[j][i]) {
					stk.add(new Info(arr[j][i], stk.peek().deep+1));
				}else {
					stk.add(new Info(arr[j][i], 1));
				}
			}
			for(int j=0; j<N; ++j) {
				int tmp = stk.peek().deep;
				maxSize = Math.max(tmp, maxSize);
				stk.pop();
			}
		}
		return maxSize;
	}
	public static int swap(int x, int y) {
		char tmpChar = arr[x][y];
		arr[x][y] = arr[x][y + 1];
		arr[x][y + 1] = tmpChar;

		Stack<Info> stk = new Stack<>();
		int maxSize = 0;
		for (int i = y; i < y + 2; ++i) { // 열 조사
			stk.add(new Info(arr[0][i], 1));
			for (int j = 1; j < N; ++j) {
				if (stk.peek().color == arr[j][i]) {
					stk.add(new Info(arr[j][i], stk.peek().deep + 1));
				} else {
					stk.add(new Info(arr[j][i], 1));
				}
			}
			for (int j = 0; j < N; ++j) {
				int tmp = stk.peek().deep;
				maxSize = Math.max(tmp, maxSize);
				stk.pop();
			}
		}
		stk.clear();
		stk.add(new Info(arr[x][0], 1));
		for (int j = 1; j < N; ++j) {
			if (stk.peek().color == arr[x][j]) {
				stk.add(new Info(arr[x][j], stk.peek().deep + 1));
			} else {
				stk.add(new Info(arr[x][j], 1));
			}
		}
		for (int j = 0; j < N; ++j) {
			int tmp = stk.peek().deep;
			maxSize = Math.max(tmp, maxSize);
			stk.pop();
		}

		tmpChar = arr[x][y];
		arr[x][y] = arr[x][y + 1];
		arr[x][y + 1] = tmpChar;

		return maxSize;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new char[N][N];
		for (int i = 0; i < N; ++i) {
			String str = br.readLine();
			for (int j = 0; j < N; ++j) {
				arr[i][j] = str.charAt(j);
			}
		}
		int res = init();
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N - 1; ++j) {
				res = Math.max(res, swap(i, j));
			}
		}
		System.out.println(res);
	}
}
