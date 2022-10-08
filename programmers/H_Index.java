package programmers;

import java.util.Arrays;

/**
 * H-Index
 * https://school.programmers.co.kr/learn/courses/30/lessons/42747
 */
public class H_Index {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 0, 6, 1, 5}));
    }
    static public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        int n = citations.length;
        for(int i =0;i<n;i++){
            if(citations[i] >=n-i){
                answer = n-i;
                break;
            }

        }
        return answer;
    }
}
