package week16.강성욱.programmers;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * PackageName : week16.강성욱.programmers
 * FileName    : 캐시
 * Author      : Baekgwa
 * Date        : 2025-08-14
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-08-14     Baekgwa               Initial creation
 */
public class 캐시 {
	// class Solution {
	// 	public int solution(int cacheSize, String[] cities) {
	// 		PriorityQueue<CityCache> pq = new PriorityQueue<>(Comparator.comparingInt(CityCache::getUsedTime));
	//
	// 		int runningTime = 0;
	//
	// 		for (int time = 0; time < cities.length; time++) {
	// 			String nowCity = cities[time];
	//
	// 			// 캐시 히트 상황
	// 			if(pq.contains(nowCity)) {
	// 			}
	// 		}
	// 	}
	//
	// 	public static class CityCache {
	// 		private int usedTime;
	// 		private String city;
	//
	// 		public CityCache(int usedTime, String city) {
	// 			this.usedTime = usedTime;
	// 			this.city = city;
	// 		}
	//
	// 		public int getUsedTime() {
	// 			return usedTime;
	// 		}
	//
	// 		public String getCity() {
	// 			return city;
	// 		}
	// 	}
	// }
	class Solution {
		public int solution(int cacheSize, String[] cities) {
			Map<String, Integer> map = new LinkedHashMap<>(cacheSize);

			int runningTime = 0;
			for(String city : cities) {
				city = city.toLowerCase();

				//캐시 히트 확인
				if(map.containsKey(city)) {
					runningTime += 1;
					map.remove(city); //지우고 다시 넣기
					map.put(city, 0);
				} else { // 캐시 미스
					runningTime += 5;
					map.put(city, 0);
					// 크기가 더 크면 삭제
					if (map.size() > cacheSize) {
						String firstKey = map.keySet().iterator().next();
						map.remove(firstKey);
					}
				}
			}

			return runningTime;
		}
	}
}