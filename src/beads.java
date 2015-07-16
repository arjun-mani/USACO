/*
 ID: arjun
 LANG: JAVA
 TASK: beads
 */

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class beads {
	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("beads.in"));
		PrintWriter pw = new PrintWriter(new File("beads.out"));
		int n = in.nextInt();
		String necklace = in.next();
		
		int maxBeads = 0;
		
		for(int i = 0; i < n; i++) {
			int left = countLeft(necklace, i);
			int right = countRight(necklace, i);
			
			if(left >= necklace.length()) maxBeads = necklace.length();
			else if(right >= necklace.length()) maxBeads = necklace.length();
			
			else {
				int beads = left + right;
				if(beads > maxBeads)
					maxBeads = beads;
			}
		}
		
		pw.println(maxBeads > necklace.length() ? necklace.length() : maxBeads);
		pw.close();
	}
	
	public static int countLeft(String s, int i) {
		int j = i;
		int l = s.length();
		int count = 0;
		char ch = s.charAt(i);
		for( ; j >= 0; j--) {
			if(ch == 'w') {
				ch = s.charAt(j);
				count++;
			}
			
			else if(s.charAt(j) == ch || s.charAt(j) == 'w')
				count++;
			
			else break;
		}
		
		if(j < 0) j = l - 1;
		
		for( ; j > i; j--) {
			if(ch == 'w') {
				ch = s.charAt(j);
				count++;
			}
			else if(s.charAt(j) == ch || s.charAt(j) == 'w')
				count++;
			
			else break;
		}
		
		return count;
		
	}
	
	public static int countRight(String s, int i) {
		int j = i;
		int l = s.length();
		if(i == l - 1) j = 0;
		else j = i + 1;
		int count = 0;
		char ch = s.charAt(j);
		
		for( ; j < l; j++) {
			if(ch == 'w') {
				ch = s.charAt(j);
				count++;
			}
			
			else if(s.charAt(j) == ch || s.charAt(j) == 'w')
				count++;
			
			else break;
		}
		
		if(j == l) j = 0;
		for( ; j < i - 1; j++) {
			if(ch == 'w') {
				ch = s.charAt(j);
				count++;
			}
			
			else if(s.charAt(j) == ch || s.charAt(j) == 'w')
				count++;
			
			else break;
		}
		
		return count;
		
	}
	

}
