package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 싸지방에 간 준하
 * https://www.acmicpc.net/problem/12764
 */
public class baek12764 {
    static class Person implements Comparable<Person> {
        int p, q;

        public Person(int p, int q) {
            this.p = p;
            this.q = q;
        }

        @Override
        public int compareTo(Person o) {
            if (p == o.p) {
                return Integer.compare(q, o.q);
            }
            return Integer.compare(p, o.p);
        }
    }

    static class Seat implements Comparable<Seat> {
        int idx, end;

        public Seat(int idx, int end) {
            this.idx = idx;
            this.end = end;
        }

        @Override
        public int compareTo(Seat o) {
            return Integer.compare(end, o.end);
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Person[] persons = new Person[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            persons[i] = new Person(p, q);
        }
        int[] cnt = new int[N + 1];

        Arrays.sort(persons);
        PriorityQueue<Seat> seat = new PriorityQueue<>();
        PriorityQueue<Integer> end = new PriorityQueue<>();
        int idx = 0;
        for (int i = 0; i < N; i++) {
            while (!seat.isEmpty() && persons[i].p >= seat.peek().end) {
                end.offer(seat.poll().idx);
            }

            if (!end.isEmpty()) {
                int tempIdx = end.poll();
                cnt[tempIdx]++;
                seat.offer(new Seat(tempIdx, persons[i].q));
            } else {
                cnt[idx]++;
                seat.offer(new Seat(idx++, persons[i].q));
            }
        }

        for (int i = 0; i <= N; i++) {
            if (cnt[i] == 0) {
                System.out.println(i);
                break;
            }
            answer.append(cnt[i]).append(" ");
        }
        System.out.println(answer.toString());
    }
}
