/*
 ID: arjun
 LANG: JAVA
 TASK: prefix
 */

import java.util.*;
import java.io.*;

public class prefix {
	
	public static void main(String[] args) throws IOException {
		// Scanner in = new Scanner("A AB BA CA BBC ABABACABAABC");
		Scanner in = new Scanner(new File("prefix.in"));
		PrintWriter pw = new PrintWriter(new File("prefix.out"));
		ArrayList <String> prims = new ArrayList <String> ();
		String st;
		while(! (st = in.next()).equals(".")) prims.add(st);
		StringBuffer tmpS = new StringBuffer();
        while (in.hasNextLine())
        {
            tmpS.append(in.nextLine());
        }
        String s = tmpS.toString();
		in.close();
		boolean [] visited = new boolean[s.length()];
		visited[0] = true;
		
		int maxlength = 0;
		for(int i = 0; i < visited.length; i++) {
			if(visited[i]) {
				for(int j = 0; j < prims.size(); j++) {
					if(i + prims.get(j).length() < s.length() && 
							prims.get(j).equals(s.substring(i, i + prims.get(j).length()))) {
						visited[i + prims.get(j).length()] = true;
						maxlength = Math.max(maxlength, i + prims.get(j).length());
					}
				}
			}
		}
		
		/* for(int i = visited.length - 1; i >= 0; i--) {
			if(visited[i]) {
				if(i == 999) pw.println(i + 1);
				else pw.println(i);
				break;
			}
		} */
		pw.println(maxlength);
		pw.close();
	}

}
