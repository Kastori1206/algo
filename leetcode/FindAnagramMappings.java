package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindAnagramMappings {
	public static void main(String[] args) {
		int[] A = {12, 28, 46, 32, 50};
		int[] B = {50, 12, 32, 46, 28};
		System.out.println(Arrays.toString(new Solution().anagramMappings(A, B)));
	}
	static class Solution {
	    public int[] anagramMappings(int[] A, int[] B) {
	        Map<Integer, Integer> map = new HashMap<>();
	        
	        for(int i = 0; i < B.length; i++) {
	            map.put(B[i], i);
	        }
	        
	        int[] answer = new int[A.length];
	        for(int j = 0; j < answer.length; j++) {
	        	answer[j] = map.get(A[j]);
	        }
	        return answer;
	    }
	} 
}
