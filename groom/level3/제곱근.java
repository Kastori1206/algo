package groom.level3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * 제곱근
 * https://level.goorm.io/exam/160335/%EC%A0%9C%EA%B3%B1%EA%B7%BC/quiz/1
 */
public class 제곱근 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger N = new BigInteger(br.readLine());

        System.out.println(N.sqrt());
    }
}
