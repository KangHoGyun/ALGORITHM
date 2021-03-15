package solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_16890 {
	static Queue<Integer> res = new LinkedList<>();
	static Deque<Integer> dq1 = new LinkedList<>();
	static Deque<Integer> dq2= new LinkedList<>();
	static String front = "";
	static String back = "";
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1 = br.readLine();
		String str2 = br.readLine();

		char [] tmp1 = str1.toCharArray();
		Integer [] tmp2 = new Integer[str2.length()];
		for(int i=0; i<str2.length(); ++i) {
			tmp2[i] = (int)str2.charAt(i);
		}
		Arrays.sort(tmp1);
		Arrays.sort(tmp2, Collections.reverseOrder());
		for(int i=0; i<(str1.length() + 1) / 2; ++i) {
			dq1.addLast((int)tmp1[i]);
		}
		for(int i=0; i<str2.length() / 2; ++i) {
			dq2.addLast((int)tmp2[i]);
		}
		int size = str1.length();
		for(int i=0; i<size; ++i) {
			if(i %2 == 0) {
				if(dq2.isEmpty() || dq1.peekFirst() < dq2.peekFirst()) {
					int tmp = dq1.pollFirst();
					front += (char)tmp;
				}else {
					int tmp = dq1.pollFirst();
					back += (char)tmp;
				}				
			}else {
				if(dq1.isEmpty() || dq1.peekFirst() < dq2.peekFirst()) {
					int tmp = dq2.pollFirst();
					front += (char)tmp;
				}else {
					int tmp = dq2.pollLast();
					back += (char)tmp;
				}
			}
		}
		System.out.print(front);
		for(int i=0; i<back.length(); ++i) {
			System.out.print(back.charAt(back.length() - (i + 1)));
		}
	}
}
