package codeforces.div3.round693;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class D {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];

			long Alice = 0, Bob = 0;
			List<Integer> even = new ArrayList<>();
			List<Integer> odd = new ArrayList<>();

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				if (arr[i] % 2 == 0) {
					even.add(arr[i]);
				} else {
					odd.add(arr[i]);
				}
			}
			Collections.sort(even, new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					return -Integer.compare(o1, o2);
				}
			});

			Collections.sort(odd, new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					return -Integer.compare(o1, o2);
				}
			});

			//Alice 	  Bob
			int idx1 = 0, idx2 = 0;
			boolean flag = true;// Alice
			while (idx1 < even.size() && idx2 < odd.size()) {
				if (flag) {
					if (even.get(idx1) > odd.get(idx2)) {
						Alice += even.get(idx1);
						idx1++;
					} else {
						idx2++;
					}
					flag = false;
				} else {
					if (odd.get(idx2) > even.get(idx1)) {
						Bob += odd.get(idx2);
						idx2++;
					} else {
						idx1++;
					}
					flag = true;
				}
			}

			int cnt = 0;
			for (int i = idx1; i < even.size(); i++) {
				if (!flag) {
					if (cnt % 2 != 0) {
						Alice += even.get(i);
					}
				} else {
					if (cnt % 2 == 0) {
						Alice += even.get(i);
					}

				}
				cnt++;
			}

			cnt = 0;

			for (int i = idx2; i < odd.size(); i++) {
				if (!flag) {
					if (cnt % 2 == 0) {
						Bob += odd.get(i);
					}
				} else {
					if (cnt % 2 != 0) {
						Bob += odd.get(i);
					}
				}
				cnt++;
			}

			if (Alice > Bob) {
				System.out.println("Alice");
			} else if (Alice < Bob) {
				System.out.println("Bob");
			} else {
				System.out.println("Tie");
			}
		}
	}
}
