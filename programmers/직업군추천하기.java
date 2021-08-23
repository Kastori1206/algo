package programmers;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 직업군 추천하기
 * https://programmers.co.kr/learn/courses/30/lessons/84325
 */
public class 직업군추천하기 {
    public static void main(String[] args) {
        String[] table = {"SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"};
        String[] languages = {"PYTHON", "C++", "SQL"};
        int[] preference = {7,5,5};
        System.out.println(solution(table,languages,preference));
        table = new String[]{"SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"};
        languages = new String[]{"JAVA", "JAVASCRIPT"};
        preference = new int[]{7,5};
        System.out.println(solution(table,languages,preference));
    }

    static class JobsLang implements Comparable<JobsLang> {
        String job;
        int score;

        public JobsLang(String job, int score) {
            this.job = job;
            this.score = score;
        }

        @Override
        public String toString() {
            return "JobsLang{" +
                    "job='" + job + '\'' +
                    ", score=" + score +
                    '}';
        }

        @Override
        public int compareTo(JobsLang o) {
            if (this.score > o.score) {
                return -1;
            }else if(this.score == o.score) {
                return this.job.compareTo(o.job);
            }else{
                return 1;
            }
        }
    }
    public static String solution(String[] table, String[] languages, int[] preference) {
        Map<String, Integer> languagesPreference = new HashMap<>();
        for(int i = 0 ; i<languages.length; i++){
            languagesPreference.put(languages[i], preference[i]);
        }
        PriorityQueue<JobsLang> pq = new PriorityQueue<>();
        for (int i = 0; i < table.length; i++) {
            String[] temp = table[i].split(" ");
            String job = temp[0];
            int sum = 0;
            int score = temp.length-1;
            for (int j = 1; j < temp.length; j++) {
                if (languagesPreference.containsKey(temp[j])) {
                    sum += languagesPreference.get(temp[j])*score;
                }
                score--;
            }
            pq.offer(new JobsLang(job, sum));
        }

        return pq.poll().job;
    }
}
