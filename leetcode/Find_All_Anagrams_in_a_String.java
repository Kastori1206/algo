package leetcode;

import java.util.*;

/*
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/submissions/
 */
public class Find_All_Anagrams_in_a_String {
	public static void main(String[] args) {
		String s = "cbaebabacd";
		String p = "abc";
		System.out.println(new Solution().findAnagrams(s, p));
	}

	static class Solution {
		public List<Integer> findAnagrams(String s, String p) {
			int slen = s.length();
			int plen = p.length();
			int[] sArr = new int[26];
			int[] pArr = new int[26];

			List<Integer> result = new ArrayList<Integer>();

			if (slen <= 0 || plen <= 0) {
				return result;
			}

			for (int i = 0; i < plen; i++) {
				char c = p.charAt(i);
				pArr[(int) (c - 'a')]++;
			}

			for (int i = 0; i < slen; i++) {
				char c = s.charAt(i);
				sArr[(int) (c - 'a')]++;
				if (i >= plen) {
					char c2 = s.charAt(i - plen);
					sArr[(int) (c2 - 'a')]--;
				}

				if (Arrays.equals(pArr, sArr)) {
					result.add(i - plen + 1);
				}
			}
			return result;
		}
	}
}
