package week4.김누리.programmers;

/**
 * PackageName : week4.김누리.programmers
 * FileName    : 체육복
 * Author      : 김누리(NRKim)
 * Date        : 2025-05-17
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 05. 17.     김누리(NRKim)               Initial creation
 */

/*
    case 1 :
    총원 5인(n == 5)
    체육복 = (1=1,2=1,3=1,4=1,5=1) // 1 ~ 5번 까지
    int[] idxs = new int[n];
    lost 학생 = 2,4 ==> 체육복 (1=1,2=0,3=1,4=0,5=1)
    reserve idx = 1, 3, 5 ==> 체육복 (1=2,2=0,3=2,4=0,5=2)

    idx 배열 하나 생성
    for(int i = n; i > 0; i--) {
        idxs[i] = n; //  {1,2,3,4,5}
    }

    1번 째 반복문 n만큼 반복
    for(int i : idxs) {
        //  타겟 idx의 학생의 체육복이 분실, 그리고 이전 idx의 학생이 여분의 체육복이 있는 경우
        if(i != 1 && 체육복.get(i) == 0 && 체육복.get(i-1) > 1 ) {
            체육복.put(i,체육복.getOrDefault(i,0)+1);
            체육복.put(i-1,체육복.getOrDefault(i-1,0)-1);
        }

        //  타겟 idx의 학생의 체육복이 분실, 그리고 다음 idx의 학생이 여분의 체육복이 있는 경우
        if(i != n && 체육복.get(i) == 0 && 체육복.get(i+1) > 1 ) {
            체육복.put(i,체육복.getOrDefault(i,0)+1);
            체육복.put(i+1,체육복.getOrDefault(i+1,0)-1);
        }
    }
*/

import java.util.*;

public class 체육복 {
	public int solution(int n, int[] lost, int[] reserve) {
		int answer = 0;
		int[] idxs = new int[n]; // 학생 번호가 들어갈 배열
		Map<Integer,Integer> clothes = new HashMap<>(); //  학생의 체육복을 관리하기 위함.

		//  idxs 배열 초기화
		for(int i = 0; i < n; i++) {
			idxs[i] = i+1;
		}

		//  체육복 map 초기화
		for(int i : idxs) {
			clothes.put(i,1);
		}

		//  분실된 학생의 체육복은 --
		for (int l : lost) {
			clothes.put(l,clothes.getOrDefault(l,0)-1);
		}

		//  여분이 있는 학생의 체육복은 ++
		for (int r : reserve) {
			clothes.put(r,clothes.getOrDefault(r,0)+1);
		}

		//  체육복 빌리는 작업 진행
		for(int i : idxs) {
			//  타겟 idx의 학생의 체육복이 분실, 그리고 이전 idx의 학생이 여분의 체육복이 있는 경우
			if (i !=1 && clothes.get(i) == 0 && clothes.getOrDefault(i-1, 0) > 1) {
				clothes.put(i,clothes.getOrDefault(i,0)+1);
				clothes.put(i-1,clothes.getOrDefault(i-1,0)-1);
			}

			//  타겟 idx의 학생의 체육복이 분실, 그리고 다음 idx의 학생이 여분의 체육복이 있는 경우
			if (i !=n && clothes.get(i) == 0 && clothes.getOrDefault(i+1, 0) > 1) {
				clothes.put(i,clothes.getOrDefault(i,0)+1);
				clothes.put(i+1,clothes.getOrDefault(i+1,0)-1);
			}
		}

		for(int i : idxs) {
			if (clothes.get(i) != 0) answer++;
		}

		return answer;
	}
}
