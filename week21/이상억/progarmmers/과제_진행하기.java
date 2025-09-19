/**
 * PackageName : week21.이상억.progarmmers;
 * FileName    : 과제_진행하기
 * Author      : sangeok
 * Date        : 2025. 09. 18.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 09. 18.     sangeok               Initial creation
 */


import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        int n = plans.length;
        String[] answer = new String[n];


        int[][] infos = new int[n][3];
        for (int i = 0; i < n; i++) {
            infos[i][0] = i;
            infos[i][1] = htomin(plans[i][1]);
            infos[i][2] = Integer.parseInt(plans[i][2]);
        }

        Arrays.sort(infos, (a, b) -> a[1] - b[1]);

        Stack<int[]> stack = new Stack<>();
        int idx = 0;

        for (int i = 0; i < n - 1; i++) {
            int curIdx = infos[i][0];
            int start = infos[i][1];
            int time = infos[i][2];

            int nextStart = infos[i + 1][1];
            int gap = nextStart - start;

            if (time <= gap) {
                // 현재 과제 끝냄
                answer[idx++] = plans[curIdx][0];
                gap -= time;

                // 스택에서 멈춰둔 과제 이어하기
                while (!stack.isEmpty() && gap > 0) {
                    int[] top = stack.pop();
                    if (top[1] <= gap) {
                        gap -= top[1];
                        answer[idx++] = plans[top[0]][0];
                    } else {
                        top[1] -= gap;
                        stack.push(top);
                        break;
                    }
                }
            } else {
                // 다 못 끝내면 남은 시간을 스택에 저장
                stack.push(new int[]{curIdx, time - gap});
            }
        }

        // 마지막 과제는 무조건 완료
        answer[idx++] = plans[infos[n - 1][0]][0];

        while (!stack.isEmpty()) {
            int[] top = stack.pop();
            answer[idx++] = plans[top[0]][0];
        }

        return answer;
    }

    private int htomin(String s) {
        String[] time = s.split(":");
        int hour = Integer.parseInt(time[0]);
        int minute = Integer.parseInt(time[1]);
        return hour * 60 + minute;
    }
}
