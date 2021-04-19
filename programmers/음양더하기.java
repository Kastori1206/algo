package programmers;

/*
 * 음양더하기
 * https://programmers.co.kr/learn/courses/30/lessons/76501
 */
public class 음양더하기 {
	public static void main(String[] args) {
		System.out.println(solution(new int[] {4, 7,12}, new boolean[] {true,false, true}));
	}

	public static int solution(int[] absolutes, boolean[] signs) {
		int answer = 0;
		for (int i = 0; i < absolutes.length; i++) {
			int num = absolutes[i];
			if (signs[i]) {
				answer += num;
			} else {
				answer -= num;
			}
		}
		return answer;
	}

}
