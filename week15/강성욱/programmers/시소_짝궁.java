package week15.강성욱.programmers;

import java.util.HashMap;
import java.util.Map;

/**
 * PackageName : week15.강성욱.programmers
 * FileName    : 시소_짝궁
 * Author      : Baekgwa
 * Date        : 2025-08-08
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-08-08     Baekgwa               Initial creation
 */
public class 시소_짝궁 {
	//무게 정보가 너무 많은데...? 최적화가 필요함.
	// 모든 무게 정보를 map 에 저장해두고 value 로는 count로 쓰면?
	//만약 100 이 2개면 1개쌍 가능
	//100이 3개면? 1-2, 1-3, 2-3 3쌍 가능
	//100이 4개면? 1-2, 1-3, 1-4, 2-3, 2-4, 3-4 6쌍 가능
	//100이 N개면? 0 + 1 + 2 + ... + (N-1) 쌍 만큼 가는ㅇ
	//Map 에 넣어두고 꺼내서 쓰면 될 것 같은데?

	class Solution {
		//     public long solution(int[] weights) {

		//         Map<Integer, Integer> map = new HashMap<>();
		//         long result = 0L;

		//         for(int weight : weights) {
		//             map.put(weight, map.getOrDefault(weight, 0) + 1);
		//             map.put(weight * 2, map.getOrDefault(weight * 2, 0) + 1);
		//             map.put(weight * 3, map.getOrDefault(weight * 3, 0) + 1);
		//             map.put(weight * 4, map.getOrDefault(weight * 4, 0) + 1);
		//         }

		//         for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
		//             if(entry.getValue() >= 2) result += cal(entry.getValue());
		//         }

		//         return result;
		//     }

		//     private long cal(int N) {
		//         System.out.println(N);
		//         long result = 0;

		//         for(int l = N-1; l >= 0; l--) {
		//             result += l;
		//         }

		//         return result;
		//     }

		// gpt!
		// 시소의 좌석 위치(거리)는 2, 3, 4(m)이고, 두 명이 마주 앉으므로 가능한 거리 비율 조합은 다음뿐.
		// 한쪽 거리	반대쪽 거리	거리 비율 (왼/오)
		// 2	3	2/3
		// 2	4	1/2
		// 3	2	3/2
		// 3	4	3/4
		// 4	2	2/1
		// 4	3	4/3
		// 동일 거리	동일 거리	1

		public long solution(int[] weights) {
			long answer = 0;
			Map<Integer, Long> countMap = new HashMap<>();

			double[] ratios = {1.0, 2.0/3.0, 1.0/2.0, 3.0/2.0, 3.0/4.0, 2.0, 4.0/3.0};

			for (int w : weights) {
				for (double r : ratios) {
					double target = w * r;
					if (target == (int) target) {
						answer += countMap.getOrDefault((int) target, 0L);
					}
				}
				countMap.put(w, countMap.getOrDefault(w, 0L) + 1);
			}

			return answer;
		}
	}
}
