package programmers;

/**
 * JadenCase 문자열 만들기
 * https://school.programmers.co.kr/learn/courses/30/lessons/12951
 */

public class JadenCase문자열만들기 {
    public static void main(String[] args) throws Exception {
        System.out.println(solution("3people unFollowed me"	));
    }
    static public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        boolean flag = true;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                flag = true;
                answer.append(ch);
                continue;
            }
            if (flag) {
                ch = Character.toUpperCase(ch);
                flag = false;
            } else {
                ch = Character.toLowerCase(ch);
            }
            answer.append(ch);
        }

        return answer.toString();
    }
}
