/*
 ID: arjun
 LANG: JAVA
 TASK: hamming
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

public class hamming {
	
	static int N;
	static int B;
	static int D;
	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("hamming.in"));
		PrintWriter pw = new PrintWriter(new File("hamming.out"));
		N = in.nextInt();
		B = in.nextInt();
		D = in.nextInt();
		in.close();
		ArrayList <Integer> codes = new ArrayList <Integer> ();
		codes.add(0);
		for(int i = 1; i <= (int) Math.pow(2, B); i++) {
			boolean add = true;
			for(int a: codes) {
				if(hamDist(a, i) < D) {
					add = false;
					break;
				}
			}
			if(add) codes.add(i);
			if(codes.size() >= N) break;
		}
		
		for(int i = 0; i < codes.size(); i++) {
			if(i % 10 == 9 || i == codes.size() - 1) pw.println(codes.get(i));
			else pw.print(codes.get(i) + " ");
		}
		
		pw.close();
	}
	
	public static int hamDist(int a, int b) {
		String one = Integer.toBinaryString(a);
		String two = Integer.toBinaryString(b);
		while(one.length() > two.length()) two = "0" + two;
		while(two.length() > one.length()) one = "0" + one;
		int cnt = 0;
		for(int i = 0; i < one.length(); i++)
			if(one.charAt(i) != two.charAt(i)) cnt++;
		
		return cnt;
	}

}
