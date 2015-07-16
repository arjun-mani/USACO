/*
 ID: arjun
 LANG: JAVA
 TASK: milk
 */

import java.util.*;
import java.io.*;

public class milk {
	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("milk.in"));
		PrintWriter pw = new PrintWriter(new File("milk.out"));
		
		int milk = in.nextInt();
		int farmer = in.nextInt();
		
		Point [] farmers = new Point[farmer];
		
		for(int i = 0; i < farmer; i++) {
			int price = in.nextInt();
			int supply = in.nextInt();
			farmers[i] = new Point(price, supply);
		}
		
		Arrays.sort(farmers);
		
		int gallonsbought = 0;
		int pricesofar = 0;
		
		for(int i = 0; i < farmers.length; i++) {
			
			if(milk - gallonsbought >= farmers[i].y) {
				gallonsbought += farmers[i].y;
				pricesofar += farmers[i].x * farmers[i].y;
			}
			
			else if(milk - gallonsbought < farmers[i].y) {
				pricesofar += (milk - gallonsbought) * farmers[i].x;
				gallonsbought += milk - gallonsbought;
				break;
			}
		}
		
		pw.println(pricesofar);
		
		in.close();
		pw.close();
	}

}

class Point implements Comparable <Point> {
	public int x;
	public int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(Point o) {
		Integer a = this.x;
		Integer b = o.x;
		return a.compareTo(b);
	}
	
}



