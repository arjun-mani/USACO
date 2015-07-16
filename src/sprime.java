/*
 ID: arjun
 LANG: JAVA
 TASK: sprime
 */

import java.util.*;
import java.io.*;

public class sprime {
	
	static int N;
	static List <String> sp;
	
	public static void main(String[] args) throws IOException {
		// Scanner in = new Scanner("4");
		Scanner in = new Scanner(new File("sprime.in"));
		PrintWriter pw = new PrintWriter(new File("sprime.out"));
		N = in.nextInt();
		in.close();
		sp = new ArrayList <String> ();
		
		genSuperPrimes("2");
		genSuperPrimes("3");
		genSuperPrimes("5");
		genSuperPrimes("7");
		
		for(String s : sp) pw.println(s);
		
		pw.close();
	}
	
	public static void genSuperPrimes(String s) {
		if(s.length() >= N) {
			sp.add(s);
			return;
		}
		
		else {
			if(isPrime(s + "1")) genSuperPrimes(s + "1");
			if(isPrime(s + "3")) genSuperPrimes(s + "3");
			if(isPrime(s + "7")) genSuperPrimes(s + "7");
			if(isPrime(s + "9")) genSuperPrimes(s + "9");
		}
	}
	
	public static boolean isPrime(String s) {
		int n = Integer.parseInt(s);
		if(n == 0 || n == 1) return false;
		if(n == 2) return true;
		if(n != 2 && n % 2 == 0) return false;
		for(int i = 3; i <= (int) Math.sqrt(n); i++)
			if(n % i == 0) return false;
		
		return true;
		
	}

}
