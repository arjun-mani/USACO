/*
 ID: arjun
 LANG: JAVA
 TASK: palsquare
 */

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class palsquare {
	
	public static void main(String[] args) throws IOException {
		
		// Scanner in = new Scanner("15");
		
	    Scanner in = new Scanner(new File("palsquare.in"));
		PrintWriter pw = new PrintWriter(new File("palsquare.out"));
		int n = in.nextInt();
		
		for(int i = 1; i <= 300; i++) {
			String number = Integer.toString(i * i, n);
			if(isPalindrome(number)) {
				pw.println(Integer.toString(i, n).toUpperCase() + " " + number.toUpperCase());
			}
		}
		
		in.close();
		pw.close();
		
	}
	
	public static boolean isPalindrome(String s) {
		String r = new StringBuilder(s).reverse().toString();
		return s.equals(r);
	}

}
