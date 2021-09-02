package programmers;

import java.util.*;

/**
 * 가사 검색
 * https://programmers.co.kr/learn/courses/30/lessons/60060
 */
public class 가사검색 {
    public static void main(String[] args) {
        String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
        String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?"};
        List<Integer> list = solution(words, queries);
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
    }

    static List<String> list;

    public static List<Integer> solution(String[] words, String[] queries) {
        List<Integer> answer = new ArrayList<>();
        Map<Integer, List<String>> wordMap = new HashMap<>();
        Map<Integer, List<String>> reverseMap = new HashMap<>();

        for (String word : words) {
            int len = word.length();

            wordMap.computeIfAbsent(len, i -> new ArrayList<>()).add(word);
            reverseMap.computeIfAbsent(len, i -> new ArrayList<>()).add(reverse(word));
        }

        for (int key : wordMap.keySet()) {
            Collections.sort(wordMap.get(key));
            Collections.sort(reverseMap.get(key));
        }

        for (String query : queries) {
            if (query.charAt(0) == '?') {
                list = reverseMap.get(query.length());
                query = reverse(query);
            } else
                list = wordMap.get(query.length());

            if (list == null) {
                answer.add(0);
            } else {
                int res = lowerBound(query.replace('?', (char) 123)) - lowerBound(query.replace("?", ""));
                answer.add(res);
            }
        }
        return answer;
    }

    public static int lowerBound(String str) {
        int start = 0, end = list.size();

        while (start < end) {
            int mid = (start + end) / 2;

            if (str.compareTo(list.get(mid)) <= 0) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return end;
    }

    public static String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}
