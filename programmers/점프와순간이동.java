package programmers;

/*
 * 점프와 순간이동
 * https://programmers.co.kr/learn/courses/30/lessons/12980
 */
public class 점프와순간이동 {
	public static void main(String[] args) {
		System.out.println(solution(5));
		System.out.println(solution(6));
		System.out.println(solution(5000));
	}
	public static int solution(int n) {
		int ans = 0;
		while(n>0) {
			if(n%2==0) {
				n/=2;
			}else {
				n--;
				ans++;
			}
		}
		return ans;
	}
}
