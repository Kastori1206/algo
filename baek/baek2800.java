package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/*
 * 괄호제거
 * https://www.acmicpc.net/problem/2800
 */

public class baek2800 {
	static class Pair{
		int left, right;

		public Pair(int left, int right) {
			super();
			this.left = left;
			this.right = right;
		}		
	}
	static List<String> answers;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		List<Pair> pairs = new ArrayList<>();
		Stack<Integer> stack = new Stack<>();
		answers = new ArrayList<>();
		
		//괄호 쌍 구하기
		for(int i =0;i<str.length();i++) {
			if(str.charAt(i)=='(') {
				stack.push(i);
			}else if(str.charAt(i)==')'){
				pairs.add(new Pair(stack.pop(), i));
			}
		}
		
		//부분집합(공집합은 빼고)
		int n = pairs.size();
		int len = 1<<n;
		for(int i =1;i<len;i++) {
			char[] temp = str.toCharArray();
			for(int j =0;j<n;j++) {
				if((i&1<<j) !=0) {
					int left = pairs.get(j).left;
					int right = pairs.get(j).right;
					
					temp[left] = temp[right] = 'x';					
				}
			}
			String answer = "";
			for(char c : temp) {
				if(c!='x') {
					answer+=c;
				}
			}
			answers.add(answer);			
		}
		//정렬
		Collections.sort(answers);
	
		//중복제거
		System.out.println(answers.get(0));
		for(int i=1;i<answers.size();i++) {
			if(!answers.get(i).equals(answers.get(i-1))) {
				System.out.println(answers.get(i));
			}
		}
	}	
}
