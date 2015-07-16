/*
 ID: arjun
 LANG: JAVA
 TASK: inflate
 */

import java.util.Scanner;
import java.io.*;

public class inflate {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("inflate.in"));
        PrintWriter pw = new PrintWriter(new File("inflate.out"));
        int M = in.nextInt(); int N = in.nextInt();
        int [] v = new int[N]; int [] time = new int[N];
        for(int i = 0; i < N; i++) { v[i] = in.nextInt(); time[i] = in.nextInt(); }
        long [] score = new long[M + 1];
        for(int i = 0; i < N; i++) { // iterating through each contest
            for(int j = time[i]; j <= M; j++) { // iterating through all the possible times up to M
                score[j] = Math.max(score[j], v[i] + score[j - time[i]]);
            }
        }
        pw.println(score[M]);
        in.close();
        pw.close();
    }
}
