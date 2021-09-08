package programmers;

import java.util.*;

/**
 * 파일명 정렬
 * https://programmers.co.kr/learn/courses/30/lessons/17686
 */
public class 파일명정렬 {

    public static void main(String[] args) {
        String[] files = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
        System.out.println(Arrays.toString(solution(files)));

    }

    static class File implements Comparable<File>{
        String name;
        String header;
        String number;

        public File(String name, String header, String number) {
            this.name = name;
            this.header = header;
            this.number = number;
        }

        @Override
        public int compareTo(File o) {
            if (header.toLowerCase().equals(o.header.toLowerCase())) {
                return Integer.compare(Integer.parseInt(number), Integer.parseInt(o.number));
            }

            return header.toLowerCase().compareTo(o.header.toLowerCase());
        }
    }
    public static String[] solution(String[] files) {
        String[] answer = new String[files.length];
        List<File> list = new ArrayList<>();

        for (int i = 0; i < files.length; i++) {
            String file = files[i];
            int start = 0;
            StringBuilder header = new StringBuilder();
            StringBuilder number = new StringBuilder();
            for (int j = start; j < file.length(); j++) {
                char c = file.charAt(j);
                if (Character.isDigit(c)) {
                    start = j;
                    break;
                }
                header.append(c);
            }
            for (int j = start; j < file.length(); j++) {
                char c = file.charAt(j);
                if (!Character.isDigit(c)) {
                    break;
                }
                number.append(c);
            }

            list.add(new File(file, header.toString(), number.toString()));
        }
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i).name;
        }
        return answer;
    }
}
