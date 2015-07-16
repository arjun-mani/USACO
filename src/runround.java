/*
 ID: arjun
 LANG: JAVA
 TASK: runround
 */

import java.util.HashSet;
import java.util.Scanner;
import java.io.*;

public class runround {
	
	public static void main(String[] args) throws IOException {
		// Scanner in = new Scanner("99");
		Scanner in = new Scanner(new File("runround.in"));
		PrintWriter pw = new PrintWriter(new File("runround.out"));
		int N = in.nextInt();
		in.close();
		int i;
		for(i = N + 1; ! isRunRound(Integer.toString(i)); i++);
		pw.println(i);
		pw.close();
	}
	
	// for each digit, check whether the digit at (digit % num.length + digitPos) % num.length does not equal digit
	public static boolean isRunRound(String num) {
		HashSet <Integer> covered = new HashSet <Integer> ();
		int cnt = 0;
		int digitPos = 0;
		while(cnt < num.length()) {
			int digit = Character.getNumericValue(num.charAt(digitPos));
			int newPos = (digit % num.length() + digitPos) % num.length();
			if(covered.contains(Character.getNumericValue(num.charAt(newPos)))) return false;
			digitPos = newPos;
			cnt++;
			covered.add(Character.getNumericValue(num.charAt(newPos)));
		}
		return true;
	}

}
