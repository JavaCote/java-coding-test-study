package week7.김나은.programmers;

public class 예상_대진표 {

    class Solution {

        public int solution(int n, int a, int b) {
            int round = 0; // 현재 라운드 수를 저장 (처음은 0)

            // 두 참가자의 번호가 같아질 때까지 반복 (같아지면 같은 경기를 하게 되는 것)
            while (a != b) {
                // 다음 라운드에서의 번호는 (현재 번호 + 1) / 2
                // 예: 1번과 2번은 1, 3번과 4번은 2로 매칭됨

                a = (a + 1) / 2; // a의 다음 라운드 번호
                b = (b + 1) / 2; // b의 다음 라운드 번호

                round++; // 한 라운드 진행
            }

            // a와 b가 같은 번호가 되는 시점이 둘이 붙는 라운드
            return round;
        }
    }
}
