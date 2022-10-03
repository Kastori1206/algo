package programmers;

import java.util.Arrays;

/**
 * 최소값 만들기
 * https://school.programmers.co.kr/learn/courses/30/lessons/12941
 */
public class 최소값만들기 {
    public static void main(String[] args) {
        int[] A = {1, 4, 2};
        int[] B = {3, 4};
        System.out.println(solution(A, B));
    }
    static public int solution(int []A, int []B) {
        int answer = 0;
        int n = A.length;
        Arrays.sort(A);
        Arrays.sort(B);

        for (int i = 0; i < n; i++) {
            int a = A[i];
            int b = B[n - 1 - i];

            answer += a * b;
        }
        return answer;
    }
}
