package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 트리의 순회
 * https://www.acmicpc.net/problem/2263
 */
public class baek2263 {
    public static int size;

    static int[] inOrder;
    static int[] inOrderIndex;
    static int[] postOrder;

    static StringBuilder sb;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        size = Integer.parseInt(br.readLine());

        inOrder = new int[size+1];
        inOrderIndex = new int[size+1];
        postOrder = new int[size+1];

        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        for(int i=1; i <= size; i++)
            inOrder[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=1; i <= size; i++) {
            postOrder[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i <= size; i++){
            inOrderIndex[inOrder[i]] = i;
        }

        go(1, size, 1, size);
        System.out.println(sb.toString());
    }

    public static void go(int inStart, int inEnd, int postStart, int postEnd) {
        if(inStart > inEnd || postStart > postEnd) {
            return;
        }

        int root = postOrder[postEnd];
        sb.append(root + " ");

        int rootIdx = inOrderIndex[root];
        int left = rootIdx - inStart;

        go(inStart, rootIdx-1, postStart, postStart+ left-1);
        go(rootIdx+1, inEnd, postStart + left, postEnd - 1);
    }
}

