package week12.김상진.programmers;

public class 퍼즐_게임_챌린지 {
    class Solution {
        // 퍼즐 난이도, 소요 시간, 전체 제한 시간은 전역 변수로 접근할 수 있도록 저장
        private int[] diffs;
        private int[] times;
        private long limit;

        public int solution(int[] diffs, int[] times, long limit) {
            this.diffs = diffs;
            this.times = times;
            this.limit = limit;

            // 이분 탐색 범위 설정
            // level의 최소값은 1
            // level의 최대값은 100,000 (diffs[i]의 최대값) + 1 (이 값을 넘으면 무조건 틀리지 않음)
            int low = 1;
            int high = 100001; // diffs[i] 최대값 100,000 + 1 (넉넉하게 설정)
            int answer = high; // 가능한 최소 level을 찾기 위해 초기값은 high로 설정

            // 이분 탐색 시작
            while (low <= high) {
                int mid = low + (high - low) / 2; // 중간 level 값

                // 현재 mid level로 모든 퍼즐을 풀 수 있는지 확인
                if (canSolveAllPuzzles(mid)) {
                    answer = mid;       // mid level로 해결 가능하므로, 더 낮은 level을 시도
                    high = mid - 1;
                } else {
                    low = mid + 1;      // mid level로 해결 불가능하므로, 더 높은 level을 시도
                }
            }

            return answer;
        }

        // 주어진 level로 모든 퍼즐을 제한 시간 내에 해결할 수 있는지 판단하는 함수
        private boolean canSolveAllPuzzles(int currentLevel) {
            long totalTime = 0;
            long timePrev = 0; // 이전 퍼즐의 소요 시간 (long으로 유지)

            for (int i = 0; i < diffs.length; i++) {
                long diff = diffs[i];     // 현재 퍼즐 난이도 (long으로 캐스팅)
                long timeCur = times[i];  // 현재 퍼즐 소요 시간 (long으로 캐스팅)

                if (diff <= currentLevel) {
                    // 숙련도가 난이도 이상이면 틀리지 않고 timeCur만 소요
                    totalTime += timeCur;
                } else {
                    // 숙련도가 난이도 미만이면 틀림
                    long wrongCount = diff - currentLevel; // 틀린 횟수
                    // (현재 퍼즐 소요 + 이전 퍼즐 소요) * 틀린 횟수 + 현재 퍼즐 소요
                    // 모든 계산 과정에서 long 타입 사용을 명확히 함
                    totalTime += (timeCur + timePrev) * wrongCount + timeCur;
                }

                // 다음 퍼즐을 위해 현재 퍼즐의 소요 시간을 timePrev로 저장
                timePrev = timeCur;

                // 중간에라도 총 시간이 제한 시간을 초과하면 바로 false 반환 (가지치기)
                if (totalTime > limit) {
                    return false;
                }
            }

            // 모든 퍼즐을 해결했고, 총 시간이 제한 시간 이내이면 true
            return true;
        }
    }

}
