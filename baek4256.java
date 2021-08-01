import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 트리
 * https://www.acmicpc.net/problem/4256
 */
public class baek4256 {
	static int[] preOrder, inOrder;
	static StringBuilder answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		answer = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			preOrder = new int[N];
			inOrder = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				preOrder[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				inOrder[i] = Integer.parseInt(st.nextToken());
			}
			postOrder(0, N, 0);
			answer.append("\n");
		}
		System.out.println(answer.toString());
	}

	public static void postOrder(int start, int end, int r) {
		for (int i = start; i < end; i++) {
			if (preOrder[r] == inOrder[i]) {
				postOrder(start, i, r + 1);
				postOrder(i + 1, end, r + 1 + i - start);
				answer.append(preOrder[r]).append(" ");
			}
		}
	}

}
