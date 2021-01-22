package leetcode;

import java.util.HashSet;
import java.util.Set;

public class JewelsandStones {
	public static void main(String[] args) {
		String jewels = "aA", stones = "aAAbbbb";	
		System.out.println(new Solution().numJewelsInStones(jewels, stones));
	}
	static class Solution{
	    public int numJewelsInStones(String jewels, String stones) {
	    	Set<Character> set = new HashSet<>();
			for (char jewel : jewels.toCharArray()) {
				set.add(jewel); 
			}

			int count = 0;
			for (char stone : stones.toCharArray()) {
				if (set.contains(stone)) {
					count++;
				}
			}
			return count;
	    }
	}
}
