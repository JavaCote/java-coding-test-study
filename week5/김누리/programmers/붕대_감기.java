package week5.김누리.programmers;

import java.util.HashMap;
import java.util.Map;

/**
 * PackageName : week5.김누리.programmers
 * FileName    : 붕대_감기
 * Author      : 김누리(NRKim)
 * Date        : 2025-05-29
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 05. 29.     김누리(NRKim)               Initial creation
 */


/*
  단순한 반복 문제

  1.  지속시간 : bandage[0],

  2.  시나리오 시간
    int maxTime = attacks[attacks.length-1][0];


  3.  시나리오 시간만큼 반복하며 힐링 및 데미징 처리
    for (int t = 1; t <= time; t++) {
        //  3-1.  데미지가 들어올 시간 체크
        //  3-2.  데미지가 들어올 시간 >> 데미징
        //  3-3.  데미지가 들어올 시간 X >> 힐링처리
    }0

  4.  처리 이후 리턴처리
    health > 0 ? answer = health : -1;

*/

public class 붕대_감기 {
	public int solution(int[] bandage, int health, int[][] attacks) {
		int answer = 0;
		int last_healing_time = bandage[0];
		int healing = bandage[1];
		int additional_healing = bandage[2];
		int max_time = attacks[attacks.length-1][0];
		int now_hp = health;
		int continuity = 0; //  연속 힐링 체크용 cnt
		Map<Integer,Integer> map = new HashMap<>(); // 데미지 들어올 타이밍을 관리하기 위한 map

		for(int[] a : attacks) {
			map.put(a[0],a[1]);
		}

		//  System.out.println(map);

		for(int i = 1; i <= max_time; i++) {
			//  데미지가 들어올 타이밍 체크
			if (map.containsKey(i)) {
				//  데미징 처리
				now_hp -= map.get(i);
				if(now_hp <= 0 ) {
					// 죽었을 떄
					return -1;
				}
				continuity = 0; //  치료중 데미지를 입었으니 연속 치료 횟수 초기화
			} else {
				//  데미지를 입은 상태
				if (now_hp < health) {
					if (continuity + 1 == last_healing_time) {
						//  연속치료의 마지막 단계
						now_hp += healing + additional_healing;
						continuity = 0; //  붕대 지속시간 다 되었으니 연속 치료 횟수 초기화
					} else {
						//  힐링 처리
						now_hp += healing;
						continuity++;
					}
				}

				//  현재 hp와 총 hp 비교해서 최소값을 현재 hp로
				now_hp = Math.min(now_hp, health);
			}
		}

		answer = now_hp;

		return answer;
	}
}
