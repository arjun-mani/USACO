/*
 ID: arjun
 LANG: JAVA
 TASK: ariprog
 */

import java.util.*;
import java.io.*;

public class ariprog {
	
	static int N;
	static int M;
	
	public static void main(String[] args) throws IOException {
		// Scanner in = new Scanner("12 50");
		Scanner in = new Scanner(new File("ariprog.in"));
		PrintWriter pw = new PrintWriter(new File("ariprog.out"));
		N = in.nextInt();
		M = in.nextInt();
		ArrayList <Integer> bs = new ArrayList <Integer> ();
		ArrayList <Pair> pairs = new ArrayList <Pair> ();
		bs.addAll(genBiSquares());
		Collections.sort(bs);
		
		int [] arr = new int[125001];
		Arrays.fill(arr, 0);
		for(int i = 0; i < bs.size(); i++) {
			arr[bs.get(i)] = 1;
		}
		
		for(int i = 0; i < bs.size() - N; i++) {
			for(int j = 1; j <= (M * M + M * M - bs.get(i)) / (N - 1); j++) {
				boolean seq = true;
				for(int k = 0; k < N; k++) {
					if(arr[bs.get(i) + j * k] == 0) {
						seq = false;
						break;
					}
				}
				
				if(seq) pairs.add(new Pair(bs.get(i), j));
			}
		}
		Collections.sort(pairs);
		if(pairs.isEmpty()) pw.println("NONE");
		else {
			for(Pair p : pairs)
				pw.println(p.x + " " + p.y);
		}
		
		in.close();
		pw.close();
	}
	
	public static Set<Integer> genBiSquares() {
		Set <Integer> bisquares = new LinkedHashSet <Integer> ();
		for(int i = 0; i <= M; i++) {
			for(int j = 0; j <= M; j++) {
				bisquares.add(i * i + j * j);
			}
		}
		
		return bisquares;
	}

}

class Pair implements Comparable<Pair> {

	public int x;
	public int y;
	
	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int compareTo(Pair o) {
		if(this.y == o.y) return this.x - o.x;
		return this.y - o.y;
	}
	
}
