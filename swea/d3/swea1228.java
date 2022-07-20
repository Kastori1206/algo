package swea.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [s/w 문제해결 기본] 암호문 1
 */
public class swea1228 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= 10; t++) {
            MyList list = new MyList();
            int N = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                list.add(st.nextToken());
            }

            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                if (st.nextToken().equals("I")) {
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());
                    MyList temp = new MyList();
                    for (int i = 0; i < y; i++) {
                        temp.add(st.nextToken());
                    }
                    list.add(x, temp);
                }
            }

            sb.append("#").append(t+ " ");
            Node head = list.head;
            for (int i = 0; i < 10; i++) {
                sb.append(head.data+ " ");
                head = head.next;
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
class MyList{
    Node head;
    Node last;

    public MyList() {
        this.head = null;
        this.last = null;
    }

    public void add(int idx, MyList temp) {
        if (idx == 0) {
            temp.last.next = this.head;
            this.head = temp.head;
            return;
        }
        Node pre = search(idx - 1);
        temp.last.next = pre.next;
        pre.next = temp.head;


    }
    public void add(String data) {
        if (head == null) {
            head = new Node(data);
            last = head;
        } else {
            Node newNode = new Node(data);
            last.next = newNode;
            last = newNode;
        }
    }

    public Node search(int index) {
        int cnt = 0;
        Node res = head;
        while (true) {
            if (index == cnt) {
                return res;
            }
            res = res.next;
            cnt++;
        }
    }
}
class Node{
    String data;
    Node next;

    public Node(String data) {
        this.data = data;
    }
}
