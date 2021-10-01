package programmers;

/**
 * 괄호 변환
 * https://programmers.co.kr/learn/courses/30/lessons/60058
 */
public class 괄호변환 {
    static int idx;

    public static void main(String[] args) {
        System.out.println(solution("()))((()"));
    }

    public static String solution(String p) {
        if (p.equals("")) {
            return "";
        }

        boolean flag = check(p);
        String u = p.substring(0, idx);
        String v = p.substring(idx);

        if (flag) {
            return u + solution(v);
        }
        StringBuilder answer = new StringBuilder();
        answer.append("(").append(solution(v)).append(")");
        for (int i = 1; i < u.length() - 1; i++) {
            if (u.charAt(i) == '(') {
                answer.append(")");
            } else {
                answer.append("(");
            }
        }

        return answer.toString();
    }

    public static boolean check(String w) {
        boolean res = true;
        int left = 0, right = 0;
        for (int i = 0; i < w.length(); i++) {
            if (w.charAt(i) == '(') {
                left++;
            } else {
                right++;
                if (left < right) {
                    res = false;
                }
            }
            if (left == right) {
                idx = i + 1;
                return res;
            }
        }
        return true;
    }
}