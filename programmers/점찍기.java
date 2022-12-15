package programmers;

/**
 * 점 찍기
 * https://school.programmers.co.kr/learn/courses/30/lessons/140107?language=java
 */
public class 점찍기 {
    public static void main(String[] args) {
        System.out.println(solution(2, 4));
        System.out.println(solution(1, 5));
    }

    public static long solution(int k, int d) {
        long answer = 0;

        for (int i = 0; i <= d; i += k) {
            long x = (long) i * (long) i;
            long dd = (long) d * (long) d;

            int y = (int) (Math.sqrt(dd - x));
            answer += y / k + 1;
        }
        return answer;
    }
}
