/*
 ID: arjun
 LANG: JAVA
 TASK: castle
 */

import java.util.*;
import java.io.*;

public class castle {
	
	static int [][] grid; // grid will have dimensions n by m
	static boolean [][] visited;
	static int N;
	static int M;
	static int [] roomsize;
	static int maxRoom; // largest room created by removing one wall
	static int [][] id;
	static int xlarge;
	static int ylarge;
	static char ldir;

	/*
	 * for finding the amount of rooms, we do a basic floodfill for all the modules:
	 * Floodfill terminates when indices out of bounds or it hits a wall
	 */
	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("castle.in"));
		// Scanner in = new Scanner("5 5 3 2 6 3 6 1 8 4 1 4 13 7 13 9 4 3 0 2 6 5 9 8 8 12 13 ");
		PrintWriter pw = new PrintWriter(new File("castle.out"));
		M = in.nextInt();
		N = in.nextInt();
		grid = new int[N][M];
		id = new int[N][M];
		visited = new boolean[N][M];
		roomsize = new int[2501];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				grid[i][j] = in.nextInt();
			}
		}
		
		// for(boolean [] row : visited) printRow(row);
		in.close();
		
		int cnt = 0;
		int maxsize1 = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(! visited[i][j]) {
					visit(i, j, cnt);
					maxsize1 = Math.max(maxsize1, roomsize[cnt]);
					cnt++;
				}
			}
		}
		// for(boolean [] row : visited) printRow(row);
		pw.println(cnt);
		pw.println(maxsize1);
		
		for(int c = 0; c < M; c++) {
			for(int r = N - 1; r >= 0; r--) {
				// check for removing north wall
				if(genWalls(grid[r][c]).contains("N") && r > 0 && id[r][c] != id[r - 1][c]) {
					if(roomsize[id[r][c]] + roomsize[id[r - 1][c]] > maxRoom) {
						maxRoom = roomsize[id[r][c]] + roomsize[id[r - 1][c]];
						xlarge = r + 1;
						ylarge = c + 1;
						ldir = 'N';
						// System.out.println(xlarge + " " + ylarge + " " + ldir);
					}
				}
				
				// check for removing east wall
				if(genWalls(grid[r][c]).contains("E") && c < M - 1 && id[r][c] != id[r][c + 1]) {
					if(roomsize[id[r][c]] + roomsize[id[r][c + 1]] > maxRoom) {
						maxRoom = roomsize[id[r][c]] + roomsize[id[r][c + 1]];
						xlarge = r + 1;
						ylarge = c + 1;
						ldir = 'E';
						// System.out.println(xlarge + " " + ylarge + " " + ldir);
					}
				}
				
			}
		}
		/* for(String [] arr : optWalls) {
			for(String s : arr) System.out.print(s + " ");
			System.out.println();
		} */
		
		pw.println(maxRoom);
		pw.println(xlarge + " " + ylarge + " " + ldir);
		pw.close();
	}
	
	public static boolean valid(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}
	
	/*
	 * recurse until !valid or options all contained in genWalls
	 */
	
	public static void visit(int x, int y, int ind) {
		id[x][y] = ind;
		if(visited[x][y]) return;
		visited[x][y] = true;
		roomsize[ind]++;
		if(valid(x + 1, y) && ! genWalls(grid[x][y]).contains("S")) visit(x + 1, y, ind);
		if(valid(x - 1, y) && ! genWalls(grid[x][y]).contains("N")) visit(x - 1, y, ind);
		if(valid(x, y - 1) && ! genWalls(grid[x][y]).contains("W")) visit(x, y - 1, ind);
		if(valid(x, y + 1) && ! genWalls(grid[x][y]).contains("E")) visit(x, y + 1, ind);
	}
	
	/*
	 * Based on the number at the module, figure out which walls are present
	 */
	public static HashSet<String> genWalls(int N) {
		HashSet <String> walls = new HashSet <String> ();
		if(N >= 8) {
			walls.add("S");
			N -= 8;
		}
		
		if(N >= 4) {
			walls.add("E");
			N -= 4;
		}
		
		if(N >= 2) {
			walls.add("N");
			N -= 2;
		}
		
		if(N >= 1) {
			walls.add("W");
			N--;
		}
		return walls;
	}

}
