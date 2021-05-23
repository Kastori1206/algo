package programmers;

import java.util.*;

/*
 * 짝지어 제거하기
 * https://programmers.co.kr/learn/courses/30/lessons/12973
 */
public class 짝지어제거하기 {
	public static void main(String[] args) {
		System.out.println(solution("baabaa"));
	}
	public static int solution(String s){
        Stack<Character> stack = new Stack<>();
        
        for(int i =0;i<s.length();i++) {
        	if(!stack.isEmpty() && stack.peek()==s.charAt(i)) {
        		stack.pop();
        	}else {
        		stack.push(s.charAt(i));
        	}
        }
        
        return stack.isEmpty() ? 1:0;
    }
}
