package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 용량 부족
 * https://www.acmicpc.net/problem/5446
 */
public class baek5446 {
	static class Trie {
		Node root = new Node();

		void insert(String str, boolean flag) {
			Node node = root;
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);

				node.childNodes.putIfAbsent(c, new Node());
				node = node.childNodes.get(c);
				node.flag = flag;
				if (i == str.length() - 1) {
					node.isLast = flag;
					return;
				}
			}
		}
	
	}

	static class Node {
		boolean flag;
		boolean isLast;
		Map<Character, Node> childNodes = new HashMap<>();
	}

	static void dfs(Node node) {		
		if (node.flag) {
			ans++;
			return;
		} else if (node.isLast) {
			ans++;
		}
		for (Character key : node.childNodes.keySet()) {
			dfs(node.childNodes.get(key));
		}

	}

	static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			ans = 0;
			int N = Integer.parseInt(br.readLine());
			Trie trie = new Trie();
			for (int i = 0; i < N; i++) {
				trie.insert(br.readLine(),true);
			}

			int M = Integer.parseInt(br.readLine());
			for (int i = 0; i < M; i++) {
				trie.insert(br.readLine(), false);
			}

			Node root = trie.root;
			dfs(root);
				
			answer.append(ans == N ? 1 : ans);
		}
		System.out.println(answer.toString());
	}
}
