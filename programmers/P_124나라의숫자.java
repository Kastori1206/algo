package programmers;

public class P_124나라의숫자 {
    public static void main(String[] args) {
        for(int i = 1;i<=10;i++){
            System.out.println(solution(i));
        }
    }
    public static String solution(int n) {
        String answer="";
        String[] numbers = {"4","1","2"};
        while (n > 0) {
            answer = numbers[n%3] + answer;
            n = (n-1) /3;
        }
        return answer.toString();
    }
}
