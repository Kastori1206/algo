package programmers;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 캐시 
 * https://programmers.co.kr/learn/courses/30/lessons/17680?language=java
 */
public class 캐시 {
	public static void main(String[] args) {
		System.out.println(solution(3, new String[] { "Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo","Seoul", "NewYork", "LA" }));
	}

	public static int solution(int cacheSize, String[] cities) {
		int answer = 0;
		Map<String, Integer> cache = new LinkedHashMap<String, Integer>(cacheSize) {
			@Override
			protected boolean removeEldestEntry(Entry<String, Integer> eldest) {
				return size() > cacheSize;
			}

		};
		for (String city : cities) {
			city = city.toLowerCase();
			if (cache.containsKey(city)) {
				cache.remove(city);
				answer += 1;
			} else {
				answer += 5;
			}
			cache.put(city, 0);
		}
		return answer;
	}
}
