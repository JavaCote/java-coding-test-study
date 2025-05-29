/**
 * PackageName : week5.이상억.progarmmers;
 * FileName    : 붕대_감기
 * Author      : sangeok
 * Date        : 2025. 5. 29.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 5. 29.     sangeok               Initial creation
 */


// 문제 요구사항 :	t초 동안 붕대를 감으면 1초마다 x 체력회복
// t초 연속 붕대를 감는다면 y 만큼 최력 추가 회복
// 최대 체력 만큼 체력을 추가 회복하는건 불가
// 공격 당하면 취소고 0초부터 다시
// 몬스터 공격 받으면 => 정해진 피해량 만큼 체력 줄어듬 0 이하 체력 되면 체력 회복 x
//			"bandage" => 붕대 감기 시전 시간, 1초당 회복량, 추가 회복량 / 1 demension
//			"health" => 최대 체력
//			"attacks" => 몬스터의 공격 시간 및 피해량  / 2 demension
// 공격 다 받고 죽으면 -1

// 접근 방식 : (1)

// 회고 : 공격 시점에도 회복을 하고 있어 값이 제대로 나오지 않았다. 그래서 -1 을 해 해결 하였다.
    // 또한 나는 문제가 회복을 시전시간이 다 되야 회복 되는거로 이해하고 풀어서 시간을 좀 버렸었다..

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int currenttime = 0;
        int recoverytime = 0;
        int maxHealth = health;

        for (int i = 0; i < attacks.length; i++) {
            int attacktime = attacks[i][0];
            int time = attacktime - currenttime-1;

            for (int j = 0; j < time; j++) {
                health += bandage[1];
                recoverytime++;
                if (recoverytime == bandage[0]) {
                    health += bandage[2];
                    recoverytime = 0;
                }

                if (health > maxHealth) health = maxHealth;
            }

            health -= attacks[i][1];
            if (health <= 0) return -1;

            recoverytime = 0;
            currenttime = attacktime;
        }
        return health;
    }
}
