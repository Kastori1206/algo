package leetcode;

/*
 *  String, StringBuffer, StringBuilder 차이점과 장단점
 *  1. String + 연산이나 concat을 -> 새로운 String 객체를 new로 만듬
 *  2. StringBuffer, 멀티쓰레드환경에서는 synchronized
 *  3. Stringbuilder asynchronized 싱글쓰레드 환경
 */
public class LicenseKeyFormatting {
	public static void main(String[] args) {
//		String S = "5F3Z-2e-9-w";
//		int K = 4;
		String S = "2-5g-3-J";
		int K = 2;
		System.out.println(new Solution().licenseKeyFormatting(S, K));
	}

	static class Solution {
		public String licenseKeyFormatting(String S, int K) {
			String str = S.replaceAll("-", "");
			int len = str.length();
//			int start = len % K;
//			String result = str.substring(0, start);
//
//			for (int i = start; i < str.length(); i++) {
//				if ((i - start) % K == 0 && i != 0) {
//					result += "-";
//				}
//				result += str.charAt(i);
//			}
			StringBuilder sb = new StringBuilder(str);
			
			for(int i =K; i<len; i=i+K) {
				sb.insert(len-i, '-');
			}

			return sb.toString().toUpperCase();
		}
	}
}
