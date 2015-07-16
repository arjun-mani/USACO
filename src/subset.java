/*
 ID: arjun
 LANG: JAVA
 TASK: subset
 */

import java.util.Scanner;
import java.io.*;

public class subset {
	
	/*
	 * Say n = 7
	 * S = {1, 2, 3, 4, 5, 6, 7}
	 * Now I have two sets S1 and S2
	 * Should I add the xth element to S1 or S2
	 * x = elements from 1...x, y = sum of s1
	 * define f(x, y) as the number of ways to sum up to y with elements 1...x
	 * obviously f[0][0] = 1 because only one way to sum 0 with 0 elements
	 * The recurrence: f[x][y] = f[x - 1][y] + f[x - 1][y - x]
	 * This is because the ways to sum y with elements 1...x is equal to
	 * the ways to sum y with x - 1 elements + the way to sum y - x with x - 1 elements
	 * The ending sum has to be n(n - 1) / 4, so y <= n(n - 1) / 4 and x <= n
	 */
	
	static long [][] dp;
	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("subset.in"));
		PrintWriter pw = new PrintWriter(new File("subset.out"));
		int N = in.nextInt();
		in.close();
		int sum = (int) (N * N + N) / 2;
		int sumlim = sum / 2;
		dp = new long[40][800]; // n <= 39, n(n + 1) / 2 <= 800
		for(int x = 0; x <= N; x++) dp[x][0] = 1; // There is one way to make a sum of 0 with x elements
		for(int x = 1; x <= N; x++) {
			for(int y = 1; y <= (int) (N * N + N) / 4; y++) {
				dp[x][y] += dp[x - 1][y]; // += number of ways to make sum y with x - 1 elements
				if(x <= y) dp[x][y] += dp[x - 1][y - x]; // += number of ways to make sum y - x with x - 1 elements
			}
		}
		
		if(sum % 2 == 0) pw.println((long) dp[N][sumlim] / 2);
		else pw.println(0);
		pw.close();
	}

}
