package programmers;

import java.util.Arrays;

/**
 * 최고의 집합
 * https://school.programmers.co.kr/learn/courses/30/lessons/12938
 */
public class 최고의집합 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(2, 9)));
        System.out.println(Arrays.toString(solution(2, 1)));
        System.out.println(Arrays.toString(solution(2, 8)));
    }
    static public int[] solution(int n, int s) {
        int[] answer = new int[n];

        int num = s / n;
        int m = s % n;
        if (num == 0) {
            return new int[]{-1};
        }

        for (int i = 0; i < n; i++) {
            answer[i] = num;
        }
        for (int i = n - m; i < n; i++) {
            answer[i]++;
        }
        return answer;
    }
}