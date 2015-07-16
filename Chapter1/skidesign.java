/*
 ID: arjun
 LANG: JAVA
 TASK: skidesign
 */

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class skidesign {
	
	public static void main(String[] args) throws IOException {
		
		Scanner in = new Scanner(new File("skidesign.in"));
		PrintWriter pw = new PrintWriter(new File("skidesign.out"));
		int n = in.nextInt();
		int [] hills = new int [10000];
		for(int i = 0; i < n; i++) {
			hills[i] = in.nextInt();
		}
		
		in.close();
		int mincost = 1000000000;
		
		for(int i = 0; i <= 83; i++) {
			
			int cost = 0, x;
			
			for(int j = 0; j < n; j++) {
				
				if(hills[j] < i)
					x = i - hills[j];
				
				else if(hills[j] > i + 17)
					x = hills[j] - (i + 17);
				
				else
					x = 0;
				
				cost += x * x;
			}
			
			if(cost < mincost)
				mincost = cost;
			
		}

		pw.println(mincost);
		pw.close();
		
	}

}
