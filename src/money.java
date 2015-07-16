/*
 ID: arjun
 LANG: JAVA
 TASK: money
 */

import java.util.Scanner;
import java.io.*;

public class money {
	
	static long [] dp;
	static long [] coins;
	
	/*
	 * Here's the dp idea:
	 * 
	 * Build up solutions by individually considering all the coin values
	 * Ex. - Coins: 1, 2, 5
	 * Value: 0 1 2 3 4 5
	 * Coins: 1 0 0 0 0 0
	 * 
	 * This is the initial state - Base Case is dp[0] = 1 because there is only
	 * one way to make a value of 0
	 * 
	 * Now take the coin value of 1:
	 * dp[1] += dp[1 - 1]
	 * dp[2] += dp[2 - 1]
	 * dp[3] += dp[3 - 1] etc...
	 * 
	 * Now take the coin value of 2:
	 * dp[2] += dp[2 - 2]
	 * dp[3] += dp[3 - 2]
	 * dp[4] += dp[4 - 2]
	 * 
	 * This yields the following pseudocode:
	 * 
	 * for i = 0 to coins.size:
	 * 	for(j = coins[i]; j <= target; j++)
	 * 		dp[j] += dp[j - coins[i]]
	 */
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("money.in"));
		PrintWriter pw = new PrintWriter(new File("money.out"));
		int V = in.nextInt();
		coins = new long[V];
		int N = in.nextInt();
		dp = new long[N + 1];
		for(int i = 0; i < V; i++) coins[i] = in.nextLong();
		in.close();
		dp[0] = 1;
		
		for(int i = 0; i < coins.length; i++) {
			for(long j = coins[i]; j <= N; j++)
				dp[(int) j] += dp[(int) (j - coins[i])];
		}

		pw.println(dp[N]);
		pw.close();
	}

}
