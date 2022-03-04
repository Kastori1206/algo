package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.*;

/**
 * 파일 탐색기
 * https://www.acmicpc.net/problem/20210
 */
public class baek20210 {
    static Pattern p;
    static Map<Character, Integer> map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String alpa = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz";
        map = new HashMap<>();
        for (int i = 0; i < alpa.length(); i++) {
            map.put(alpa.charAt(i), i);
        }

        p = Pattern.compile("[a-zA-Z]|\\d+");

        System.out.println(removeZero("00000"));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        List<String> answer = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            answer.add(br.readLine());
        }

        Collections.sort(answer, comp);
        for (String s : answer) {
            sb.append(s).append("\n");
        }

        System.out.println(sb);
    }

    static Comparator<String> comp = new Comparator<>() {
        @Override
        public int compare(String o1, String o2) {
            List<String> a = parse(o1);
            List<String> b = parse(o2);
            int len = Math.min(a.size(), b.size());

            for (int i = 0; i < len; i++) {
                if (!a.get(i).equals(b.get(i))) {
                    return myCompare(a.get(i), b.get(i));
                }
            }
            return Integer.compare(a.size(), b.size());
        }

        private int myCompare(String o1, String o2) {
            //숫자, 문자 || 문자 , 숫자
            if (isDigit(o1) != isDigit(o2)) {
                return o1.compareTo(o2);
            }
            //숫자 숫자
            else if (isDigit(o1)) {
                String a = removeZero(o1);
                String b = removeZero(o2);

                if (a.length() < b.length()) {
                    return -1;
                } else if (a.length() > b.length()) {
                    return 1;
                } else {
                    for (int i = 0; i < a.length(); i++) {
                        if (a.charAt(i) < b.charAt(i)) {
                            return -1;
                        }
                        if (a.charAt(i) > b.charAt(i)) {
                            return 1;
                        }
                    }
                }
                return Integer.compare(o1.length(), o2.length());
            }
            //문자 문자
            else {
                int a = map.get(o1.charAt(0));
                int b = map.get(o2.charAt(0));

                return Integer.compare(a, b);
            }
        }

        private boolean isDigit(String str) {
            return Pattern.compile("\\d+").matcher(str).find();
        }
    };

    static List<String> parse(String str) {
        List<String> res = new ArrayList<>();
        Matcher m = p.matcher(str);
        while (m.find()) {
            res.add(m.group());
        }
        return res;
    }

    static String removeZero(String num) {
        int idx = 0;
        for (idx = 0; idx < num.length(); idx++) {
            if (num.charAt(idx) != '0') {
                break;
            }
        }
        String temp = num.substring(idx);

        return temp.equals("") ? "0" : temp;
    }

}
