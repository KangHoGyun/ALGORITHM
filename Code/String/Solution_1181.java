package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Solution_1181 {
	static class Info implements Comparable<Info>{
		String str;

		public Info(String str) {
			super();
			this.str = str;
		}
		@Override
		public int compareTo(Info a) {
			if(str.length() == a.str.length()) {
				return str.compareTo(a.str);
			}else
				return str.length() - a.str.length();
			
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Info> arr = new ArrayList<>();
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; ++i) {
			arr.add(new Info(br.readLine()));
		}
		Collections.sort(arr);
		
		for(int i=1; i<arr.size(); ++i) {
			if(arr.get(i).str.equals(arr.get(i - 1).str)) {
				arr.remove(i);
				i--;
			}
		}
		for(int i=0; i<arr.size(); ++i)
			System.out.println(arr.get(i).str);
	}
}
