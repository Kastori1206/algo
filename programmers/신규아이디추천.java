package programmers;

/**
 * 신규아이디 추천
 * https://programmers.co.kr/learn/courses/30/lessons/72410
 */
public class 신규아이디추천 {
    public static void main(String[] args) {
        String[] temp = {"...!@BaT#*..y.abcdefghijklm", "z-+.^.", "=.=", "123_.def", "abcdefghijklmn.p"};
        for (String s : temp) {
            System.out.println(solution(s));
        }
    }

    public static String solution(String new_id) {
        //1,2,3,4단계
        String answer = new_id.toLowerCase().replaceAll("[^a-zA-Z0-9\\.\\_-]", "")
                .replaceAll("[\\.]{1,}", ".")
                .replaceAll("^[\\.]", "");
        //5단계
        if (answer.length() == 0) {
            answer = "a";
        }
        //6단계
        if (answer.length() >= 16) {
            answer = answer.substring(0, 15);
        }
        answer = answer.replaceAll("[\\.]$", "");

        //7단계
        if (answer.length() <= 2) {
            char c = answer.charAt(answer.length() - 1);
            while (answer.length() < 3) {
                answer += c;
            }
        }
        return answer;
    }
}
