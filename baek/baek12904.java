package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * A와 B
 * https://www.acmicpc.net/problem/12904
 */
public class baek12904 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String A = br.readLine();
        String B = br.readLine();

        while (A.length() < B.length()) {
            if (B.endsWith("A")) {
                B = B.substring(0, B.length() - 1);
            } else {
                B = B.substring(0, B.length() - 1);
                B = new StringBuilder(B).reverse().toString();
            }
        }
        if (A.equals(B)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
