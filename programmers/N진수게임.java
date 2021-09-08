package programmers;

/**
 * n진수 게임
 * https://programmers.co.kr/learn/courses/30/lessons/17687
 */
public class N진수게임 {
    public static void main(String[] args) {
        int n = 2, t = 4, m = 2, p = 1;
        System.out.println(solution(n, t, m, p));
    }

    public static String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        while(sb.length() <= m*t){
            sb.append(Integer.toString(idx++,n));
        }
        for (int i = 0; i < t; i++) {
            answer.append(sb.charAt(p - 1 + i * m));
        }

        return answer.toString().toUpperCase();
    }
}
