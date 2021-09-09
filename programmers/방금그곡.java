package programmers;

/**
 * 방금그곡
 * https://programmers.co.kr/learn/courses/30/lessons/17683
 */
public class 방금그곡 {
    public static void main(String[] args) {
        String m = "CCB";
        String[] musicinfos = {"03:00,03:10,FOO,CCB#CCB", "04:00,04:08,BAR,ABC"};
        System.out.println(solution(m, musicinfos));
    }

    public static String solution(String m, String[] musicinfos) {
        m = rename(m);
        String answer = "(None)";
        int runningTime = 0;
        int idx = -1;

        System.out.println("m = " + m);
        for (int i = 0; i < musicinfos.length; i++) {
            String[] musicinfo = musicinfos[i].split(",");
            String[] start = musicinfo[0].split(":");
            String[] end = musicinfo[1].split(":");
            String name = musicinfo[2];
            String score = rename(musicinfo[3]);
            int scoreLen = score.length();

            int startHH = Integer.parseInt(start[0]);
            int startMM = Integer.parseInt(start[1]);
            int endHH = Integer.parseInt(end[0]);
            int endMM = Integer.parseInt(end[1]);

            int len = (endHH - startHH) * 60 + (endMM - startMM);
            if (m.length() > len) {
                continue;
            }
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < len / scoreLen; j++) {
                sb.append(score);
            }
            for (int j = 0; j < len % scoreLen; j++) {
                sb.append(score.charAt(j));
            }
            if (sb.toString().contains(m)) {
                if (idx == -1) {
                    answer = name;
                    runningTime = len;
                    idx = i;
                }else{
                    if (runningTime < len) {
                        runningTime = len;
                        answer = name;
                    }
                }
            }
        }

        return answer;
    }
    public static String rename(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == 'A' || c == 'C' || c == 'D' || c == 'F' || c == 'G') {
                if (i < str.length() - 1 && str.charAt(i+1) =='#') {
                    switch (c) {
                        case 'A':
                            sb.append('a');
                            break;
                        case 'C':
                            sb.append('c');
                            break;
                        case 'D':
                            sb.append('d');
                            break;
                        case 'F':
                            sb.append('f');
                            break;
                        case 'G':
                            sb.append('g');
                            break;
                    }
                    i++;
                }else{
                    sb.append(c);
                }
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }

}
