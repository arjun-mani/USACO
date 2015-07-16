/*
 ID: arjun
 LANG: JAVA
 TASK: dualpal
 */

import java.util.*;
import java.io.*;

public class dualpal {
	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("dualpal.in"));
		PrintWriter pw = new PrintWriter(new File("dualpal.out"));
		int n = in.nextInt();
		int s = in.nextInt();
		
		ArrayList <Integer> palbases = new ArrayList <Integer> ();
		int begin = s + 1;
		while(palbases.size() < n) {
			int count = 0;
			for(int i = 2; i <= 10; i++) {
				if(isPalindrome(Integer.toString(begin, i))) {
					count++;
				}
			}
			
			if(count >= 2) {
				palbases.add(begin);
			}
			
			begin++;
		}
		
		for(int i : palbases) {
			pw.println(i);
		}
		
		in.close();
		pw.close();
	}
	
	public static boolean isPalindrome(String s) {
		String r = new StringBuilder(s).reverse().toString();
		return s.equals(r);
	}

}
