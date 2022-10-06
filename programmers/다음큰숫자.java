package programmers;

/**
 * 다음 큰 숫자
 * https://school.programmers.co.kr/learn/courses/30/lessons/12911
 */
public class 다음큰숫자 {
    public static void main(String[] args) {
        System.out.println(solution(78));
        System.out.println(solution(15));
    }

    static public int solution(int n) {
        int cnt = A(n);

        for(int i = n +1 ;i<=1000000; i++){
            if ( cnt == A(i)){
                return i;
            }
        }
        return -1;
    }

    static int A(int n){
        int cnt = 0;
        while(n !=0){
            cnt = n%2 == 1 ? cnt + 1 : cnt;
            n /= 2;
        }
        return cnt;
    }
}
