/*
 ID: arjun
 LANG: JAVA
 TASK: comehome
 */

import java.util.Arrays;
import java.util.Scanner;
import java.io.*;

public class comehome {
	
	static int graph[][];
	
	public static void main(String[] args) throws IOException {
		// Scanner in = new Scanner(new File("/Users/arjunsubramaniam/Downloads/usacodatashow.txt"));
		// Scanner in = new Scanner("5 A d 6 B d 3 C e 9 d Z 8 e Z 3");
		Scanner in = new Scanner(new File("comehome.in"));
		PrintWriter pw = new PrintWriter(new File("comehome.out"));
		int N = in.nextInt();
		graph = new int[100][100];
		for(int [] row : graph) Arrays.fill(row, 1000000);
		int [][] dist = new int[100][100];
		// System.out.println('Z' + 0 - 64);
		for(int i = 0; i < N; i++) {
			String s1 = in.next();
			String s2 = in.next();
			int j = (int) s1.charAt(0) - 64;
			int k = (int) s2.charAt(0) - 64;
			int edge = in.nextInt();
			graph[j][k] = Math.min(graph[j][k], edge);
			graph[k][j] = Math.min(graph[k][j], edge);
			
		}

		in.close();
		for(int [] row : dist) Arrays.fill(row, 1000000);
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				if(i == j || graph[i][j] != 0) dist[i][j] = graph[i][j];
			}
		}
		
		for(int k = 1; k <= 58; k++) {
			for(int i = 1; i <= 58; i++) {
				for(int j = 1; j <= 58; j++) {
					if(dist[i][j] > dist[i][k] + dist[k][j]) dist[i][j] = dist[i][k] + dist[k][j];
				}
			}
		}
		
		int mindist = Integer.MAX_VALUE;
		int ind = -1;
		for(int i = 1; i < 26; i++) {
			if(dist[26][i] > 0 && mindist > dist[26][i]) {
				mindist = Math.min(mindist, dist[26][i]);
				ind = i;
			}
		}
		
		pw.print(Character.toChars(ind + 64));
		pw.println(" " + mindist);
		pw.close();
	}

}
