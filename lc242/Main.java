package lc242;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String s="a";
        String t="ab";
        System.out.println(isAnagram(s,t));
    }

    public static boolean isAnagram(String s, String t) {
        Map<Character, Integer> sMap=new HashMap<Character, Integer>();
        Map<Character, Integer> tMap=new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (sMap.containsKey(s.charAt(i))){
                sMap.put(s.charAt(i),sMap.get(s.charAt(i))+1);
            }
            else{
                sMap.put(s.charAt(i),1);
            }
        }
        for (int i = 0; i < t.length(); i++) {
            if (tMap.containsKey(t.charAt(i))){
                tMap.put(t.charAt(i),tMap.get(t.charAt(i))+1);
            }
            else{
                tMap.put(t.charAt(i),1);
            }
        }
        if (sMap.size()!=tMap.size()){
            return false;
        }

        for (char k:sMap.keySet()) {
            if (!tMap.containsKey(k)||!tMap.get(k).equals(sMap.get(k))){
                return false;
            }
        }
        return true;
    }
}
