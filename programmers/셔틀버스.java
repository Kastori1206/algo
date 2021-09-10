package programmers;

import java.util.PriorityQueue;

/**
 * 셔틀버스
 * https://programmers.co.kr/learn/courses/30/lessons/17678
 */
public class 셔틀버스 {
    public static void main(String[] args) {
        int n = 1, t = 1, m = 5;
        String[] timetable = {"08:00", "08:01", "08:02", "08:03"};
        System.out.println(solution(n, t, m, timetable));
    }

    static class Time implements Comparable<Time> {
        int h, m;

        public Time(int h, int m) {
            if (m < 0) {
                h--;
            } else if (m >= 60) {
                h++;
            }

            this.h = h % 24;
            this.m = m % 60;
        }

        public String convert() {
            return String.format("%02d:%02d", h, m);
        }

        @Override
        public String toString() {
            return "Time{" +
                    "h=" + h +
                    ", m=" + m +
                    '}';
        }

        @Override
        public int compareTo(Time o) {
            if (h == o.h) {
                return Integer.compare(m, o.m);
            }
            return Integer.compare(h, o.h);
        }
    }

    public static String solution(int n, int t, int m, String[] timetable) {
        PriorityQueue<Time> pq = new PriorityQueue<>();
        for (String time : timetable) {
            String[] temp = time.split(":");
            int hh = Integer.parseInt(temp[0]);
            int mm = Integer.parseInt(temp[1]);

            pq.offer(new Time(hh, mm));
        }
        Time answer = new Time(9, 0);
        Time bus = new Time(9, 0);
        for (int i = 0; i < n; i++) {
            int cnt = 0;

            for (int j = 0; j < m; j++) {
                if (!pq.isEmpty()) {
                    Time people = pq.peek();

                    if (people.compareTo(bus) <= 0) {
                        answer = pq.poll();
                        cnt++;
                    }
                }
                if (i == n - 1) {
                    if (cnt == m) {
                        answer = new Time(answer.h, answer.m - 1);
                    } else if (cnt < m) {
                        answer = new Time(bus.h, bus.m);
                    }
                }
            }
            bus = new Time(bus.h, bus.m + t);

        }

        return answer.convert();
    }

}
