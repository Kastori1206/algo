package programmers;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 두 큐 합 같게 만들기
 * https://school.programmers.co.kr/learn/courses/30/lessons/118667?language=java
 */
public class 두큐합같게만들기 {
    public static void main(String[] args) {
        int[] a = {1, 2, 1, 2};
        int[] b = {1, 10, 1, 2};
        System.out.println(solution(a, b));
        System.out.println(solution2(a, b));
    }
    static public int solution(int[] queue1, int[] queue2) {
        long sum1 = 0;
        long sum2 = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        int n = queue1.length;
        int m = queue2.length;

        for (int num : queue1) {
            sum1 += num;
            q1.offer(num);
        }
        for (int num : queue2) {
            sum2 += num;
            q2.offer(num);
        }

        long sum = sum1 + sum2;
        if (sum % 2 != 0) {
            return -1;
        }

        long target = sum / 2;
        int a = 0;
        int b = 0;
        int max = n + m;

        while (a <= max && b <= max) {
            if (sum1 == target) {
                return a + b;
            }
            if (sum1 > target) {
                int num = q1.poll();
                sum1 -= num;
                sum2 += num;
                q2.offer(num);
                a++;
            } else {
                int num = q2.poll();
                sum1 += num;
                sum2 -= num;
                q1.offer(num);
                b++;
            }
        }
        return -1;
    }
    static public int solution2(int[] queue1, int[] queue2) {
        int answer = 0;
        long sum1 = 0;
        long sum2 = 0;

        int n = queue1.length;
        int m = queue2.length;

        int[] arr = new int[n + m];
        int idx = 0;
        for (int num : queue1) {
            sum1 += num;
            arr[idx++] = num;
        }
        for (int num : queue2) {
            sum2 += num;
            arr[idx++] = num;
        }

        long sum = sum1 + sum2;
        long max = n + m;
        if (sum % 2 != 0) {
            return -1;
        }

        long target = sum / 2;
        int s = 0;
        int e = n;
        while (s < e && s < max) {
            while (sum1 < target && e < max) {
                sum1 += arr[e++];
                answer++;
            }

            if (sum1 == target) {
                return answer;
            }
            sum1 -= arr[s++];
            answer++;
        }
        return -1;
    }

}
