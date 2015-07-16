/*
 ID: arjun
 LANG: JAVA
 TASK: zerosum
 */

import java.util.*;
import java.io.*;

public class zerosum {
	
	static int N;
	static List <String> ans;
 	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("zerosum.in"));
		PrintWriter pw = new PrintWriter(new File("zerosum.out"));
		N = in.nextInt();
		in.close();
		ans = new ArrayList <String> ();
		dfs("1", 2);
		Collections.sort(ans);
		for(String s : ans) pw.println(s);
		pw.close();
	}
	
	public static int eval(String s) {
		s = s.replaceAll("\\s","");
		String [] arr = s.split("[+-]");
		Queue <Character> operators = new LinkedList <Character> ();
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '+' || s.charAt(i) == '-') operators.add(s.charAt(i));
		}
		
		int eval = Integer.parseInt(arr[0]);
		for(int i = 1; i < arr.length; i++) {
			if(operators.peek() == '+') eval += Integer.parseInt(arr[i]);
			else eval -= Integer.parseInt(arr[i]);
			operators.remove();
		}
		return eval;
	} 
	
	public static void dfs(String s, int num) {
		if(num == N) {
			int eval = eval(s);
			if(eval == N) ans.add(s + "-" + N);
			else if(eval == -N) ans.add(s + "+" + N);
			else if(eval(s + " " + N) == 0) ans.add(s + " " + N);
		}
		
		else {
			dfs(s + "+" + num, num + 1);
			dfs(s + "-" + num, num + 1);
			dfs(s + " " + num, num + 1);
		}
	}

}
