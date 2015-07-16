/*
 ID: arjun
 LANG: JAVA
 TASK: concom
 */

import java.util.*;
import java.io.*;

public class concom {
	
	static long [][] concom;
	static int N;
	static boolean [][] visited;
	
	public static void main(String[] args) throws IOException {
		// Scanner in = new Scanner(new File("/Users/arjunsubramaniam/Downloads/usacodatashow.txt"));
		Scanner in = new Scanner(new File("concom.in"));
		// Scanner in = new Scanner("3 1 2 80 2 3 80 3 1 20");
		PrintWriter pw = new PrintWriter(new File("concom.out"));
		N = in.nextInt();
		concom = new long[101][101];
		visited = new boolean[101][101];
		for(int i = 0; i < N; i++) {
			int comp1 = in.nextInt();
			int comp2 = in.nextInt();
			concom[comp1][comp2] = in.nextInt();
		}
		boolean cont = true;
		
		while(cont) {
			cont = false;
			for(int i = 1; i < 101; i++) { // going through all companies
				for(int j = 1; j < 101; j++) { // does company i control company j?
					if(! visited[i][j] && i != j && concom[i][j] > 50) {
						visited[i][j] = true;
						cont = true;
						for(int k = 1; k < 101; k++) {
							if(i != k && j != k) concom[i][k] += concom[j][k];
						}
					}
				}
			}
		}
		
		// for(int [] row : concom) printRow(row);
		
		for(int i = 1; i < 101; i++) {
			for(int j = 1; j < 101; j++) {
				if(Math.abs(concom[i][j]) > 50 && i != j) pw.println(i + " " + j);
			}
		}
		
		in.close();
		pw.close();
		
	}
	
	public static void printRow(int[] row) {
        for (int i : row) {
            System.out.print(i);
            System.out.print("\t");
        }
        System.out.println();
    }
}
