/*
 ID: arjun
 LANG: JAVA
 TASK: gift1
 */

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;


public class gift1 {
	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("gift1.in"));
		PrintWriter pw = new PrintWriter(new File("gift1.out"));
		
		int n = in.nextInt();
		ArrayList <String> people = new ArrayList <String> ();
		
		for(int i = 0; i < n; i++) {
			people.add(in.next());
		}
		
		HashMap <String, Integer> initial = new HashMap <String, Integer> ();
		HashMap <String, Integer> received = new HashMap <String, Integer> ();
		
		for(String person: people) {
			received.put(person, 0);
		}
		
		for(int i = 0; i < n; i++) {
			String person = in.next();
			int amount = in.nextInt();
			int recipients = in.nextInt();
			
			initial.put(person, amount);
			
			int giftAmount = 0;
			
			if(recipients > 0) {
				giftAmount = amount / recipients;
				received.put(person, received.get(person) + amount % recipients);
			}
			
			for(int j = 0; j < recipients; j++) {
				String recipient = in.next();
				received.put(recipient, received.get(recipient) + giftAmount);
			}
		}
		
		for(String person : people) {
			pw.println(person + " " + (received.get(person) - initial.get(person)));
		}
		
		pw.close();
		
	}

}
