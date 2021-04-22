package leetcode;

import java.util.*;

public class GroupAnagrams {
	public static void main(String[] args) {
		System.out.print(groupAnagrams(new String[] {"eat","tea","tan","ate","nat","bat"}));
	
	}

	public static List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> result = new ArrayList<>();
		
		if(strs ==null || strs.length ==0) {
			return result;
		}
		Map<String, List<String>> map = new HashMap<>();
		
		for(String str : strs) {
			char[] cArr = str.toCharArray();
			Arrays.sort(cArr);
			String key = String.valueOf(cArr);
			if(map.containsKey(key)) {
				map.get(key).add(str);
			}else {
				List<String> temp = new ArrayList<String>();
				temp.add(str);
				map.put(key,temp);
			}
		}
		result.addAll(map.values());
		
		return result;
	}
}
