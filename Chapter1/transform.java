/*
 ID: arjun
 LANG: JAVA
 TASK: transform
 */

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class transform {
	
	public static void main(String[] args) throws IOException {
		/*
		 @_@
		 ---
		 @@-
		 
		 @-@
		 @--
		 --@
		 
		 */
		
		// Scanner in = new Scanner("5 -@@@- -@@-- -@--- ----- ----- ----- ----@ ---@@ --@@@ -----");
		Scanner in = new Scanner(new File("transform.in"));
	    PrintWriter pw = new PrintWriter(new File("transform.out"));
		int n = in.nextInt();
		char [][] original = new char [n][n];
		char [][] transformed = new char [n][n];
		
		for(int row = 0; row < n; row++) {
			original[row] = in.next().toCharArray();
		}
		
		for(int row = 0; row < n; row++) {
			transformed[row] = in.next().toCharArray();
		}
		
		
		if(isEqual(rotate(original), transformed)) pw.println(1);
		
		else if(isEqual(rotate(rotate(original)), transformed)) pw.println(2);
		
		else if(isEqual(rotate(rotate(rotate(original))), transformed)) pw.println(3);
		
		else if(isEqual(reflect(original), transformed)) pw.println(4);
		
		else if(isEqual(rotate(reflect(original)), transformed)) pw.println(5);
		
		else if(isEqual(rotate(rotate(reflect(original))), transformed)) pw.println(5);
		
		else if(isEqual(rotate(rotate(rotate(reflect(original)))), transformed)) pw.println(5);
		
		else if(isEqual(original, transformed)) pw.println(6);
		
		else pw.println(7);
		
		in.close();
	    pw.close();
	    
	    /*for(char [] row : original)
	    	printRow(row);
	    
	    for(char [] row : transformed)
	    	printRow(row);
	    */
	}
	
	public static void printRow(char [] row) {
        for (char i : row) {
            System.out.print(i);
            System.out.print("\t");
        }
        System.out.println();
    }
	
	public static char[][] reflect(char [][] one) {
		int length = one.length;
		char [][] two = new char[length][length];
		
		for(int i = 0; i < length; i++) {
			for(int j = 0; j < length; j++) {
				two[i][j] = one[i][length - j - 1];
			}
		}
		
		return two;
	}
	
	public static char[][] rotate(char [][] one) {
		int length = one.length;
		char[][] two = new char[one.length][one.length];
		for(int i = 0; i < length; i++) {
			for(int j = 0; j < length; j++) {
				two[j][length - i - 1] = one[i][j];
			}
		}
		
		return two;
	}
	
	
	
	/*public static boolean is180(char [][] one, char [][] two) {
		for(int i = 0; i < one.length; i++) {
			if(! isEqual(one[i], two[one.length - i - 1]))
				return false;
		}
		
		return true;
	}*/
	
	public static boolean isEqual(char [] one, char [] two) {
		for(int i = 0; i < one.length; i++) {
			if(one[i] != two[i])
				return false;
		}
		
		return true;
	}
	
	public static boolean isEqual(char [][] one, char [][] two) {
		for(int i = 0; i < one.length; i++) {
			if(! isEqual(one[i], two[i]))
				return false;
		}
		
		return true;
	}

}
