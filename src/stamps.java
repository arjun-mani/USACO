/*
 ID: arjun
 LANG: JAVA
 TASK: stamps
 */

import java.util.Arrays;
import java.util.Scanner;
import java.io.*;

public class stamps
{
    public static void main(String[] args) throws IOException
    {   
        Scanner in = new Scanner(new File("stamps.in"));
        PrintWriter pw = new PrintWriter(new File("stamps.out"));
        int K = in.nextInt(); int N = in.nextInt(); int [] v = new int[N];
        int maxv = -1;
        for(int i = 0; i < N; i++) {
            int val = in.nextInt();
            v[i] = val; maxv = Math.max(maxv, val);
        }
        
        int [] dp = new int[K * maxv + 2];
        Arrays.fill(dp, 1000000000);
        dp[0] = 1;
        
        for(int i = 1; i <= K * maxv + 1; i++) {
            for(int j = 0; j < N; j++) {
                if(v[j] <= i && dp[i - v[j]] > 0) {
                    dp[i] = Math.min(dp[i], dp[i - v[j]] + 1);
                }
            }
            
            if(dp[i] > K + 1) {
                pw.println(i - 1);
                break;
            }
        }
        
        // for(int i : dp) System.out.print(i + " ");
        
        in.close();
        pw.close();
    }
}
