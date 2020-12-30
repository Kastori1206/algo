package programmers;

/*
 * 주식가격
 * https://programmers.co.kr/learn/courses/30/lessons/42584
 * 스택/큐
 */

public class 주식가격 {

	class Solution {
	    public int[] solution(int[] prices) {
	        int len = prices.length;
	        int[] answer = new int[len];
	        for(int i =0;i<len;i++){
	            for(int j =i+1;j<len;j++){
	                if(prices[i]<=prices[j]){
	                    answer[i]++;
	                }else{
	                    answer[i]++;
	                    break;
	                }
	            }
	        }
	        return answer;
	    }
	}
}
