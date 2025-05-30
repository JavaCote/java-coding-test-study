package week5.강성욱.programmers;

public class 붕대감기 {
    class Solution {
        public int solution(int[] bandage, int health, int[][] attacks) {
            int maxHp = health;
            int nowHp = health;

            //공격받지 않은 횟수
            // == bandage[0] 과 동일하면, bandage[2] 만큼 추가 회복, 단, 최대 maxHp 를 넘을 순 없음.
            int nonAttackCount = 0;

            int bandageCastingTime = bandage[0];
            int bandageHealPerSec = bandage[1];
            int bandageHealAdd = bandage[2];
            int lastAttackTime = 0;

            for(int[] attack : attacks) {
                int attackTime = attack[0]; //공격 시간
                int attackDamage = attack[1]; //피해량
                int timeGap = attackTime - lastAttackTime - 1; // 이전 공격 ~ 이번 공격까지의 시간 차이. 이만큼 회복할 예정

                // 시간 차이가 나면, 우선 회복
                if (timeGap > 0) {
                    int fullCasts = (nonAttackCount + timeGap) / bandageCastingTime;
                    int nextCount = nonAttackCount + timeGap;

                    // 회복 1초당 적용 (연속 카운트도 계속)
                    for (int t = 1; t <= timeGap; t++) {
                        nonAttackCount++;
                        nowHp += bandageHealPerSec;
                        if (nonAttackCount == bandageCastingTime) {
                            nowHp += bandageHealAdd;
                            nonAttackCount = 0;
                        }
                        if (nowHp > maxHp) nowHp = maxHp;
                    }
                }

                // 공격 진행
                nowHp -= attackDamage;
                if (nowHp <= 0) return -1; // 죽었으면 -1 리턴
                nonAttackCount = 0; // 연속 성공 카운트 초기화
                lastAttackTime = attackTime; // 마지막 공격 시각 업데이트
            }
            return nowHp;
        }
    }
}
