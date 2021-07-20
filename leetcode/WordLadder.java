package leetcode;

import java.util.*;

/**
 * 127. Word Ladder
 * https://leetcode.com/problems/word-ladder/
 */
public class WordLadder {
    public static void main(String[] args) {
        String beginWord = "hit", endWord = "cog";
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");

        System.out.println(ladderLength(beginWord, endWord, wordList));
    }


    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        wordList.add(beginWord);

        List<Integer>[] adj = new ArrayList[wordList.size()];
        for (int i = 0; i < wordList.size(); i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < wordList.size(); i++) {
            for (int j = i + 1; j < wordList.size(); j++) {
                if (check(wordList.get(i), wordList.get(j))) {
                    adj[i].add(j);
                    adj[j].add(i);
                }
            }
        }
        Queue<Integer> q = new LinkedList<>();
        int[] d = new int[wordList.size()];
        boolean[] visited = new boolean[wordList.size()];

        q.add(wordList.size()-1);
        d[wordList.size() - 1] = 1;
        visited[wordList.size() - 1] = true;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (Integer next : adj[cur]) {
                if (!visited[next]) {
                    d[next] = d[cur] + 1;
                    q.offer(next);
                    visited[next] = true;
                }
            }
        }
        return d[wordList.indexOf(endWord)];
    }

    //두개의 문자열이 한개 차이나는지 확인
    public static boolean check(String s1, String s2) {
        int cnt = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                cnt++;
            }
            if (cnt >= 2) {
                return false;
            }
        }
        return true;
    }
}
