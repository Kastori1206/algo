package programmers;

/*
 * 숫자의 표현
 * https://programmers.co.kr/learn/courses/30/lessons/12924?language=java
 */
public class 숫자의표현 {
    public static void main(String[] args) {
        System.out.println(solution(15));
    }
    static public int solution(int n) {
        int answer = 0;
        int l=1, r=1;
        int sum = 1;
        while(l<=n && r<=n){
            if(sum<n){
                r++;
                sum+=r;
            }else if(sum == n){
                answer++;
                sum-=l;
                l++;
            }else{
                sum-=l;
                l++;
            }
        }
        return answer;
    }
}
