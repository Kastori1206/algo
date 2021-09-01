package programmers;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 튜플
 * https://programmers.co.kr/learn/courses/30/lessons/64065
 */
public class 튜플 {
    public static void main(String[] args) {
//        String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
        String s = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
        System.out.println(Arrays.toString(solution(s)));
    }
    public static int[] solution(String s) {
        Pattern p = Pattern.compile("\\{(.*?)\\}");
        Matcher m = p.matcher(s.substring(1));
        List<String> list = new ArrayList<>();

        while (m.find()) {
            list.add(m.group(1));
        }
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }

        });
        int[] answer = new int[list.size()];

        Set<String> set = new HashSet<>();
        int idx = 0;
        for (String s1 : list) {
            String[] temp = s1.split(",");
            for (String s2 : temp) {
                if (!set.contains(s2)) {
                    answer[idx++] = Integer.parseInt(s2);
                    set.add(s2);
                }
            }
        }
        return answer;
    }
}
