/*
 ID: arjun
 LANG: JAVA
 TASK: maze1
 */

import java.util.*;
import java.io.*;

public class maze1 {
	
	static char [][] grid;
	static int N;
	static int H;
	static int[] x = {1, -1, 0, 0};
	static int[] y = {0, 0, 1, -1};
	
	public static void main(String[] args) throws IOException {
		// Scanner in = new Scanner(new File("/Users/arjunsubramaniam/Desktop/Python/matrix.txt"));
		Scanner in = new Scanner(new File("maze1.in"));
		PrintWriter pw = new PrintWriter(new File("maze1.out"));
		N = in.nextInt();
		H = in.nextInt();
		String throwaway = in.nextLine();
		grid = new char[2 * H + 1][2 * N + 1];
		for(int i = 0; i < 2 * H + 1; i++) {
			String s = in.nextLine();
			while(s.length() < 2 * N + 1) s += " ";
			char [] arr = s.toCharArray();
			grid[i] = arr;
		}
		
		
		in.close();
		/* for(char [] c : grid) {
			for(char ch : c) System.out.print(ch + " ");
			System.out.println();
		} */
		
		int exit1x = -1;
		int exit1y = -1;
		int exit2x = -1;
		int exit2y = -1;
		
		for(int i = 0; i <= 2 * N; i++) {
		    for(int j = 0; j <= 2 * H; j++) {
		        if(grid[j][i] == ' ' && isEdge(j, i)) {
		            if(exit1x == -1) {
		                exit1x = i; 
		                exit1y = j;
		            }
		            else {
		                exit2x = i; 
		                exit2y = j;
		            }
		        }
		    }
		}
		
		int maxdist = 0;
		
		int [][] dist1 = bfs(exit1x, exit1y);
		int [][] dist2 = bfs(exit2x, exit2y);
		
		for(int i = 1; i <= 2 * N; i += 2) {
		    for(int j = 1; j <= 2 * H; j += 2) {
		        maxdist = Math.max(maxdist, Math.min(dist1[j][i], dist2[j][i]));
		    }
		}
		
		pw.println(maxdist / 2 + 1);
		
		pw.close();
	}
	
	public static boolean isEdge(int x, int y) {
	    return x == 0 || x == 2 * H || y == 0 || y == 2 * N;
	}
	
	public static boolean isBounded(int x, int y) {
	    return x >= 0 && x <= 2 * H && y >= 0 && y <= 2 * N;
	}
	
	public static int[][] bfs(int srcx, int srcy) {
	    Queue <Coor> q = new LinkedList <Coor> ();
	    boolean [][] visited = new boolean[2 * H + 1][2 * N + 1];
	    q.add(new Coor(srcx, srcy));
	    visited[srcy][srcx] = true;
	    int [][] dist = new int[2 * H + 1][2 * N + 1];
	    
	    while(! q.isEmpty()) {
	        Coor c = q.remove();
	        for(int i = 0; i < 4; i++) {
	            int xcoor = c.x + x[i];
	            int ycoor = c.y + y[i];
	            if(isBounded(ycoor, xcoor) && grid[ycoor][xcoor] == ' ' && ! visited[ycoor][xcoor]) {
	                visited[ycoor][xcoor] = true;
	                q.add(new Coor(xcoor, ycoor));
	                dist[ycoor][xcoor] = dist[c.y][c.x] + 1;
	            }
	        }
	    }
	    
	    /* for(int [] row : dist) {
	        for(int c : row) System.out.print(c + " ");
	        System.out.println();
	    }
	    
	    System.out.println(); */
	    return dist;
	}
	
}

class Coor {
    
    public int x;
    public int y;
    
    public Coor(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
