/*
 ID: arjun
 LANG: JAVA
 TASK: combo
 */

import java.util.*;
import java.io.*;

public class combo {
	
	public static void main(String[] args) throws IOException {
		
		// Scanner in = new Scanner(new File("combo.in"));
		Scanner in = new Scanner(new File("combo.in"));
		PrintWriter pw = new PrintWriter(new File("combo.out"));
		int N = in.nextInt();
		int a = in.nextInt();
		int b = in.nextInt();
		int c = in.nextInt();
		int i = in.nextInt();
		int j = in.nextInt();
		int k = in.nextInt();
		
		int count = 0;
		
		ArrayList <Integer> combos = new ArrayList <Integer> ();
		ArrayList <Integer> newcombos = new ArrayList <Integer> ();
		
		count += enumerate(newcombos, combos, N, a, b, c, i, j, k);
		
		pw.println(count);
		
		in.close();
		pw.close();
	}
	
	public static int enumerate(ArrayList <Integer> newcombos, ArrayList <Integer> combos, int N, int a, int b, int c, int i, int j, int k) {
		int count = 0;
		count += enumerate(N, a, b, c, combos);
		count += enumerate(N, i, j, k, newcombos);
		
		for(int p = 0; p < combos.size() - 2; p += 3) {
			for(int q = 0; q < newcombos.size() - 2; q += 3) {
				if(combos.get(p) == newcombos.get(q) && combos.get(p + 1) == newcombos.get(q + 1) && combos.get(p + 2) == newcombos.get(q + 2)) {
					count--;
				}
			}
		}
		
		return count;
	}
	
	public static int enumerate(int N, int a, int b, int c, ArrayList <Integer> combos) {
		
		int count = 0;
		
		// 1 - N is the range of numbers on each dial
		// a - b - c is the actual combination
		// enumerate returns the number of valid combinations for a - b - c
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				for(int k = 1; k <= N; k++) {
					if(isValid(a, b, c, i, j, k, N)) {
						count++;
						combos.add(i);
						combos.add(j);
						combos.add(k);
						// System.out.println(i + " " + j + " " + k);
					}
				}
			}
		}
		
		return count;
		
		
	}
	
	public static boolean isValid(int a, int b, int c, int x, int y, int z, int N) {
		// a - b - c is the valid combination
		// x - y - z is the combination that needs to be tested
		
		// testing for a
		
		if(a == 1) {
			if(x > 3 && x < N - 1) return false;
		}
		
		else if(a == 2) {
			if(x > 4 && x < N) return false;
		}
		
		else if(a == N) {
			if(x > 2 && x < N - 2) return false;
		}
		
		else if(a == N - 1) {
			if(x > 1 && x < N - 3) return false;
		}
		
		else {
			int first = a - 2;
			int second = a + 2;
			if(x < first || x > second) return false;
		}
		
		// testing for b
		
		if(b == 1) {
			if(y > 3 && y < N - 1) return false;
		}
		
		else if(b == 2) {
			if(y > 4 && y < N) return false;
		}
		
		else if(b == N) {
			if(y > 2 && y < N - 2) return false;
		}
		
		else if(b == N - 1) {
			if(y > 1 && y < N - 3) return false;
		}
		
		else {
			int first = b - 2;
			int second = b + 2;
			if(y < first || y > second) return false;
		}
		
		// testing for c
		
		if(c == 1) {
			if(z > 3 && z < N - 1) return false;
		}
		
		else if(c == 2) {
			if(z > 4 && z < N) return false;
		}
		
		else if(c == N) {
			if(z > 2 && z < N - 2) return false;
		}
		
		else if(c == N - 1) {
			if(z > 1 && z < N - 3) return false;
		}
		
		else {
			int first = c - 2;
			int second = c + 2;
			if(z < first || z > second) return false;
		}
		
		return true;
	}
	
	

}
