package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*
 * 트리 순회
 * https://www.acmicpc.net/problem/1991
 */
public class baek1991 {
	static StringBuilder answer;
	static Map<Character, char[]> map ;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		answer = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		map = new HashMap<>();
		for(int i =0;i<N;i++) {
			String temp = br.readLine();
			map.put(temp.charAt(0), new char[] {temp.charAt(2), temp.charAt(4)});
		}
		
		preorder('A');
		answer.append("\n");
		inorder('A');
		answer.append("\n");
		postorder('A');
		
		System.out.println(answer.toString());
	}
	private static void preorder(char root) {
		if(root != '.') {
			answer.append(root);
			preorder(map.get(root)[0]);
			preorder(map.get(root)[1]);
		}
	}
	private static void inorder(char root) {
		if(root != '.') {
			inorder(map.get(root)[0]);
			answer.append(root);
			inorder(map.get(root)[1]);
		}
	}
	private static void postorder(char root) {
		if(root != '.') {
			postorder(map.get(root)[0]);
			postorder(map.get(root)[1]);
			answer.append(root);
		}
	}
}
