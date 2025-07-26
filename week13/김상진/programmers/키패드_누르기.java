package week13.김상진.programmers;

import java.util.HashMap;
import java.util.Map;


public class 키패드_누르기 {
    import java.util.*;

    class Solution {
        private Map<Integer, int[]> keyPadCoords = new HashMap<>();

        public Solution() {
            keyPadCoords.put(1, new int[]{0, 0});
            keyPadCoords.put(2, new int[]{0, 1});
            keyPadCoords.put(3, new int[]{0, 2});
            keyPadCoords.put(4, new int[]{1, 0});
            keyPadCoords.put(5, new int[]{1, 1});
            keyPadCoords.put(6, new int[]{1, 2});
            keyPadCoords.put(7, new int[]{2, 0});
            keyPadCoords.put(8, new int[]{2, 1});
            keyPadCoords.put(9, new int[]{2, 2});
            keyPadCoords.put(0, new int[]{3, 1});
        }

        public String solution(int[] numbers, String hand) {
            StringBuilder answer = new StringBuilder();

            int[] leftHandPos = {3, 0};
            int[] rightHandPos = {3, 2};

            for (int number : numbers) {
                if (number == 1 || number == 4 || number == 7) {
                    answer.append("L");
                    leftHandPos = keyPadCoords.get(number);
                } else if (number == 3 || number == 6 || number == 9) {
                    answer.append("R");
                    rightHandPos = keyPadCoords.get(number);
                } else {
                    int[] targetPos = keyPadCoords.get(number);

                    int leftDist = getManhattanDistance(leftHandPos, targetPos);
                    int rightDist = getManhattanDistance(rightHandPos, targetPos);

                    if (leftDist < rightDist) {
                        answer.append("L");
                        leftHandPos = targetPos;
                    } else if (rightDist < leftDist) {
                        answer.append("R");
                        rightHandPos = targetPos;
                    } else {
                        if (hand.equals("left")) {
                            answer.append("L");
                            leftHandPos = targetPos;
                        } else {
                            answer.append("R");
                            rightHandPos = targetPos;
                        }
                    }
                }
            }

            return answer.toString();
        }

        private int getManhattanDistance(int[] pos1, int[] pos2) {
            return Math.abs(pos1[0] - pos2[0]) + Math.abs(pos1[1] - pos2[1]);
        }
    }

}
