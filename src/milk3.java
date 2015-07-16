/*
 ID: arjun
 LANG: JAVA
 TASK: milk3
 */

import java.util.*;
import java.io.*;

public class milk3 {
	
	static int maxA;
	static int maxB;
	static int maxC;
	static List <Integer> poss;
	static boolean [][][] visited;
	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("milk3.in"));
		PrintWriter pw = new PrintWriter(new File("milk3.out"));
		maxA = in.nextInt();
		maxB = in.nextInt();
		maxC = in.nextInt();
		poss = new ArrayList <Integer> ();
		visited = new boolean[21][21][21];
		in.close();
		dfs(0, 0, maxC);
		Collections.sort(poss);
		for(int i = 0; i < poss.size() - 1; i++) {
			pw.print(poss.get(i) + " ");
		}
		pw.println(poss.get(poss.size() - 1));
		pw.close();
	}
	
	public static void dfs(int a, int b, int c) {
		if(visited[a][b][c]) return;
		
		visited[a][b][c] = true;
		if(a == 0) poss.add(c);
		
		// pour from a to b
		if(b + a > maxB) dfs(a - (maxB - b), maxB, c);
		else dfs(0, b + a, c);
		
		// pour from b to a
		if(a + b > maxA) dfs(maxA, b - (maxA - a), c);
		else dfs(b + a, 0, c);
		
		// pour from b to c
		if(b + c > maxC) dfs(a, b - (maxC - c), maxC);
		else dfs(a, 0, b + c);
		
		// pour from c to b
		if(b + c > maxB) dfs(a, maxB, c - (maxB - b));
		else dfs(a, b + c, 0);
		
		// pour from a to c
		if(a + c > maxC) dfs(a - (maxC - c), b, maxC);
		else dfs(0, b, a + c);
		
		// pour from c to a
		if(a + c > maxA) dfs(maxA, b, c - (maxA - a));
		else dfs(a + c, b, 0);
		
	}
}
