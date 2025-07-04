package week5.김상진.programmers;

/**
 * PackageName : week5.김상진.programmers
 * FileName    : 붕대_감기
 * Author      : sangxxjin
 * Date        : 2025. 5. 26.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 5. 26.     sangxxjin               Initial creation
 */
public class 붕대_감기 {
	// 문제의 논리를 정확히 이해하면 어렵지 않은 문제.
	class Solution {
		public int solution(int[] bandage, int health, int[][] attacks) {
			//연속된 카운트
			int sequenceCount = 0;
			// 공격 index
			int attackIdx = 0;
			// 최대 체력
			int maxHP = health;
			// attacks는 공격시간 기준 오름차순 즉 최종 공격시간까지 계산
			for(int i=0; i <= attacks[attacks.length-1][0]; i++){
				// 공격 타이밍이면 피 깍고 attackIdx증가, 회복횟수 초기화,  피가 0이하면 1 리턴
				if(i==attacks[attackIdx][0]){
					health-=attacks[attackIdx++][1];
					sequenceCount=0;
					if(health<=0)return -1;
				}
				else{

					// 공격받지 않으면 1회 증가
					sequenceCount++;
					// 기본 회복 값 증가
					health+=bandage[1];
					// 연속회복횟수가 시전시간과 같으면 회복 횟수 초기화 및 추가 회복량 회복
					if(sequenceCount==bandage[0]){
						sequenceCount=0;
						health+=bandage[2];
					}
					if(health>maxHP)health = maxHP;
				}
			}
			return health;
		}
	}
}
