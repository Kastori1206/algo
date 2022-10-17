package groom.week2;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 출석부
 */
public class C {
    static class Node implements Comparable<Node>{
        String name;
        String h;

        public Node(String name, String h) {
            this.name = name;
            this.h = h;
        }

        @Override
        public int compareTo(Node o) {
            if (name.equals(o.name)) {
                return h.compareTo(o.h);
            }
            return name.compareTo(o.name);
        }

        @Override
        public String toString() {
            return name + " " + h;

        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new Node(st.nextToken(), st.nextToken()));
        }

        Collections.sort(list);
        System.out.println(list.get(k-1));
    }
}


