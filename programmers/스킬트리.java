package programmers;

import java.util.Arrays;

/*
 * 스킬트리
 * https://programmers.co.kr/learn/courses/30/lessons/49993#fnref1
 */
public class 스킬트리 {
	public static void main(String[] args) {
		System.out.println(solution("CBD", new String[] {"BACDE", "CBADF", "AECB", "BDA"}));
	}
	static public int solution(String skill, String[] skill_trees) {
		int answer = 0;
		//스킬순서를 저장하는 배열
		int[] count = new int[26];
		for(int i=0;i<skill.length();i++) {
			count[skill.charAt(i)-65] = i+1;
		}
		for(String str : skill_trees) {
			int max = 1;//현재 찍을수 있는 스킬의 순서
			boolean flag = true;
			for(int i =0;i<str.length();i++) {
				//스킬의 순서를 확인
				int order = count[str.charAt(i)-65];
				//0이면 스킬을 찍을 수 있음
				if(order==0) {
					continue;
				}
				//순서가 현재 찍을수있는 스킬보다 순서가 크거나 작으면 못찍음 
				if(max>order||max<order) {
					flag = false;
					break;
				}
				//찍을수 있으면 현재 찍을 수 있는 스킬의 순서를 증가
				else if(order == max){
					max++;					
				}
			}
			if(flag) {
				answer++;
			}
		}
		return answer;
	}
}
