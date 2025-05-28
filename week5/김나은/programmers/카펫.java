package week5.김나은.programmers;

public class 카펫 {

    class Solution {

        public int[] solution(int brown, int yellow) {
            int[] answer = new int[2]; // [가로, 세로]를 저장할 배열

            // 전체 격자 수 = brown + yellow
            for (int i = 3; i < brown + yellow; i++) {
                int width = (brown + yellow) / i; // 가로 길이 후보 계산

                // 세로(i) <= 가로(width) 조건을 만족할 때만 진행
                if (width >= i) {

                    // 노란색 영역은 테두리(갈색) 1칸씩 제거한 내부 공간
                    // 즉, (세로 - 2) * (가로 - 2) == yellow 여야 함
                    if ((i - 2) * (width - 2) == yellow) {
                        answer[0] = width; // 가로
                        answer[1] = i;     // 세로
                        break; // 조건을 만족했으므로 반복 종료
                    }
                }
            }

            return answer; // [가로, 세로] 반환
        }
    }
}
