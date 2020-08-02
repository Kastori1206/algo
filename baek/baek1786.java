package baek;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * 1786. 찾기
 * https://www.acmicpc.net/problem/1786
 */
public class baek1786 {
	static int[] getPi(String pattern) {
		int[] pi = new int[pattern.length()];
		int j = 0;
		for (int i = 1; i < pattern.length(); i++) {
			while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
				j = pi[j - 1];
			}
			if (pattern.charAt(i) == pattern.charAt(j)) {
				pi[i] = ++j;
			}			
		}
		return pi;
	}
	static void KMP(String origin, String pattern) {
		int[] pi = getPi(pattern);
		int j =0;
		for(int i =0;i<origin.length();i++) {
			while(j>0 && origin.charAt(i) != pattern.charAt(j)) {
				j = pi[j-1];
			}
			if(origin.charAt(i)== pattern.charAt(j)) {
				if(j==pattern.length()-1) {
					result.add(i-pattern.length()+1+1);//String의 첫글자를 1로계산해야되기때문에 +1
					j=pi[j];					
				}
				//맞았지만 패턴이 끝나지 않았다면 j를 하나증가
				else
					j++;
			}			
		}
	}
	static ArrayList<Integer> result;
	static int cnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String T = sc.nextLine();
		String P = sc.nextLine();
		cnt =0;
		result = new ArrayList<>();
		KMP(T,P);
		StringBuilder sb = new StringBuilder();
		int size = result.size();
		sb.append(size + "\n");
		for(int i=0;i<size;i++) {
			sb.append(result.get(i) + " ");
		}
		System.out.println(sb.toString());	
	}
}
