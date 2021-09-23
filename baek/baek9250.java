package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 문자열 집합 판별
 * https://www.acmicpc.net/problem/9250
 */
public class baek9250 {
	static class Trie {
		Node root = new Node();

		void insert(String str) {
			Node node = root;

			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				node.childNodes.putIfAbsent(c, new Node());
				node = node.childNodes.get(c);

				if (i == str.length() - 1) {
					node.isLast = true;
				}
			}
		}

		void failure() {
			Queue<Node> q = new LinkedList<>();
			Node node = root;

			q.offer(node);

			while (!q.isEmpty()) {
				Node cur = q.poll();

				for (Character key : cur.childNodes.keySet()) {
					Node next = cur.childNodes.get(key);
					if (cur == node) {
						next.fail = node;
					} else {
						Node prev = cur.fail;
						while (prev != node && !prev.childNodes.containsKey(key)) {
							prev = prev.fail;
						}
						if (prev.childNodes.containsKey(key)) {
							prev = prev.childNodes.get(key);
						}
						next.fail = prev;
					}
					if (next.fail.isLast) {
						next.isLast = true;
					}
					q.offer(next);
				}
			}
		}

		boolean kmp(String str) {
			Node cur = root;
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				while (cur != root && !cur.childNodes.containsKey(c)) {
					cur = cur.fail;
				}
				if (cur.childNodes.containsKey(c)) {
					cur = cur.childNodes.get(c);
				}
				if (cur.isLast) {
					return true;
				}
			}
			return false;
		}
	}

	static class Node {
		Node fail; // 실패했을 때, 이동해야할 지점을 가리킬 변수
		boolean isLast;

		Map<Character, Node> childNodes = new HashMap<>();

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		Trie trie = new Trie();
		for (int i = 0; i < N; i++) {
			trie.insert(br.readLine());
		}
		trie.failure();
		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			if (trie.kmp(br.readLine())) {
				answer.append("YES\n");
			} else {
				answer.append("NO\n");
			}
		}
		System.out.println(answer.toString());
	}
}
