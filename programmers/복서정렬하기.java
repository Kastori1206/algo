package programmers;

import java.util.*;

/**
 * 복서 정렬하기 
 * https://programmers.co.kr/learn/courses/30/lessons/85002
 */
public class 복서정렬하기 {

	public static void main(String[] args) {
		int[] weights = { 50, 82, 75, 120 };
		String[] head2head = { "NLWL", "WNLL", "LWNW", "WWLN" };
		System.out.println(Arrays.toString(solution(weights, head2head)));
	}

	static class Boxer implements Comparable<Boxer> {
		int idx;        //복서의 번호
		int weight;     //복서 몸무게
		int win;        //자기보다 무거운 복서를 이긴 횟수
		double winRate; //승률

		public Boxer(int idx, int weight, int win, double winRate) {
			super();
			this.idx = idx;
			this.weight = weight;
			this.win = win;
			this.winRate = winRate;
		}

		@Override
		public String toString() {
			return "Boxer [idx=" + idx + ", weight=" + weight + ", win=" + win + ", winRate=" + winRate + "]";
		}

		@Override
		public int compareTo(Boxer o) {
			if (winRate == o.winRate) {
				if (win == o.win) {
					if (weight == o.weight) {
						// 복서의 번호들 중에서는 작은 번호가 앞
						return Integer.compare(idx, o.idx);
					}
					// 자기 몸무게가 무거운 복서의 번호
					return -Integer.compare(weight, o.weight);
				}
				// 자신보다 몸무게가 무거운 복서를 이긴 횟수가 많은 복서의 번호
				return -Integer.compare(win, o.win);
			}
			// 전체 승률이 높은 복서의 번호
			return -Double.compare(winRate, o.winRate);
		}
	}

	public static int[] solution(int[] weights, String[] head2head) {
		List<Boxer> list = new ArrayList<>();
		int[] answer = new int[head2head.length];
		for (int i = 0; i < head2head.length; i++) {
			int idx = i + 1;
			double w = 0, l = 0;
			int win = 0;
			for (int j = 0; j < head2head[i].length(); j++) {
				if (i == j) {
					continue;
				}
				char c = head2head[i].charAt(j);
				switch (c) {
				case 'W':
					if (weights[i] < weights[j]) {
						win++;
					}
					w++;
					break;
				case 'L':
					l++;
					break;
				}
			}
			double winRate = w + l == 0 ? 0 : w / (w + l);
			list.add(new Boxer(idx, weights[i], win, winRate));
		}
		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i).idx;
		}
		return answer;
	}
}
