package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class baek3107 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] ip = br.readLine().split(":");
		StringBuilder sb = new StringBuilder();
		
		// 1번 조건
		for (int i = 0; i < ip.length; i++) {
			String str = ip[i];

			if (!str.equals("")) {
				while (str.length() < 4) {
					str = '0' + str;
				}
				sb.append(str);
			}

			if (i != ip.length - 1)
				sb.append(":");
		}

		
	}

}
