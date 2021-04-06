package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 순위검색
 * https://programmers.co.kr/learn/courses/30/lessons/72412
 */
public class 순위검색 {
	public static void main(String[] args) {
		String[] info = { "java backend junior pizza 150", "python frontend senior chicken 210",
				"python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80",
				"python backend senior chicken 50" };
		String[] query = { "java and backend and junior and pizza 100",
				"python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250",
				"- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150" };
		System.out.println(Arrays.toString(solution(info, query)));
//		solution(info, query);
	}

	public static int[] solution(String[] info, String[] query) {
		int[] answer = new int[query.length];
		Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
		for (int i = 0; i < info.length; i++) {
			Input(map, info[i]);
		}
		List<Integer> empty = new ArrayList<>();
		for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
			entry.getValue().sort(null);
		}

		for (int i = 0; i < query.length; i++) {
			int endPoint = query[i].lastIndexOf(" ") + 1;
			String q = query[i].substring(0, endPoint - 1).replaceAll(" and ", "");
			int score = Integer.parseInt(query[i].substring(endPoint));

			List<Integer> scores = map.getOrDefault(q, empty);
			// 이분탐색
			int start = 0, end = scores.size();

			while (start < end) {
				// 중간 index 구하기
				int mid = (start + end) / 2;
				if (scores.get(mid) < score) {
					start = mid + 1;
				} else {
					end = mid;
				}
			}
			answer[i] = scores.size() - start;

		}

		return answer;
	}

//	// 전체 경우의 수 키로 저장
//	private static void setMap(Map<String, List<Integer>> map) {
//		String language[] = { "cpp", "java", "python", "-" };
//		String position[] = { "backend", "frontend", "-" };
//		String career[] = { "junior", "senior", "-" };
//		String soulfood[] = { "chicken", "pizza", "-" };
//
//		StringBuilder key;
//		for (int i = 0; i < language.length; i++) {
//			for (int j = 0; j < position.length; j++) {
//				for (int k = 0; k < career.length; k++) {
//					for (int l = 0; l < soulfood.length; l++) {
//						key = new StringBuilder();
//						key.append(language[i]).append(position[j]).append(career[k]).append(soulfood[l]);
//						map.put(key.toString(), new ArrayList<Integer>());
//					}
//				}
//			}
//		}
//	}

	private static void Input(Map<String, List<Integer>> map, String info) {
		int endPoint = info.lastIndexOf(" ") + 1;
		int score = Integer.parseInt(info.substring(endPoint));
		String[] q = info.substring(0, endPoint - 1).split(" ");
		for (int i = 0; i < 1 << 4; i++) {
			StringBuilder str = new StringBuilder();
			for (int j = 0; j < 4; j++) {
				if ((i & 1 << j) != 0) {
					str.append(q[j]);
				} else {
					str.append("-");
				}
			}
			map.computeIfAbsent(str.toString(), s -> new ArrayList<>()).add(score);
		}
	}
}