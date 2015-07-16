/*
 ID: arjun
 LANG: JAVA
 TASK: cowtour
 */

import java.util.Arrays;
import java.util.Scanner;
import java.io.*;

public class cowtour {
	
	static int [] x;
	static int [] y;
	static int [][] grid;
	static boolean [] visited;
	static int [] id;
	static int count;
	static int N;
	static double [][] dist;
	
	public static void main(String[] args) throws IOException {
		// Scanner in = new Scanner(new File("/Users/arjunsubramaniam/Desktop/usacodatashow.txt"));
		Scanner in = new Scanner(new File("cowtour.in"));
		PrintWriter pw = new PrintWriter(new File("cowtour.out"));
		N = in.nextInt();
		x = new int[N];
		y = new int[N];
		id = new int[N];
		visited = new boolean[N];
		grid = new int[N][N];
		dist = new double[N][N];
		count = 1;
		for(int i = 0; i < N; i++) {
			x[i] = in.nextInt();
			y[i] = in.nextInt();
		}

		for(int i = 0; i < N; i++) {
			String [] arr = in.next().split("");
			for(int j = 1; j <= N; j++) {
				grid[i][j - 1] = Integer.parseInt(arr[j]);
			}
		}
		
		
		findCC();
		// for(int i : id) System.out.println(i);
		in.close();
		
		for(double [] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(i == j) dist[i][j] = 0;
				else if(grid[i][j] == 1) dist[i][j] = dist(i, j);
			}
		}
		
		// floyd-warshall
		for(int k = 0; k < N; k++) {
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(dist[i][k] + dist[k][j] < dist[i][j]) dist[i][j] = dist[i][k] + dist[k][j];
				}
			}
		}
		
		double [] diameters = new double[count + 1];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(id[i] == id[j]) {
					diameters[id[i]] = Math.max(diameters[id[i]], dist[i][j]);
				}
			}
		}
		/* for(double [] r : dist) {
			for(double c : r) System.out.print((int) c + " ");
		System.out.println();
		} */
		
		double minDiam = Integer.MAX_VALUE;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(id[i] != id[j]) {
					double diam1 = 0;
					double diam2 = 0;
					for(int k = 0; k < N; k++) {
						if(id[k] == id[i]) diam1 = Math.max(diam1, dist[i][k]);
					}
					
					for(int k = 0; k < N; k++) {
						if(id[k] == id[j]) diam2 = Math.max(diam2, dist[j][k]);
					}
					
					double diam = Math.max(diameters[id[i]], Math.max(diameters[id[j]], diam1 + dist(i, j) + diam2));
					minDiam = Math.min(minDiam, diam);
				}
			}
		}
		
		String ans = String.format("%.6f", minDiam);
		while(ans.length() - ans.indexOf(".") < 6) ans += "0";
		pw.println(ans);
		pw.close();
	}
	
	public static void findCC() {
		for(int v = 0; v < N; v++) {
			if(! visited[v]) {
				dfs(v);
				count++;
			}
		}
			
	}
	private static void dfs(int v) {
		visited[v] = true;
		id[v] = count;
		for(int i = 0; i < N; i++) {
			if(i != v && ! visited[i] && grid[v][i] == 1) dfs(i);
		}
	}
	
	public static double dist(int v1, int v2) {
		int xcomp = (x[v1] - x[v2]) * (x[v1] - x[v2]);
		int ycomp = (y[v1] - y[v2]) * (y[v1] - y[v2]);
		return Math.sqrt(xcomp + ycomp);
	}

}

