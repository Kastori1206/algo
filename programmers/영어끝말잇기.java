package programmers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 영어 끝말잇기
 * https://school.programmers.co.kr/learn/courses/30/lessons/12981
 */
public class 영어끝말잇기 {
    public static void main(String[] args) {
        String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        System.out.println(Arrays.toString(solution(3, words)));

//        String[] words = {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"};
//        System.out.println(Arrays.toString(solution(3, words)));

//        String[] words = {"hello", "one", "even", "never", "now", "world", "draw"};
//        System.out.println(Arrays.toString(solution(3, words)));

    }
    static public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        Set<String> set = new HashSet<>();
        set.add(words[0]);
        char e = words[0].charAt(words[0].length() - 1);
        for (int i = 1; i < words.length; i++) {
            String word = words[i];

            if (word.charAt(0) != e || set.contains(word)) {
                answer[0] = (i + 1) % n;
                answer[1] = (i + 1) / n;
                if (answer[0] == 0) {
                    answer[0] = n;
                } else {
                    answer[1]++;
                }
                break;
            }
            set.add(word);
            e = word.charAt(word.length() - 1);
        }
        return answer;
    }
}
