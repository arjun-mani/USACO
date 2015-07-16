/*
 ID: arjun
 LANG: JAVA
 TASK: contact
 */

import java.util.*;
import java.io.*;

public class contact
{
    public static void main(String[] args) throws IOException 
    {
        Scanner in = new Scanner(new File("contact.in"));
       //  Scanner in = new Scanner(new File("/Users/arjunsubramaniam/Desktop/Python/usacodatashow.txt"));
        PrintWriter pw = new PrintWriter(new File("contact.out"));
        
        int A = in.nextInt(); int B = in.nextInt(); int N = in.nextInt(); String biStr = "";
        while (in.hasNext()) biStr += in.next();
        biStr.replaceAll("\\s","");
        TreeMap <String, Integer> pattfreq = new TreeMap <String, Integer> (comp);
        for(int i = A; i <= B; i++) {
            for(int j = i; j <= biStr.length(); j++) {
                String curr = biStr.substring(j - i, j);
                if(pattfreq.get(curr) == null) pattfreq.put(curr, 1);
                else pattfreq.put(curr, pattfreq.get(curr) + 1);
            }
        }
        
        int sz = pattfreq.size();
        LinkedHashMap <Integer, ArrayList<String>> maxN = new LinkedHashMap <Integer, ArrayList<String>> ();
        Integer finalN = -1;
        while(maxN.size() <= N && maxN.size() <= sz) {
            String maxOcc = ""; int maxvalue = -1;
            for(String key : pattfreq.keySet()) {
                if(pattfreq.get(key) > maxvalue) 
                { 
                    maxvalue = pattfreq.get(key); maxOcc = key; 
                }
            }
            if(maxN.containsKey(maxvalue)) maxN.get(maxvalue).add(maxOcc);
            
            else {
                
                ArrayList <String> l = new ArrayList <String> ();
                l.add(maxOcc); 
                maxN.put(maxvalue, l); 
            }
            
            if(maxN.size() == N + 1) finalN = maxvalue;
            pattfreq.remove(maxOcc);
        }
        
        maxN.remove(finalN);
        
        for(Integer key : maxN.keySet()) {
            pw.println(key);
            ArrayList <String> s = maxN.get(key);
            for(int i = 0; i < s.size(); i++) {
                pw.print(s.get(i));
                if(i != s.size() - 1) pw.print(" ");
            }
            
            pw.println(); 
        }
        
        pw.close();
    }
    
    public static Comparator<String> comp = new Comparator<String>() {
        public int compare(String o1, String o2)
        {
            if(o1.length() == o2.length()) return o1.compareTo(o2);
            return o1.length() - o2.length(); }
    };
}
