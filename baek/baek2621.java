package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 카드게임
 * https://www.acmicpc.net/problem/2621
 */
public class baek2621 {
    static class Card implements Comparable<Card> {
        char color;
        int num;

        public Card(char color, int num) {
            this.color = color;
            this.num = num;
        }

        @Override
        public int compareTo(Card o) {
            return Integer.compare(num, o.num);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        List<Card> cards = new ArrayList<>();

        int[] count = new int[10];
        int max = 0;
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            char color = st.nextToken().charAt(0);
            int num = Integer.parseInt(st.nextToken());

            cards.add(new Card(color, num));
            max = Math.max(max, num);
            count[num]++;
        }

        Collections.sort(cards);
        int answer = 0;
        boolean colorCheck = true;
        boolean numCheck = true;
        char c = cards.get(0).color;
        for (int i = 1; i < 5; i++) {
            if (c != cards.get(i).color) {
                colorCheck = false;
            }
            if (cards.get(i).num != cards.get(i - 1).num + 1) {
                numCheck = false;
            }
        }
        if (colorCheck) {
            answer = Math.max(answer, 600 + max);
        }
        if (numCheck) {
            answer = Math.max(answer, 500 + max);
        }
        if (colorCheck && numCheck) {
            answer = Math.max(answer, 900 + max);
        }

        List<int[]> nums = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            if (count[i] == 0) {
                continue;
            }
            nums.add(new int[]{count[i], i});
        }

        nums.sort(((o1, o2) -> -Integer.compare(o1[0], o2[0])));

        if (nums.get(0)[0] >= 4) {
            answer = Math.max(answer, nums.get(0)[1] + 800);
        } else if (nums.get(0)[0] == 3) {
            if (nums.get(1)[0] == 2) {
                answer = Math.max(answer, nums.get(0)[1] * 10 + nums.get(1)[1] + 700);
            } else {
                answer = Math.max(answer, nums.get(0)[1] + 400);
            }
        } else if (nums.get(0)[0] == 2) {
            if (nums.get(1)[0] == 2) {
                int a = nums.get(0)[1];
                int b = nums.get(1)[1];
                answer = Math.max(answer, Math.max(a, b) * 10 + Math.min(a, b) + 300);
            } else {
                answer = Math.max(answer, nums.get(0)[1] + 200);
            }
        } else {
            answer = Math.max(answer, max + 100);
        }
        System.out.println(answer);
    }
}
