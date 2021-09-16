package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 휴대폰 자판
 * https://www.acmicpc.net/problem/5446
 */
public class baek5670 {
	static class Trie {
		Node root = new Node();

		public void insert(String str) {
			Node node = root;

			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				node.childNodes.putIfAbsent(c, new Node());
				node = node.childNodes.get(c);
				if (i == str.length() - 1) {
					node.isLast = true;
					return;
				}
			}
		}

		public int search(String str) {
			Node node = root.childNodes.get(str.charAt(0));
			int cnt = 1;
			for (int i = 1; i < str.length(); i++) {
				if (node.childNodes.size() != 1 || node.isLast) {
					cnt++;
				}
				char c = str.charAt(i);
				node = node.childNodes.get(c);
			}
			return cnt;
		}
	}

	static class Node {
		boolean isLast = false;

		Map<Character, Node> childNodes = new HashMap<>();
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		String input ="";

        while ((input = br.readLine()) != null) {
        	if(input.equals("")) {
        		break;
        	}
			int N = Integer.parseInt(input);
			Trie trie = new Trie();
			double sum = 0;
			List<String> list = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				trie.insert(str);
				list.add(str);
			}

			for (String str : list) {
				sum += trie.search(str);
			}

			answer.append(String.format("%.2f", sum / N)).append("\n");
		}
		System.out.println(answer.toString());
	}
}
