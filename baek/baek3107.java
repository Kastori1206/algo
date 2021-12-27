package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * IPv6
 * https://www.acmicpc.net/problem/3107
 */
public class baek3107 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		List<String> ip = new ArrayList<>();
		int idx = 0;
		for (int i = 0; i < input.length(); i++) {
			String str = "";
			while (i < input.length() && input.charAt(i) != ':') {
				str += input.charAt(i++);
			}
			ip.add(str);
		}
		String[] answer = new String[8];

		StringBuilder sb = new StringBuilder();
		idx = 0;
		boolean flag = true;
		for (int i = 0; i < ip.size(); i++) {
			int len = ip.get(i).length();
			if (len == 4) {
				answer[idx++] = ip.get(i);
			} else if (len > 0) {
				String str = "";
				while (str.length() + len < 4) {
					str += "0";
				}
				answer[idx++] = str + ip.get(i);
			} else {
				if (flag) {
					for (int j = 0; j < 8 - ip.size() + 1; j++) {
						answer[idx++] = "0000";
					}
					flag = false;
				} else {
					answer[idx++] = "0000";
				}
			}
		}

		for (int i = 0; i < answer.length; i++) {
			sb.append(answer[i]);
			if (i != 7) {
				sb.append(":");
			}
		}

		System.out.println(sb.toString());
	}

}
