/*
 ID: arjun
 LANG: JAVA
 TASK: nocows
 */


import java.util.Scanner;
import java.io.*;

public class nocows {
	
	/*
	 * F(N, K) is the amount of trees that can be constructed with 
	 * N nodes and height <= k
	 * Base Case is trivial: F(0, i) = 1 for all i <= K because with 0 nodes
	 * there is only one way to make a tree with height <= h
	 * 
	 * Break problem down into subtrees - If number of nodes in left subtree is j, 
	 * number of nodes in right subtree is N - j - 1 (root node)
	 * Therefore, the recurrence if defined as:
	 * 
	 * F(N, K) = sum(F(j, K - 1) * F(N - j - 1, K - 1)) as j goes from 0 to K - 1
	 * The runtime of this algorithm is O(N^2 * K)
	 */
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("nocows.in"));
		PrintWriter pw = new PrintWriter(new File("nocows.out"));
		int N = in.nextInt();
		int K = in.nextInt();
		long [][] dp = new long[201][101];
		in.close();
		for(int k = 1; k <= K; k++) { // looping through all possible heights
			dp[1][k] = 1;
			for(int n = 2; n <= N; n++) { // looping through all nodes
				for(int p = 1; p <= n - 2; p++) { // looping through previous nodes
					dp[n][k] += dp[p][k - 1] * dp[n - p - 1][k - 1];
					dp[n][k] %= 9901;
				}
					
			}
		}
		
		pw.println((dp[N][K] - dp[N][K - 1] + 9901) % 9901);
		pw.close();
		
	}

}
