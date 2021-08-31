package programmers;

import java.util.HashMap;
import java.util.Map;

/**
 * 자동완성
 * https://programmers.co.kr/learn/courses/30/lessons/17685?language=java
 */
public class 자동완성 {
    public static void main(String[] args) {
        String[] word = {"go", "gone", "guild"};
        System.out.println(solution(word));
    }

    public static class Trie {
        Node root = new Node();

        //삽입
        public void insert(String str){
            Node node = root;

            for (int i = 0; i < str.length(); i++) {
                node = node.childNodes.computeIfAbsent(str.charAt(i), c -> new Node());
                node.count++;
            }
        }

        //조회
        public int search(String str) {
            int cnt = 0;
            Node cur = root;

            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);

                Node node = cur.childNodes.get(c);
                cnt++;
                if (node.count == 1) {
                    return cnt;
                }
                cur = node;
            }
            return cnt;
        }
    }

    public static class Node {
        int count = 0;
        HashMap<Character, Node> childNodes = new HashMap<>();
    }
    public static int solution(String[] words) {
        int answer = 0;
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        for (String word : words) {
            int cnt = trie.search(word);
            System.out.println("cnt = " + cnt);
            answer += trie.search(word);
        }

        return answer;
    }
}
