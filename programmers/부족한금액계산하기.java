package programmers;

/**
 * 부족한 금액 계산하기
 * https://programmers.co.kr/learn/courses/30/lessons/82612
 */
public class 부족한금액계산하기 {
    public static void main(String[] args) throws Exception{
        int price = 3;
        int money = 20;
        int count = 4;
        System.out.println(solution(price,money,count));

    }
    public static long solution(int price, int money, int count) {
        /**
         *  1 ~ count까지의 합은 n(n+1)/2
         *  count만큼 이용료를 계산 후
         *  음수가 나오면 부족하지 않음
         *  양수가 나오면 부족함
         */

        return Math.max((long)price * (long)(count*(count+1))/2 - money, 0);
    }
}
