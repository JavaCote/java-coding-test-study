package week21.김나은.programmers;

public class 로또의_최고_순위와_최저_순위 {

    class Solution {

        public int[] solution(int[] lottos, int[] win_nums) {
            int[] answer = new int[2];

            // lottos에 win_nums와 일치하는 번호 개수
            int count = 0;
            // lottos 0의 개수
            int zero = 0;

            // lottos 배열의 각 번호를 확인
            for (int i = 0; i < lottos.length; i++) {
                if (lottos[i] == 0) {
                    zero++;
                    continue; // 다음 번호 확인
                }
                // 번호가 0이 아닌 경우, 당첨 번호(win_nums)와 비교
                for (int j = 0; j < win_nums.length; j++) {
                    if (win_nums[j] == lottos[i]) {
                        count++;
                        continue;
                    }
                }
            }

            answer[0] = rank(count + zero);
            answer[1] = rank(count);

            return answer;
        }

        // 맞춘 번호 개수에 따라 순위를 반환하는 메서드
        private static int rank(int num) {
            if (num == 6) {
                return 1; // 6개 맞추면 1등
            } else if (num == 5) {
                return 2; // 5개 맞추면 2등
            } else if (num == 4) {
                return 3;
            } else if (num == 3) {
                return 4;
            } else if (num == 2) {
                return 5;
            } else {
                return 6;
            }
        }
    }
}