/*
 ID: arjun
 LANG: JAVA
 TASK: calfflac
 */

import java.util.*;
import java.io.*;

public class calfflac {
	
	public static Comparator<String> STRING_LENGTH = new ComparebyLength();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new FileReader(new File("calfflac.in")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("calfflac.out")));
        // Scanner inin = new Scanner("Confucius says: Madam I'm Adam.");
        
       
        StringBuilder sb = new StringBuilder();
        String temp = null;
        while ((temp = in.readLine()) != null) {
                sb.append(temp);
                sb.append("\n");
        }
        String str = sb.toString();
        
        in.close();
		
		char [] characters = str.toCharArray();
		
		ArrayList <Character> charedits = new ArrayList <Character> ();
		
		HashMap <Character, ArrayList <Integer>> missing = new HashMap <Character, ArrayList <Integer>> ();
		
		ArrayList <String> palindromes = new ArrayList <String> ();
		
		//int misscount = 0;
		
		for(int i = 0; i < characters.length; i++) {
			char c = characters[i];
			if(isLetter(c) && missing.get(c) == null) {
				ArrayList <Integer> list = new ArrayList <Integer> ();
				charedits.add(c);
				// int index = Arrays.asList(characters).indexOf(c);
				list.add(i);
				missing.put(c, list);
			}
			
			else if(isLetter(c) && missing.get(c) != null) {
				charedits.add(c);
				missing.get(c).add(i);
			}
			
			// else misscount++;
		}
		
		// System.out.println(missing);
		int longeststart = 0;
		int longestend = 0;
		
		for(int i = 0; i < charedits.size(); i++) {
			int start = i;
			for(int a = i + 1; a < charedits.size(); a++) {
				int end = a;
				if(isPalindrome(charedits, start, end) && end - start > 2) {
					palindromes.add(getStringRepresentation(charedits.subList(start, end + 1)));
					if(end - start > longestend - longeststart) {
						longeststart = start;
						longestend = end;
					}
				}
			}
		}
		Collections.sort(palindromes, STRING_LENGTH);
		
		// System.out.println(palindromes);
		
		String solution = palindromes.get(palindromes.size() - 1);
		
		int solutioncount = 0;
		
		/* 
		 Problem: HashMap gets the misscount of the last character, not necessarily 
		 the one pertaining to the anagram
		*/
		char ch = solution.charAt(0);
		char last = solution.charAt(solution.length() - 1);
		//longeststart += missing.get(ch);
		 //longestend += missing.get(last);
		
		// System.out.println(longeststart + " " + longestend);
		// System.out.println(ch);
		//longeststart += getClosestCharacter(characters, ch, longeststart, missing.get(ch), solution);
		// longestend += getClosestCharacter(characters, last, longestend, missing.get(last), solution);
		
		
		// System.out.println(missing.get(ch));
		longeststart = closestIndex(missing.get(ch), longeststart + remcount(characters, 0, longeststart));
		// System.out.println("last: " + missing.get(last));
		// System.out.println("last:" + remcount(characters, 0, longestend));
		longestend = closestIndex(missing.get(last), longestend + remcount(characters, 0, longestend));
		
		// System.out.println(longeststart + " " + longestend);
		
		
		for(int i = 0; i < solution.length(); i++) {
			if(isLetter(solution.charAt(i))) solutioncount++;
		}
		
		// System.out.println(missing.get(ch) + " " + missing.get(last));
		
		System.out.println(solutioncount);
		System.out.println(str.substring(longeststart, longestend + 1));
		
		
		out.close();
		
	}
	
	public static int remcount(char [] array, int startindex, int endindex) {
		int count = 0;
		
		for (int i = startindex + 1; i < endindex; i++) {
			if(! isLetter(array[i])) count++;
		}
		
		return count;
	}
	
	public static int closestIndex(ArrayList <Integer> indices, int index) {
		int answer = 0;
		Collections.sort(indices);
		for(int i = 0; i < indices.size(); i++) {
			if(indices.get(i) >= index) {
				answer = indices.get(i);
				break;
			}
		}
		
		if(answer == 0) return index;
		
		return answer;
	}
	
	/* public static int getClosestCharacter(char [] chars, char letter, int index, int hashvalue, String solution) {
		
		int closestchar = 0;
		for(int i = index; i < chars.length; i++) {
			if(chars[i] == letter) {
				closestchar = i;
				break;
			}
		}
		
		int remcount = 0;
		
		for(int i = closestchar + solution.length() + 1; i < chars.length; i++) {
			if(chars[i] == letter) remcount++;
		}
		
		System.out.println(hashvalue);
		
		return hashvalue - remcount;
	} */
	
	private static class ComparebyLength implements Comparator<String> {

		@Override
		public int compare(String o1, String o2) {
			if(o1.length() > o2.length()) return 1;
			if(o1.length() < o2.length()) return -1;
			
			return 0;
		}
		
	}
	
	public static boolean isPalindrome(ArrayList <Character> chars, int start, int end) {
		
		for(int i = start; i <= (start + end) / 2; i++) {
			if(Character.toLowerCase(chars.get(i)) != Character.toLowerCase(chars.get(end + start - i)) /* && isLetter(chars.get(i)) && isLetter(chars.get(end + start - i)) */)
				return false;
		}
		
		return true;
	}
	
	public static boolean isLetter(char c) {
		String s = c + "";
		
		if(s.matches("[A-Z]")) return true;
		
		else if(s.matches("[a-z]")) return true;
		
		return false;
	}
	
	
	public static String getStringRepresentation(List<Character> list) { 
		
	    StringBuilder builder = new StringBuilder(list.size());
	    
	    for(Character ch: list) {
	        builder.append(ch);
	    }
	    
	    return builder.toString();
	}
	
	

}
