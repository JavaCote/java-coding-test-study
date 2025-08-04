package week15.김누리.programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * PackageName : week15.김누리.programmers
 * FileName    : 시소_짝궁
 * Author      : 김누리(NRKim)
 * Date        : 2025-08-04
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 08. 04.     김누리(NRKim)               Initial creation
 */

/*
시소 위치 4 3 2 0 2 3 4

weights = {100,180,360,100,270}

우선은 정렬 = {100,100,180,270,360}

맵을 통해 이전까지 나온 무게들을 체크하며 진행.


*/

public class 시소_짝꿍 {
	public long solution(int[] weights) {
		long answer = 0;
		Map<Integer, Integer> map = new HashMap<>();

		//  몸무게별 오름차순 정렬
		Arrays.sort(weights);

		for(int w : weights) {

			//  시소 위치별 나온 무게들 체크
			double[] rations = {1.0, 2.0/3, 2.0/4, 3.0/2, 3.0/4, 4.0/2, 4.0/3};

			for(double r : rations) {
				double tar = r * w;

				if(tar == Math.floor(tar)) {
					//  정수 확인용
					int t = (int) tar;

					//  맵에 해당 값이 있으면 점수 추가
					if(map.containsKey(t)) {
						answer += map.get(t);
					}
				}
			}

			//  없으면 맵 현재 무게 추가
			map.put(w, map.getOrDefault(w,0) + 1);
		}


		return answer;
	}
}
