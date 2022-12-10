package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 랭킹전 대기열
 * https://www.acmicpc.net/problem/20006
 */
public class baek20006 {
    static class Node implements Comparable<Node> {
        int l;
        String name;

        public Node(int l, String name) {
            this.l = l;
            this.name = name;
        }

        @Override
        public int compareTo(Node o) {
            return name.compareTo(o.name);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int P = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<Node>> rooms = new ArrayList<>();

        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            boolean flag = false;
            for (int j = 0; j < rooms.size(); j++) {
                List<Node> room = rooms.get(j);
                if (room.size() < M && Math.abs(room.get(0).l - l) <= 10) {
                    room.add(new Node(l, name));
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                rooms.add(new ArrayList<>());
                rooms.get(rooms.size() - 1).add(new Node(l, name));
            }
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).size() == M) {
                sb.append("Started!\n");
            } else {
                sb.append("Waiting!\n");
            }
            Collections.sort(rooms.get(i));
            for (Node node : rooms.get(i)) {
                sb.append(node.l).append(" ").append(node.name).append("\n");
            }
        }

        System.out.println(sb);
    }
}
