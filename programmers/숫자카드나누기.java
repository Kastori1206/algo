package programmers;

/**
 * 숫자 카드 나누기
 * https://school.programmers.co.kr/learn/courses/30/lessons/135807
 */
public class 숫자카드나누기 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{10, 17}, new int[]{5, 20}));
        System.out.println(solution(new int[]{10, 20}, new int[]{5, 17}));
        System.out.println(solution(new int[]{14, 35, 119}, new int[]{18, 30, 102}));
    }

    public static int solution(int[] arrayA, int[] arrayB) {
        int gcdA = arrayA[0];
        int gcdB = arrayB[0];

        for (int i = 1; i < arrayA.length; i++) {
            gcdA = gcd(arrayA[i], gcdA);
            gcdB = gcd(arrayB[i], gcdB);
        }

        for (int i = 0; i < arrayB.length; i++) {
            if (arrayB[i] % gcdA == 0) {
                gcdA = 0;
                break;
            }
        }

        for (int i = 0; i < arrayA.length; i++) {
            if (arrayA[i] % gcdB == 0) {
                gcdB = 0;
                break;
            }
        }

        return Math.max(gcdA, gcdB);
    }

    public static int gcd(int a, int b) {
        while (true) {
            int r = a % b;
            if (r == 0) {
                return b;
            }

            a = b;
            b = r;
        }
    }
}
