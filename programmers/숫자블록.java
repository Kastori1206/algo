package programmers;

import java.util.Arrays;

/**
 * 숫자 블록
 * https://programmers.co.kr/learn/courses/30/lessons/12923?language=java
 */

public class 숫자블록 {
    public static void main(String[] args) {
        long begin = 1;
        long end = 10;
        System.out.println(Arrays.toString(solution(begin, end)));
    }

    public static int[] solution(long begin, long end) {
        int[] answer = new int[(int) (end - begin) + 1];
        Arrays.fill(answer, 1);
        if (begin == 1) {
            answer[0] = 0;
        }
        int idx = 0;

        for (long i = begin; i <= end; i++) {
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    int temp = (int) (i / j);
                    if (temp <= 10000000) {
                        answer[idx] = temp;
                        break;
                    }
                }
            }
            idx++;
        }

        return answer;

    }


}

