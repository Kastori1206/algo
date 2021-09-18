package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 개미굴
 * https://www.acmicpc.net/problem/14725
 */
public class baek14725 {
	static class Trie{
		Node root = new Node();
		
		void insert(String[] str) {
			Node node = root;
			
			for(int i =0;i<str.length;i++) {
				String temp = str[i];
				
				if(!node.childNodes.containsKey(temp)) {
					node.childNodes.put(temp, new Node());
				}
				node = node.childNodes.get(temp);
				
				if(i == str.length-1) {
					node.isLast = true;
				}
			}
		}
	}
	static class Node{
		boolean isLast;
		Map<String, Node> childNodes = new HashMap<>();
		
	}
	static StringBuilder answer = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		Trie trie = new Trie();
		
		for(int i =0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());
			String[] str = new String[K];
			for(int k =0;k<K;k++) {
				str[k] = st.nextToken();
			}
			trie.insert(str);
		}
		Node root = trie.root;
		find(root, 0);
		System.out.println(answer.toString());
	}
	
	public static void find(Node node, int depth) {
		if(node.childNodes.size()==0) {
			return;
		}
		List<String> keySet = new ArrayList<>(node.childNodes.keySet());
		
		Collections.sort(keySet);
		for(String key : keySet) {
			StringBuilder sb = new StringBuilder();
			for(int i =0;i<depth;i++) {
				sb.append("--");
			}
			sb.append(key).append("\n");
			answer.append(sb);
			find(node.childNodes.get(key),depth+1);
		}

	}
}
