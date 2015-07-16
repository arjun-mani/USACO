/*
 ID: arjun
 LANG: JAVA
 TASK: frac1
 */

import java.util.*;
import java.io.*;

public class frac1 {
	
	public static void main(String[] args) throws IOException {
		// Scanner in = new Scanner("5");
		Scanner in = new Scanner(new File("frac1.in"));
		PrintWriter pw = new PrintWriter(new File("frac1.out"));
		int N = in.nextInt();
		in.close();
		TreeMap <Double, String> frac = new TreeMap <Double, String> ();
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= i; j++) {
				frac.put((double) j / i, simplify(j, i));
			}
		}
		
		frac.put((double) 0, "0/1");
		
		for(String s : frac.values()) pw.println(s);
		pw.close();
	}
	
	public static String simplify(int a, int b) { // simplify a / b
		int gcd = GCD(a, b);
		return (a / gcd) + "/" + (b / gcd);
	}
	
	public static int GCD(int a, int b) {
		if(b == 0) return a;
		else return GCD(b, a % b);
	}

}
