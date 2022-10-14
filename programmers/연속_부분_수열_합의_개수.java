package programmers;

import java.util.HashSet;
import java.util.Set;

/**
 * 연속 부분 수열 합의 개수
 * https://school.programmers.co.kr/learn/courses/30/lessons/131701
 */
public class 연속_부분_수열_합의_개수 {
    public static void main(String[] args) {
        int[] elements = {7, 9, 1, 1, 4};
        System.out.println(solution(elements));
    }

    static public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        int n = elements.length;
        int[] d = new int[n * 2];
        d[0] = elements[0];
        for (int i = 1; i < n * 2; i++) {
            d[i] = d[i - 1] + elements[i % n];
        }

        for (int i = 0; i < n * 2; i++) {
            for (int j = i % n; j < i; j++) {
                set.add(d[i] - d[j]);
            }
        }
        return set.size();
    }
}
