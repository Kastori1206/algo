package swea.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
/*
 * [S/W 문제해결 응용] 1일차 - 단순 2진 암호코드 
 */

public class swea1240 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		Map<String, Integer> map = new HashMap<>();
		map.put("0001101", 0);
		map.put("0011001", 1);
		map.put("0010011", 2);
		map.put("0111101", 3);
		map.put("0100011", 4);
		map.put("0110001", 5);
		map.put("0101111", 6);
		map.put("0111011", 7);
		map.put("0110111", 8);
		map.put("0001011", 9);

		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			String str = "";
			int end = 0;
			for (int i = 0; i < N; i++) {
				String input = br.readLine();
				for (int j = M-1; j >=0; j--) {
					if (input.charAt(j) == '1') {
						str = input;
						end = j;
						break;
					}
				}
			}
			int start = end - 7 * 8;
			int odd = 0;
			int even = 0;
			int check = 0;
			for (int i = 0; i < 8; i++) {
				int num = map.get(str.substring(7 * i + start + 1, 7 * i + start + 1 + 7));
				if (i == 7) {
					check = num;
				}else if (i % 2 == 0) {
					odd += num;
				} else {
					even += num;
				}
			}
			int answer = 0;
			if (((odd * 3) + even + check) % 10 == 0) {
				answer = odd + even + check;
			}

			sb.append(String.format("#%d %d\n", t + 1, answer));

		}
		System.out.println(sb);
	}
}
