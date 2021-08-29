package programmers;

import java.util.HashMap;
import java.util.Map;

/**
 * 숫자 문자열과 영단어 https://programmers.co.kr/learn/courses/30/lessons/81301
 */
public class 숫자문자열과영단어 {
	public static void main(String[] args) {
		System.out.println(solution("one4seveneight"));
		System.out.println(solution("23four5six7"));
		System.out.println(solution("2three45sixseven"));
		System.out.println(solution("123"));
	}

	public static int solution(String s) {		
        String[] alphabets = {"zero","one","two","three","four","five","six","seven","eight","nine"};
        
        for(int i =0;i<10;i++) {
        	s = s.replaceAll(alphabets[i], i+"");
        }
        
        return Integer.parseInt(s);
		
	}

}
