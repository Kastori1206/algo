package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 압축
 * https://programmers.co.kr/learn/courses/30/lessons/17684
 */
public class 압축 {
    public static void main(String[] args) {
        List<Integer> list = solution("TOBEORNOTTOBEORTOBEORNOT");
        for (Integer integer : list) {
            System.out.println("integer = " + integer);
        }
    }

    public static List<Integer> solution(String msg) {
        List<Integer> answer = new ArrayList<>();

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            map.put((char) ('A' + i) + "", i + 1);
        }
        int idx = 27;
        String[] msgs = msg.split("");
        for (int i = 0; i < msgs.length; i++) {
            StringBuilder key = new StringBuilder();
            int j = 0;
            boolean flag = true;
            for (j = i; j < msg.length(); j++) {
                key.append(msgs[j]);
                if (!map.containsKey(key.toString())) {
                    map.put(key.toString(), idx++);
                    flag = false;
                    break;
                }
            }
            i = j - 1;
            if (key.length() != 1) {
                if (!flag) {
                    key.deleteCharAt(key.length() - 1);
                }
            }
            answer.add(map.get(key.toString()));
        }
        return answer;
    }
}
