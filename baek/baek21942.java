package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 * 부품 대여장 
 * https://www.acmicpc.net/problem/21942
 */
public class baek21942 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd HH:mm");

		Map<String, Map<String, String>> root = new HashMap<>();
		TreeMap<String, Long> answer = new TreeMap<>();

		int N = Integer.parseInt(st.nextToken());
		String[] temp = st.nextToken().split("/");
		long L = (Integer.parseInt(temp[0]) * 24 + Integer.parseInt(temp[1].split(":")[0])) * 60
				+ Integer.parseInt(temp[1].split(":")[1]);
		int F = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			String[] str = br.readLine().split(" ");
			String day = str[0] + " " + str[1];
			String P = str[2];
			String M = str[3];

			if (root.containsKey(M)) {
				//빌려간 제품이 있으면
				if (root.get(M).containsKey(P)) {
					String dateStart = root.get(M).get(P);
					//두 날짜 분 계산
					Date d1 = null;
					Date d2 = null;
					try {
						d1 = format.parse(dateStart);
						d2 = format.parse(day);
					} catch (Exception e) {
						e.printStackTrace();
					}
					long diff = (d2.getTime() - d1.getTime()) / (60 * 1000);
					//벌금 계산
					if (diff > L) {
						long value = (diff - L) * F;
						if (answer.containsKey(M)) {
							value += answer.get(M);
						}
						answer.put(M, value);
					}
					root.get(M).remove(P);
				} else {
					root.get(M).put(P, day);
				}
			} else {
				root.put(M, new HashMap<>());
				root.get(M).put(P, day);
			}

		}
		if (answer.isEmpty()) {
			System.out.println(-1);
		} else {
			for (String key : answer.keySet()) {
				System.out.println(key + " " + answer.get(key));
			}
		}

	}
}
