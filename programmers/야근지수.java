package programmers;

import java.util.Arrays;

/**
 * 야근 지수
 * https://school.programmers.co.kr/learn/courses/30/lessons/12927
 */
public class 야근지수 {
    public static void main(String[] args) {
        int[] works = {4,3,3};
        System.out.println(solution(4, works));
        works = new int[]{2, 1, 2};
        System.out.println(solution(1, works));
        works = new int[]{1,1};
        System.out.println(solution(3, works));
    }

    static public long solution(int n, int[] works) {
        long answer = 0;
        int len = works.length;
        Arrays.sort(works);

        while (n > 0) {
            int idx = lowerBound(works);
            for (int i = idx; i < len; i++) {
                if (n - 1 < 0) {
                    break;
                }
                works[i]--;
                n--;
            }
        }
        for (int i = 0; i < len; i++) {
            if (works[i] <= 0) {
                continue;
            }
            answer += Math.pow(works[i], 2);
        }
        return answer;
    }

    static int lowerBound(int[] works) {
        int s = 0;
        int e = works.length - 1;
        int target = works[e];

        while (s < e) {
            int mid = (s + e) / 2;

            if (works[mid] < target) {
                s = mid + 1;
            } else {
                e = mid;
            }

        }
        return e;
    }
}
