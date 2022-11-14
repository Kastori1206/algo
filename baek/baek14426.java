package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 접두사 찾기
 * https://www.acmicpc.net/problem/14426
 */
public class baek14426 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Trie trie = new Trie();

        for (int i = 0; i < N; i++) {
            trie.insert(br.readLine());
        }

        int answer = 0;
        for (int i = 0; i < M; i++) {
            if (trie.find(br.readLine())) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    static class Trie{
        Node root = new Node();

        void insert(String str) {
            Node node = root;

            for(int i =0;i<str.length();i++) {
                char ch = str.charAt(i);

                if(!node.childNodes.containsKey(ch)) {
                    node.childNodes.put(ch, new Node());
                }
                node = node.childNodes.get(ch);
            }
        }

        boolean find(String str){
            Node node = root;
            for(int i =0;i<str.length();i++) {
                char ch = str.charAt(i);

                if(!node.childNodes.containsKey(ch)) {
                    return false;
                }
                node = node.childNodes.get(ch);
            }

            return true;

        }
    }
    static class Node{
        Map<Character, Node> childNodes = new HashMap<>();

    }
}