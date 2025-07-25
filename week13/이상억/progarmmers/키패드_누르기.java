/**
 * PackageName : week13.이상억.progarmmers;
 * FileName    : 키패드_누르기
 * Author      : sangeok
 * Date        : 2025. 07. 22.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 07. 22.     sangeok               Initial creation
 */


// 왼쪽 1,4,7 이면 left 3,6,9면 오른손, 2,5,8,0이면 더 가까운 엄지, 거리가 같다면 오른손은 오른손 엄지 왼손은 왼손
// 1 2 3
// 4 5 6
// 7 8 9
// * 0 #

// 1 3 4 5 8 2 1 4 5 9 5
// L R L L L R L L R R L


import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();

        // 고정 위치
        Map<Integer, String> fixedHand = new HashMap<>();
        fixedHand.put(1, "L");
        fixedHand.put(4, "L");
        fixedHand.put(7, "L");
        fixedHand.put(3, "R");
        fixedHand.put(6, "R");
        fixedHand.put(9, "R");

        // 초기 위치: 왼손은 *, 오른손은 #
        int left = 10;  // *를 10으로, 0은 11, #은 12로 정의
        int right = 12;

        for (int num : numbers) {
            if (fixedHand.containsKey(num)) {
                // 고정 위치 숫자
                String used = fixedHand.get(num);
                answer.append(used);
                if (used.equals("L")) left = num;
                else right = num;
            } else {

                int lDist = distance(left, num);
                int rDist = distance(right, num);

                if (lDist < rDist) {
                    answer.append("L");
                    left = num;
                } else if (lDist > rDist) {
                    answer.append("R");
                    right = num;
                } else {
                    if (hand.equals("right")) {
                        answer.append("R");
                        right = num;
                    } else {
                        answer.append("L");
                        left = num;
                    }
                }
            }
        }

        return answer.toString();
    }

    // 거리 계산 함수
    private int distance(int from, int to) {

        if (from == 0) from = 11;
        if (to == 0) to = 11;

        int fromX = (from - 1) / 3;
        int fromY = (from - 1) % 3;
        int toX = (to - 1) / 3;
        int toY = (to - 1) % 3;

        return Math.abs(fromX - toX) + Math.abs(fromY - toY);
    }
}
