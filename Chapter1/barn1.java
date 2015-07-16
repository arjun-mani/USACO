/*
 ID: arjun
 LANG: JAVA
 TASK: barn1
 */

import java.util.*;
import java.io.*;

public class barn1 {
	
	public static void main(String[] args) throws IOException {
		
		Scanner in = new Scanner(new File("barn1.in"));
		// Scanner sc = new Scanner("50 200 10 18 69 195 38 73 28 6 172 53 99");
		PrintWriter pw = new PrintWriter(new File("barn1.out"));
		
		int m = in.nextInt();
		int s = in.nextInt();
		int c = in.nextInt();
	
		
		int bstalls = 0;
		
		int [] occupied = new int [c];
		
		for(int i = 0; i < c; i++) {
			occupied[i] = in.nextInt();
		}
		
		Arrays.sort(occupied);
		
		// for(int i : occupied) System.out.print(i + " ");
		
		ArrayList <Integer> diffs = new ArrayList <Integer> ();
		
		for(int i = 1; i < c; i++) {
			diffs.add(occupied[i] - occupied[i - 1]);
		}
		
		// System.out.println(diffs);
		
		ArrayList <Integer> largestIndices = new ArrayList <Integer> ();
		
		if(m == 1) {
			bstalls = occupied[occupied.length - 1] - occupied[0] + 1;
			pw.println(bstalls);
			
		}
		
		else {
			
			for(int i = 0; i < m - 1; i++) {
				largestIndices.add(diffs.indexOf(Collections.max(diffs)));
				int index = diffs.indexOf(Collections.max(diffs));
				diffs.set(index, 0);
				
				if(i == c - 2) break;
				
			}
			
			Collections.sort(largestIndices);
			
			// System.out.println(m);
			// System.out.println(largestIndices);
			
			int startindex = 0;
			int endindex = largestIndices.get(0);
			
			for(int i = 0; i < largestIndices.size(); i++) {
				
				endindex = largestIndices.get(i);
				
				bstalls += occupied[endindex] - occupied[startindex] + 1;
			
				// System.out.println("startindex: "  + startindex + " endindex: " + endindex);
				// System.out.println("blocked stalls: " + bstalls);
				
				startindex = endindex + 1;
				// endindex = largestIndices.get(i + 1);
			}
			
			int lastindex = largestIndices.get(largestIndices.size() - 1);
			bstalls += occupied[c - 1] - occupied[lastindex + 1] + 1;
			pw.println(bstalls);
			
		}
		
		pw.close();

		
	}
	
	

}
