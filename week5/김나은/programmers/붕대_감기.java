package week5.김나은.programmers;

public class 붕대_감기 {

    class Solution {

        public int solution(int[] bandage, int health, int[][] attacks) {
            // bandage[0] = 시전 시간
            // bandage[1] = 초당 회복량
            // bandage[2] = 추가 회복량 (연속 시전 성공 시)

            int cnt = bandage[0];  // 추가 체력을 얻기 위한 연속 시전 시간
            int now = health;      // 현재 체력
            int std = 0;           // 마지막 공격 시점 (기준 시간)

            int v1, v2; // 회복 가능한 시간, 추가 회복 횟수

            // 각 공격에 대해 순차적으로 처리
            for (int[] atk : attacks) {
                if (now <= 0) {
                    return -1; // 체력이 0 이하가 되면 게임 오버
                }

                v1 = atk[0] - std - 1; // 이번 공격 전까지 남은 회복 시간
                v2 = v1 / cnt;         // 추가 회복이 몇 번 가능한지 계산

                // 공격 직전까지의 회복량 처리
                // 1. 일반 회복: 초당 회복량 * 시간
                now = Math.min(health, now + (v1 * bandage[1]));

                // 2. 추가 회복: 연속 시전 성공 횟수만큼 추가 체력 회복
                now = Math.min(health, now + (v2 * bandage[2]));

                std = atk[0];     // 기준 시간 갱신
                now -= atk[1];    // 이번 공격으로 체력 감소
            }

            // 마지막 공격 이후의 체력 확인
            return now <= 0 ? -1 : now; // 체력이 0 이하이면 -1, 아니면 남은 체력 반환
        }
    }
}
