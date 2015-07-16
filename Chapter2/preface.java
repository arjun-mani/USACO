/*
 ID: arjun
 LANG: JAVA
 TASK: preface
 */


import java.util.TreeMap;
import java.util.Scanner;
import java.io.*;

public class preface {
	
	static TreeMap <Integer, String> dictionary = new TreeMap <Integer, String> ();
	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("preface.in"));
		PrintWriter pw = new PrintWriter(new File("preface.out"));
		int N = in.nextInt();
		in.close();
		dictionary.put(1, "I");
		dictionary.put(5, "V");
		dictionary.put(10, "X");
		dictionary.put(50, "L");
		dictionary.put(100, "C");
		dictionary.put(500, "D");
		dictionary.put(1000, "M");
		dictionary.put(4, "IV");
		dictionary.put(9, "IX");
		dictionary.put(40, "XL");
		dictionary.put(90, "XC");
		dictionary.put(400, "CD");
		dictionary.put(900, "CM");
		// System.out.println(dictionary);
		int icount = 0;
		int vcount = 0;
		int xcount = 0;
		int lcount = 0;
		int ccount = 0;
		int dcount = 0;
		int mcount = 0;
		for(int i = 1; i <= N; i++) {
			String s = genRomanNumeral(i);
			for(int j = 0; j < s.length(); j++) {
				if(s.charAt(j) == 'I') icount++;
				else if(s.charAt(j) == 'V') vcount++;
				else if(s.charAt(j) == 'X') xcount++;
				else if(s.charAt(j) == 'L') lcount++;
				else if(s.charAt(j) == 'C') ccount++;
				else if(s.charAt(j) == 'D') dcount++;
				else if(s.charAt(j) == 'M') mcount++;
			}
		}
		
		if(icount > 0) pw.println("I " + icount);
		if(vcount > 0) pw.println("V " + vcount);
		if(xcount > 0) pw.println("X " + xcount);
		if(lcount > 0) pw.println("L " + lcount);
		if(ccount > 0) pw.println("C " + ccount);
		if(dcount > 0) pw.println("D " + dcount);
		if(mcount > 0) pw.println("M " + mcount);
		pw.close();
	}
	
	public static String genRomanNumeral(int N) {
		String ans = "";
		int [] arr = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
		while(N > 0) {
			for(int i = arr.length - 1; i >= 0; i--) {
				if(N >= arr[i]) {
					N -= arr[i];
					ans += dictionary.get(arr[i]);
					break;
				}
			}
		}
		
		return ans;
	}

}
