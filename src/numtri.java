/*
 ID: arjun
 LANG: JAVA
 TASK: numtri
 */

import java.io.*;
public class numtri {
	
	public static void main(String[] args) throws IOException {
		// BufferedReader in = new BufferedReader(new FileReader("/Users/arjunsubramaniam/Desktop/usacodatashow.txt"));
		BufferedReader in = new BufferedReader(new FileReader("numtri.in"));
		PrintWriter pw = new PrintWriter(new File("numtri.out"));
		int N = Integer.parseInt(in.readLine());
		int [][] triangle = new int[N][N];
		for(int i = 0; i < N; i++) {
			String [] arr = in.readLine().split(" ");
			for(int j = 0; j <= i; j++) {
				triangle[i][j] = Integer.parseInt(arr[j]);
			}
		}
		
		in.close();
		
		for(int i = N - 2; i >= 0; i--) {
			for(int j = 0; j <= i; j++) {
				triangle[i][j] += Math.max(triangle[i + 1][j], triangle[i + 1][j + 1]);
			}
		}
		
		pw.println(triangle[0][0]);
		pw.close();
	}

}
