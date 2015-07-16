/*
 ID: arjun
 LANG: JAVA
 TASK: ttwo
 */

import java.util.Scanner;
import java.io.*;

public class ttwo {
	
	static int cowdir;
	static int cowi;
	static int cowj;
	static int fardir;
	static int fari;
	static int farj;
	static char [][] grid;
	static int [] idir = {-1, 0, 1, 0};
	static int [] jdir = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		// Scanner in = new Scanner(new File("/Users/arjunsubramaniam/Desktop/usacodatashow.txt"));
		Scanner in = new Scanner(new File("ttwo.in"));
		PrintWriter pw = new PrintWriter(new File("ttwo.out"));
		grid = new char[10][10];
		for(int i = 0; i < 10; i++) {
			grid[i] = in.nextLine().toCharArray();
		}
		
		in.close();
		/* for(char [] ch : grid) {
			for(char c : ch)
				System.out.print(c + " ");
			System.out.println();
		} */
		
		cowi = 0;
		cowj = 0;
		cowdir = 0; // 0 north, 1 east, 2 south, 3 west
		fari = 0;
		farj = 0;
		fardir = 0; 
		
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				if(grid[i][j] == 'C') {
					cowi = i;
					cowj = j;
				}
				
				else if(grid[i][j] == 'F') {
					fari = i;
					farj = j;
				}
			}
		}
		
		int i = 0;
		for(i = 0; i < 160000; i++) {
			makeMove();
			if(cowi == fari && cowj == farj) {
				pw.println(i + 1);
				break;
			}
		}
		
		if(i == 160000) pw.println(0);
		pw.close();
		
	}
	
	public static void makeMove() {
		// System.out.println(cowi + " " + cowj);
		// making the move for the cows
		int cowmovei = cowi + idir[cowdir];
		int cowmovej = cowj + jdir[cowdir];
		int farmovei = fari + idir[fardir];
		int farmovej = farj + jdir[fardir];
		if(isValid(cowmovei, cowmovej) && grid[cowmovei][cowmovej] != '*') {
			cowi = cowmovei;
			cowj = cowmovej;
		}
		
		else cowdir = cowdir == 3 ? 0 : cowdir + 1;
		
		if(isValid(farmovei, farmovej) && grid[farmovei][farmovej] != '*') {
			fari = farmovei;
			farj = farmovej;
		}
		
		else fardir = fardir == 3 ? 0 : fardir + 1;
		
	}
	
	public static boolean isValid(int i, int j) {
		return i >= 0 && i < 10 && j >= 0 && j < 10;
	}

}
