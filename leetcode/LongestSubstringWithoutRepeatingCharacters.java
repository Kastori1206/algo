package leetcode;

import java.util.*;

/**
 * Longest Substring Without Repeating Characters
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String[] s = {"abcabcbb", "bbbbb", "pwwkew", "abba"};
        for (String s1 : s) {
            System.out.println(lengthOfLongestSubstring(s1));
        }
    }
    public static int lengthOfLongestSubstring(String s) {
        int answer = 0;
        Map<Character, Integer> map = new HashMap<>();

        int n = s.length();
        int start = 0;
        int[] dist = new int[n+1];

        for(int i =1;i<=n;i++){
            char c = s.charAt(i-1);
            if(map.containsKey(c)){
                if(map.get(c) < start){
                    dist[i] = dist[i-1] + 1;
                }else{
                    start = map.get(c);
                    dist[i] = i - map.get(c);
                    answer = Math.max(answer, dist[i-1]);
                }
            }else{
                dist[i] = dist[i-1] + 1;
            }
            map.put(c, i);
        }
        // System.out.println(Arrays.toString(dist));
        return answer = Math.max(answer, dist[n]);
    }
}
