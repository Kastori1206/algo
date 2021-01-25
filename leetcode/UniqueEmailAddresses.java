package leetcode;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses {
	public static void main(String[] args) {
		String[] emails = {"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"};
		System.out.println(new Solution().numUniqueEmails(emails));
	}
	static class Solution {
		public int numUniqueEmails(String[] emails) {
			Set<String> set = new HashSet<>();
			for(int i =0;i<emails.length;i++) {
				String[] temp = emails[i].split("@");
				String local="";
				for(int j=0;j<temp[0].length();j++) {
					char ch = temp[0].charAt(j);
					if(ch=='.') {
						continue;
					}else if(ch=='+') {
						break;
					}
					local += ch;
				}
				set.add(local+"@"+temp[1]);
			}
			
			return set.size();
		}
	}
}