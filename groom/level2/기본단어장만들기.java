package groom.level2;

import java.io.*;
import java.util.*;

public class 기본단어장만들기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        String[] arr = new String[n];

        for(int i=0;i<n;i++){
            arr[i] = br.readLine();
        }
        Arrays.sort(arr, (o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2);
            }

            return Integer.compare(o1.length(), o2.length());
        });

        System.out.println(arr[k-1]);
    }
}
