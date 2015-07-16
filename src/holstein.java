/*
 ID: arjun
 LANG: JAVA
 TASK: holstein
 */

import java.io.*;
import java.util.*;

public class holstein {
	
	static int [][] scoops;
	static int V;
	static int G;
	static int [] vitamins;
	static List <ArrayList <Integer>> powerSet;

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("holstein.in"));
		// Scanner in = new Scanner("5 10 20 30 40 50 5 10 10 10 10 10 0 10 10 10 10 0 0 10 10 10 0 0 0 10 10 0 0 0 0 10");
		// Scanner in = new Scanner(new File("/Users/arjunsubramaniam/Desktop/usacodatashow.txt"));
		PrintWriter pw = new PrintWriter(new File("holstein.out"));
		V = in.nextInt();
		vitamins = new int[V];
		for(int i = 0; i < V; i++) vitamins[i] = in.nextInt();
		G = in.nextInt();
		scoops = new int[G][V];
		powerSet = new ArrayList <ArrayList <Integer>> ();
		for(int i = 0; i < G; i++) {
			for(int j = 0; j < V; j++) {
				scoops[i][j] = in.nextInt();
			}
		}
		
		in.close();
		genPowerSet(G);
		Collections.sort(powerSet, comp);
		powerSet.remove(0);
		// System.out.println(powerSet);
		for(ArrayList <Integer> list : powerSet) {
			if(validConf(list)) {
				pw.print(list.size());
				for(int i : list) pw.print(" " + i);
				pw.println();
				break;
			}
		}
		
		pw.close();

	}
	
	public static boolean validConf(ArrayList <Integer> subset) {
		// loop through all the scoops in subset and sum the total of their vitamin contributions for each
		int [] result = new int[V];
		for(int i = 0; i < subset.size(); i++) {
			for(int j = 0; j < V; j++)
				result[j] += scoops[subset.get(i) - 1][j];
		}
		
		// for(int i : result) System.out.print(i + " ");
		
		for(int i = 0; i < V; i++)
			if(vitamins[i] > result[i]) return false;
		
		return true;
	}
	
	public static void genPowerSet(int N) {
		// generate binary representations from 1 to 2^N 
		for(int i = 0; i < (int) Math.pow(2, N); i++) {
			ArrayList <Integer> subset = new ArrayList <Integer> ();
			String s = Integer.toBinaryString(i);
			while(s.length() < N) s = "0" + s;
			for(int j = 0; j < s.length(); j++)
				if(s.charAt(j) == '1') subset.add(j + 1);
			
			powerSet.add(subset);
			
		}
	}
	
	public static Comparator<List <Integer>> comp = new Comparator<List<Integer>> () { // 

		@Override
		public int compare(List<Integer> o1, List<Integer> o2) { // size, if equal size, lexicographically
			if(o1.size() == o2.size()) {
				for(int i = 0; i < o1.size(); i++) {
					if(o1.get(i) > o2.get(i)) return 1;
					else if(o2.get(i) > o1.get(i)) return -1;
				}
			}
			return o1.size() - o2.size();
		}
		
	};
}
