package kmp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution_1786 {
	static ArrayList<Integer> res = new ArrayList<>();

	public static int[] getPi(String p) {
		int pSize = p.length();
		int[] pi = new int[pSize];
		int j = 0;
		for (int i = 1; i < pSize; ++i) {
			while (j > 0 && p.charAt(i) != p.charAt(j)) {
				j = pi[j - 1];
			}
			if (p.charAt(i) == p.charAt(j)) {
				pi[i] = ++j;
			}
		}
		return pi;
	}

	public static void KMP(String t, String p) {
		int[] pi = getPi(p);
		int j = 0;
		for (int i = 0; i < t.length(); ++i) {
			while (j > 0 && t.charAt(i) != p.charAt(j)) {
				j = pi[j - 1];
			}
			if (t.charAt(i) == p.charAt(j)) {
				if (j == p.length() - 1) {
					res.add(i - p.length() + 2);
					j = pi[j];
				} else {
					j++;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String T = br.readLine();
		String P = br.readLine();
		KMP(T, P);
		System.out.println(res.size());
		for (int i = 0; i < res.size(); ++i) {
			System.out.print(res.get(i) + " ");
		}
	}
}
