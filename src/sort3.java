/*
 ID: arjun
 LANG: JAVA
 TASK: sort3
 */

import java.util.Arrays;
import java.util.Scanner;
import java.io.*;

public class sort3 {
	
	static int [] arr;
	static int N;
	
	public static void main(String[] args) throws IOException {
		// Scanner in = new Scanner("9 2 2 1 3 3 3 2 3 1");
		Scanner in = new Scanner(new File("sort3.in"));
		PrintWriter pw = new PrintWriter(new File("sort3.out"));
		N = in.nextInt();
		arr = new int[N];
		for(int i = 0; i < N; i++) arr[i] = in.nextInt();
		in.close();
		pw.println(cntexch());
		pw.close();
	}
	
	public static int cntexch() {
		int [] sorted = new int[N];
		for(int i = 0; i < sorted.length; i++) sorted[i] = arr[i];
		Arrays.sort(sorted);
		
		int ex12 = 0;
		int ex21 = 0;
		int ex13 = 0;
		int ex31 = 0;
		int ex23 = 0;
		int ex32 = 0;
		
		for(int i = 0; i < N; i++) {
			if(arr[i] == 1 && sorted[i] == 2) ex12++;
			if(arr[i] == 2 && sorted[i] == 1) ex21++;
			if(arr[i] == 1 && sorted[i] == 3) ex13++;
			if(arr[i] == 3 && sorted[i] == 1) ex31++;
			if(arr[i] == 2 && sorted[i] == 3) ex23++;
			if(arr[i] == 3 && sorted[i] == 2) ex32++;
		}
		
		return Math.min(ex12, ex21) + Math.min(ex13, ex31) + Math.min(ex23, ex32) 
				+ 2 * (Math.max(ex12, ex21) - Math.min(ex12, ex21));
	}

}
