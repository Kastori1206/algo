package programmers;

/*
 * 타겟넘버
 * https://programmers.co.kr/learn/courses/30/lessons/43165?language=java
 */
public class 타겟넘버 {
    public static void main(String[] args) {
        int[] numbers = {1,1,1,1,1};
        int target = 3;
        System.out.println(solution(numbers,target));
    }
    static public int solution(int[] numbers, int target) {
        int answer = 0;
        answer += go(numbers[0], 1, numbers, target);
        answer += go(-numbers[0], 1, numbers, target);
        return answer;
    }
    static public int go(int sum,int index, int[] numbers, int target){
        if(index >= numbers.length){
            if(target == sum){
                return 1;
            }
            return 0;
        }
        int answer = 0;

        answer += go(sum+numbers[index], index+1, numbers, target);
        answer += go(sum-numbers[index], index+1, numbers, target);

        return answer;
    }
}
