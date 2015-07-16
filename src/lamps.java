/*
 ID: arjun
 LANG: JAVA
 TASK: lamps
 */

import java.util.*;
import java.io.*;

public class lamps {
	
	static int [] lamps;
	static int N;
	static int cnter;
	static List<Integer> on;
	static List <Integer> off;
	static List <String> transformations;
	
	/*
	 * Since pressing a button more than once is pointless, it doesn't matter if C > 4
	 * 4 buttons, 2^4 = 16 combinations, test all combos and output valid ones
	 * C = min(C, 4)
	 */

	public static void main(String[] args) throws IOException {
		// Scanner in = new Scanner("10 1 -1 7 -1");
		Scanner in = new Scanner(new File("lamps.in"));
		PrintWriter pw = new PrintWriter(new File("lamps.out"));
		N = in.nextInt();
		lamps = new int[N];
		Arrays.fill(lamps, 1);
		cnter = in.nextInt();
		on = new ArrayList <Integer> ();
		int j;
		while((j = in.nextInt()) != -1) on.add(j);
		off = new ArrayList <Integer> ();
		while((j = in.nextInt()) != -1) off.add(j);
		in.close();		
		ArrayList <int []> output = new ArrayList <int []> ();
		transformations = new ArrayList <String> ();
		cnter = Math.min(cnter, 4);
		
		for(int i = 1; i <= 4; i++) {
			transformations.add("" + i);
			for(int k = 1; k <= 4; k++) {
				if(i < k) transformations.add(i + "" + k);
				for(int m = 1; m <= 4; m++) {
					if(i < k && k < m && i < m) transformations.add(i + "" + k + "" + m);
				}
			}
		}
		
		transformations.add("1234");
		Collections.sort(transformations, length);
		
		if(cnter == 0) {
			int [] newState = new int[N];
			Arrays.fill(newState, 1);
			if(isValid(newState)) output.add(newState);
		}
		else if(cnter == 1) {
			for(int i = 0; i <= 3; i++) {
				int [] newState = new int[N];
				Arrays.fill(newState, 1);
				transform(i, newState);
				if(isValid(newState)) output.add(newState);
			}
		}
		
		else if(cnter == 2) {
			for(int i = 0; i <= 9; i++) {
				int [] newState = new int[N];
				Arrays.fill(newState, 1);
				String s = transformations.get(i);
				for(int k = 0; k < s.length(); k++) transform(Character.getNumericValue(s.charAt(k)), newState);
				if(isValid(newState)) output.add(newState);
			}
		}
		
		else if(cnter == 3) {
			for(int i = 0; i <= 13; i++) {
				int [] newState = new int[N];
				Arrays.fill(newState, 1);
				String s = transformations.get(i);
				for(int k = 0; k < s.length(); k++) transform(Character.getNumericValue(s.charAt(k)), newState);
				if(isValid(newState)) output.add(newState);
			}
		}
		
		else {
			for(int i = 0; i <= 14; i++) {
				int [] newState = new int[N];
				Arrays.fill(newState, 1);
				String s = transformations.get(i);
				for(int k = 0; k < s.length(); k++) transform(Character.getNumericValue(s.charAt(k)), newState);
				if(isValid(newState)) output.add(newState);
			}
		}
		
		if(output.isEmpty()) pw.println("IMPOSSIBLE");
		else {
			Collections.sort(output, comp);
			for(int i = 0; i < output.size() - 1; i++) if(Arrays.equals(output.get(i), output.get(i + 1))) output.remove(i);
			for(int [] arr : output) {
				for(int i : arr) pw.print(i);
				pw.println();
			}
		}
		pw.close();
	}
	
	public static boolean isValid(int [] lamps) {
		for(int i = 0; i < on.size(); i++) if(lamps[on.get(i) - 1] == 0) return false;
		for(int i = 0; i < off.size(); i++) if(lamps[off.get(i) - 1] == 1) return false;
		return true;
	}
	
	public static int[] transform(int buttonIndex, int [] newState) { // buttons are indexed from 0 to 3
		switch(buttonIndex) {
			case 0:
				for(int i = 0; i < newState.length; i++) newState[i] = 1 - newState[i];
				break;
		
			case 1: 
				for(int i = 0; i < newState.length; i += 2) newState[i] = 1 - newState[i];
				break;
				
			case 2:
				for(int i = 1; i < newState.length; i += 2) newState[i] = 1 - newState[i];
				break;
				
			default:
				for(int i = 0; i < newState.length; i += 3) newState[i] = 1 - newState[i];
		}
		
		return newState;
		
	}
	
	public static Comparator <String> length = new Comparator <String> () {
		public int compare(String one, String two) {
			return one.length() - two.length();
		}
	};
	
	public static Comparator <int []> comp = new Comparator <int []> () {
		public int compare(int[] o1, int[] o2) {
			int ind = 0;
			while(ind < o1.length - 1 && o1[ind] == o2[ind]) ind++;
			return o1[ind] - o2[ind];
		}
	};

}
