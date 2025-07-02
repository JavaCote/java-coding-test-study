import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        List<Integer> list = new ArrayList<>();

        int[] player = new int[3];
        int[] one = {1, 2, 3, 4, 5}; // 길이 5
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5}; // 길이 8
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}; // 길이 10

        for (int i = 0; i < answers.length; i++) {
            if (one[i % one.length] == answers[i]) player[0]++;
            if (two[i % two.length] == answers[i]) player[1]++;
            if (three[i % three.length] == answers[i]) player[2]++;
        }

        int max = Math.max(player[0], Math.max(player[1], player[2]));

        for (int i = 0; i < 3; i++) {
            if (player[i] == max) {
                list.add(i + 1); // 1번, 2번, 3번
            }
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
