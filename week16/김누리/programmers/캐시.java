package week16.김누리.programmers;

import java.util.Deque;
import java.util.LinkedList;

/**
 * PackageName : week16.김누리.programmers
 * FileName    : 캐시
 * Author      : 김누리(NRKim)
 * Date        : 2025-08-11
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 08. 11.     김누리(NRKim)               Initial creation
 */

public class 캐시 {
	public int solution(int cacheSize, String[] cities) {
		if(cacheSize == 0) return 5 * cities.length; // cache를 못쓰면 전부 캐시 miss

		int answer = 0;
		Deque<String> cache = new LinkedList<>();

		//  캐싱 처리
		for(String city : cities) {
			String target = city.toUpperCase();

			//  캐시 hit
			if(cache.contains(target)) {
				cache.remove(target);
				cache.addFirst(target);
				answer += 1;
			} else {
				//  캐시 miss
				if(cache.size() == cacheSize) {
					cache.removeLast(); //  가장 오래된거 삭제
				}
				cache.addFirst(target);
				answer += 5;
			}
		}

		return answer;
	}
}
