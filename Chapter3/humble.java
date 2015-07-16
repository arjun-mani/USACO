/*
 ID: arjun
 LANG: JAVA
 TASK: humble
 */

import java.util.*;
import java.io.*;

public class humble {
    
    public static void main(String[] args) throws IOException {
        // Scanner in = new Scanner("4 19 2 3 5 7");
        Scanner in = new Scanner(new File("humble.in"));
        PrintWriter pw = new PrintWriter(new File("humble.out"));
        int K = in.nextInt(); int N = in.nextInt();
        
        int [] primes = new int[K];
        for(int i = 0; i < K; i++) primes[i] = in.nextInt();
        
        in.close();
        
        long [] humble = new long[N + 1];
        int [] nxt = new int[K];
        humble[0] = 1;
        
        // algorithm: for all primes j, find out j * what humble number is >= the last humble number and record it
        
        for(int i = 1; i <= N; i++) {
           
            long best = Integer.MAX_VALUE;
            
            for(int j = 0; j < K; j++) {
                
                while(primes[j] * humble[nxt[j]] <= humble[i - 1]) {
                    nxt[j]++;
                }
                
                best = Math.min(best, primes[j] * humble[nxt[j]]);
            }
            
            humble[i] = best;
        }
        
        pw.println(humble[N]);
        pw.close();
    }
}
