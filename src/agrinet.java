/*
 ID: arjun
 LANG: JAVA
 TASK: agrinet
 */

import java.util.Scanner;
import java.util.Arrays;
import java.io.*;

public class agrinet
{
    public static void main(String[] args) throws IOException 
    {
        Scanner in = new Scanner(new File("agrinet.in"));
        PrintWriter pw = new PrintWriter(new File("agrinet.out"));
        int N = in.nextInt();
        int [][] graph = new int[N][N];
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                graph[i][j] = in.nextInt();
            }
        }
        
        boolean [] mstSet = new boolean[N];
        int [] key = new int[N];
        Arrays.fill(key, Integer.MAX_VALUE);
        key[0] = 0;
        
        for(int cnt = 0; cnt < N - 1; cnt++) {
            int min = Integer.MAX_VALUE;
            int minindex = -1;
            for(int v = 0; v < N; v++) {
                if(! mstSet[v] && key[v] < min) {
                    min = key[v];
                    minindex = v;
                }
            }
            
            mstSet[minindex] = true;
            
            for(int v = 0; v < N; v++) {
                if(graph[minindex][v] != 0 && !mstSet[v] && graph[minindex][v] < key[v])
                {
                    key[v] = graph[minindex][v];
                }
            }
        }
        
        int ans = 0;
        for(int i : key) ans += i;
        pw.println(ans);
        
        in.close();
        pw.close();
    }
}
