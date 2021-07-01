package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
 * 생태학
 * https://www.acmicpc.net/problem/4358
 */
public class baek4358 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int total = 0;
        String tree = "";
        Map<String, Integer> map = new HashMap<>();

        while ((tree = br.readLine()) != null) {
            if (tree.equals("")) {
                break;
            }
            if (map.containsKey(tree)) {
                map.put(tree, map.get(tree) + 1);
            } else {
                map.put(tree, 1);
            }
            total++;
        }
        String[] answer = new String[map.size()];
        int i = 0;
        for (String key : map.keySet()) {
            answer[i++] = String.format("%s %.4f", key, ((double) map.get(key) / (double) total) * 100);
        }

        Arrays.sort(answer);
        for (i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
    }
}
