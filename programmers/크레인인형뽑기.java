package programmers;

import java.util.Stack;

/**
 * 크레인 인형 뽑기 
 * https://programmers.co.kr/learn/courses/30/lessons/64061
 */
public class 크레인인형뽑기 {
	public static void main(String[] args) {
		int[][] board = { { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 3 }, { 0, 2, 5, 0, 1 }, { 4, 2, 4, 4, 2 },
				{ 3, 5, 1, 3, 1 } };
		int[] moves = { 1, 5, 3, 5, 1, 2, 1, 4 };
		System.out.println(solution(board, moves));
	}

	public static int solution(int[][] board, int[] moves) {
		int answer = 0;
		int N = board.length;
		int[] h = new int[N];

		for (int c = 0; c < N; c++) {
			for (int r = 0; r < N; r++) {
				if (board[r][c] != 0) {
					h[c] = r;
					break;
				}
			}
		}

		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < moves.length; i++) {
			int c = moves[i] - 1;
			int cur = board[h[c]][c];
			int pre = stack.isEmpty() ? 0 : stack.peek();
			board[h[c]][c] = 0;
			h[c] = h[c] == N - 1 ? N - 1 : h[c] + 1;

			if (cur != 0 && pre == cur) {
				answer += 2;
				stack.pop();
			} else if (cur != 0) {
				stack.push(cur);
			}
		}
		return answer;
	}
}
