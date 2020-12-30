package programmers;

import java.util.*;

/*
 * 입국심사
 * https://programmers.co.kr/learn/courses/30/lessons/43238
 * 이분탐색
 */
public class 입국심사 {
	class Solution {
	    public long solution(int n, int[] times) {
	        Arrays.sort(times);
	        
	        long left =1, right = (long)times[times.length-1] * n;
	        long answer = right;   

	        while(left <= right){
	            long people =0;
	            long mid = (left+right)/2;
	            
	            for (int time : times) {
	                people += (mid / time);
	            }
	            
	            if(people<n){
	                left = mid + 1;
	            }else{
	                right = mid-1;
	                answer = mid;

	            }
	        
	        }
	        return answer;
	    }
	}
}
