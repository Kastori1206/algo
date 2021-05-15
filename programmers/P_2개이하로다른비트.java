package programmers;

import java.util.Arrays;

/*
 * 2개 이하로 다른 비트
 * https://programmers.co.kr/learn/courses/30/lessons/77885
 */
public class P_2개이하로다른비트 {
    public static void main(String[] args) {
        long[] numbers ={2,7};
        System.out.println(Arrays.toString(solution(numbers)));
    }

    public static long[] solution(long[] numbers) {
        int len = numbers.length;
        long[] answer = new long[len];
        for(int i =0;i<len;i++){
            String binaryString = Long.toBinaryString(numbers[i]);
            long num = 0;
            for(int j =binaryString.length()-1;j>=0;j--){
                if(binaryString.charAt(j)=='0'){
                    break;
                }
                num++;
            }
            if(num==0){
                answer[i] = numbers[i]+1;
            }else{
                answer[i] = numbers[i] + (long)Math.pow(2,num) -(long)Math.pow(2,num-1);
            }
        }
        return answer;
    }
}
