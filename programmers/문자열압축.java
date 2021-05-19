package programmers;

public class 문자열압축 {
	public static void main(String[] args) {
		String[] input = {
				"aabbaccc",
				"ababcdcdababcdcd",
				"abcabcdede",
				"abcabcabcabcdededededede",
				"xababcdcdababcdcd"
		};
		for(int i =0;i<input.length;i++) {
			System.out.println(solution(input[i]));
		}
	}

	public static int solution(String s) {
		int answer = s.length();
		
		for(int i=1;i<=s.length()/2;i++) {
			String result = "", temp;
			int cnt =1;
			temp = s.substring(0,i);
			for(int j =1;j<=s.length()/i;j++) {
				int start = j*i;
				int end = i * (j + 1) > s.length() ? s.length() : i * (j + 1);
			
				if(temp.equals(s.substring(start,end))) {
					cnt++;
				}else {
					if(cnt>1) {
						result += cnt+"";
					}
					result+=temp;
					temp= s.substring(start,end);
					cnt = 1 ;
				}
			}
			if(cnt>1) {
				result+=cnt+"";				
			}
			result+=temp;
			answer = Math.min(answer, result.length());
		}
		return answer;
	}
}
