/*
 ID: arjun
 LANG: JAVA
 TASK: milk2
 */

import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class milk2 {
	
	public static void main(String[] args) throws IOException {
		// Scanner in = new Scanner("10 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 1 20");
		Scanner sc = new Scanner(new File("milk2.in"));
		PrintWriter pw = new PrintWriter(new File("milk2.out"));
		int n = sc.nextInt();
		Point [] times = new Point [n];
		
		for(int i = 0; i < n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			times[i] = new Point(x, y);
		}
		
		sc.close();
		
		Arrays.sort(times);
		
		int begin = times[0].x;
		int end = times[0].y;
		int milktime = times[0].y - times[0].x;
		int stopping = 0;
		
		for(int i = 1; i < times.length; i++) {
			if(end >= times[i].x && end <= times[i].y) {
				end = times[i].y;
			}
			
			milktime = Math.max(end - begin, milktime);
			
			if(times[i].x > end) {
				
				milktime = Math.max(end - begin, milktime);
				stopping = Math.max(stopping, times[i].x - end);
				
				begin = times[i].x;
				end = times[i].y;
				
			}
			
			
		}
		
		pw.println(milktime + " " + stopping);
		
		
		pw.close();
		
	}

}

/* class Point implements Comparable <Point> {
	public int x;
	public int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(Point o) {
		Integer a = this.x;
		Integer b = o.x;
		return a.compareTo(b);
	}
	
} */
