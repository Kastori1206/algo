package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/* 
 * 부분수열의 합2
 * https://www.acmicpc.net/problem/1208
 */
public class baek1208 {
	static int N, S;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());

		arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		List<Integer> A = new ArrayList<Integer>();
		List<Integer> B = new ArrayList<Integer>();

		// 2^40 부분집합 구하는 것은 시간 초과
		dfs(A, 0, N / 2, 0);
		dfs(B, N / 2, N, 0);

		// 리스트 정렬
		Collections.sort(A);
		Collections.sort(B);

		int left = 0;
		int right = B.size() - 1;
		long answer = 0;

		while (left < A.size() && right >= 0) {
			int aValue = A.get(left);
			int bValue = B.get(right);

			// 같은 합이 들어있을 경우
			if (aValue + bValue == S) {
				// left를 증가시키며 aCnt를 증가
				long aCnt = 0;
				while (left < A.size() && A.get(left) == aValue) {
					left++;
					aCnt++;
				}

				// right를 감소시키며 bCnt를 증가
				long bCnt = 0;
				while (right >= 0 && B.get(right) == bValue) {
					right--;
					bCnt++;
				}

				answer += aCnt * bCnt;
			}

			if (aValue + bValue < S) {
				left++;
			}
			if (aValue + bValue > S) {
				right--;
			}
		}

		// S가 0일때 아무것도 선택 안했을 경우 빼줌
		answer = S == 0 ? answer - 1 : answer;
		System.out.println(answer);
	}

	// index ~ n 까지 부분수열의 합 구하기
	private static void dfs(List<Integer> list, int index, int n, int sum) {
		if (index == n) {
			list.add(sum);
			return;
		}

		dfs(list, index + 1, n, sum + arr[index]);
		dfs(list, index + 1, n, sum);
	}
}
