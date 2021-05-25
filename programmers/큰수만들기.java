package programmers;

/*
 * 큰 수 만들기
 * https://programmers.co.kr/learn/courses/30/lessons/42883
 */
public class 큰수만들기 {
	public static void main(String[] args) {
		System.out.println(solution("1924", 2));
		System.out.println(solution("1231234", 3));
		System.out.println(solution("4177252841", 4));

	}

	public static String solution(String number, int k) {
		StringBuilder answer = new StringBuilder();
		int len = number.length();
		int idx = 0;

		for (int i = 0; i < len - k; i++) {
			char max = '0';
			for (int j = idx; j <= i + k; j++) {
				if (max < number.charAt(j)) {
					max = number.charAt(j);
					idx = j + 1;
				}
			}
			answer.append(max);
		}
		return answer.toString();
	}
}
