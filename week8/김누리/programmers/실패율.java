package week8.김누리.programmers;

import java.util.HashMap;
import java.util.Map;

/**
 * PackageName : week8.김누리.programmers
 * FileName    : 실패율
 * Author      : 김누리(NRKim)
 * Date        : 2025-06-16
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 06. 16.     김누리(NRKim)               Initial creation
 */

/*
스테이지는 총 500 까지

case 1 :
N = 5 >> 총 스테이지는 5개

stages = [2,1,2,6,2,4,3,3]

stages[0] = 2 >> 스테이지 1 클리어, 2번째 스테이지 체류중
stages[1] = 1 >> 스테이지 미클리어, 1번째 스테이지 체류중
stages[2] = 2 >> 스테이지 1 클리어, 2번째 스테이지 체류중
stages[3] = 6 >> 스테이지 5 클리어 >> 모든 스테이지 클리어
stages[4] = 2 >> 스테이지 1 클리어, 2번째 스테이지 체류중
stages[5] = 4 >> 스테이지 3 클리어, 4번째 스테이지 체류중
stages[6] = 3 >> 스테이지 2 클리어, 3번째 스테이지 체류중
stages[7] = 3 >> 스테이지 2 클리어, 3번째 스테이지 체류중

스테이지 1 ==> 8명 중 1명 실패 ==> 1/8 ===> 0.125
스테이지 2 ==> 7명 중 3명 실패 ==> 3/7 ===> 0.428
스테이지 3 ==> 4명 중 2명 실패 ==> 2/4 ===> 0.5
스테이지 4 ==> 2명 중 1명 실패 ==> 1/2 ===> 0.5
스테이지 5 ==> 1명 중 1명 실패 ==> 0/1 ===> 0

실패율이 가장 높은순으로 정렬

3 4 2 1 5

*/

public class 실패율 {
	public int[] solution(int N, int[] stages) {
		int[] answer = new int[N];
		Map<Integer,Integer> map = new HashMap<>(); //  맵당 인원 정리
		int player = stages.length; // 총 플레이어

		//  총인원만큼 돌며 판정 map 초기화
		for(int i = 0; i < stages.length;i++) {
			//  최대 5 스테이지 까지.

			map.put(stages[i], map.getOrDefault(stages[i],0)+1);
		}

		Map<Integer,Float>map2 = new HashMap<>(); //  맵당 인원 정리

		//  실패율 계산
		for(int i = 1; i <= N; i++) {
			float fail = (float)map.getOrDefault(i,0)/player;
			map2.put(i,fail);
			player -= map.getOrDefault(i,0);
		}

		float[][] arr = new float[N][2]; //  스테이지당 실패율

		for(int i = 0; i < N; i++) {
			float fail = map2.getOrDefault(i + 1, 0f);
			arr[i][0] = i+1; // 스테이지
			arr[i][1] = fail; // 실패율 정수화 값
		}

		//  실패율 별로 정렬
		for(int i = 0; i < N-1; i++) {
			for(int j = i+1; j < N; j++) {
				if(arr[i][1] < arr[j][1] ||
					(arr[i][1] == arr[j][1] &&
						arr[i][0] > arr[j][0])) {
					float tmpS = arr[i][0];
					float tmpF = arr[i][1];
					arr[i][0] = arr[j][0];
					arr[i][1] = arr[j][1];
					arr[j][0] = tmpS;
					arr[j][1] = tmpF;
				}
			}
		}

		for(int i = 0; i < N; i++) {
			answer[i] = (int)arr[i][0];
		}

		return answer;
	}
}
