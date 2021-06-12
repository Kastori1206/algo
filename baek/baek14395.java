package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
 * 4연산
 * https://www.acmicpc.net/problem/14395
 */
public class baek14395 {
    static class Node{
        long n;
        String op;
        public Node(long n, String op) {
            this.n = n;
            this.op = op;
        }
    }
    static char[] opers = {'*','+','-','/'};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long s = Long.parseLong(st.nextToken());
        long t = Long.parseLong(st.nextToken());

        if( s == t){
            System.out.println(0);
            return;
        }
        Set<Long> set = new HashSet<>();
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(s,""));
        set.add(s);
        while(!q.isEmpty()){
            Node node = q.poll();
            long n = node.n;
            if(n == t){
                System.out.println(node.op.toString());
                return;
            }
            for(int i = 0 ;i<4;i++){
                long temp = 0;
                switch (i){
                    case 0:
                        temp = n * n;
                        break;
                    case 1:
                        temp = n + n;
                        break;
                    case 2:
                        temp = n - n;
                        break;
                    case 3:
                        if(n !=0){
                            temp = n / n;
                            break;
                        }
                }
                if(!set.contains(temp)){
                    set.add(temp);
                    q.offer(new Node(temp, node.op + opers[i]));
                }
            }

        }
        System.out.println(-1);


    }
}
