package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * 단어 수학
 * https://www.acmicpc.net/problem/1339
 */
public class baek1339 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[26]; // 알파벳의 계수 예) AA == 11A

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			int len = s.length();
			// AA를 11로 변환하는 과정
			for (int j = 0; j < len; j++) {
				int index = s.charAt(j) - 65;
				nums[index] += (int) Math.pow(10, len-1-j);
			}
		}
		int max = 9; //가장 큰 수
		Arrays.sort(nums);//오름차순 정렬
		int index = 25;//마지막이 가장 큰수
		int ans = 0;//값
		while (true) {
			if (nums[index] == 0) {
				break;
			}
			ans += nums[index--] * max--;
		}
		System.out.println(ans);
	}
}
