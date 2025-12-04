import java.util.*;

class Solution {
    public int solution(int n, int[][] q, int[] ans) {
        int answer = 0;

        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) numbers[i] = i + 1;

        whgkq(numbers, new ArrayList<>(), q, ans, 0);

        answer = validcount;
        return answer;
    }

    int validcount = 0;

    public void whgkq(int[] numbers, List<Integer> current, int[][] q, int[] ans, int idx) {
        if (current.size() == 5) {
            if (isvalid(current, q, ans)) validcount++;
            return;
        }
        if (idx >= numbers.length) return;

        current.add(numbers[idx]);
        whgkq(numbers, current, q, ans, idx + 1);

        current.remove(current.size() - 1);
        whgkq(numbers, current, q, ans, idx + 1);
    }

    public boolean isvalid(List<Integer> current, int[][] q, int[] ans) {
        Set<Integer> set = new HashSet<>(current);

        for (int i = 0; i < q.length; i++) {
            int count = 0;
            for (int k : q[i]) {
                if (set.contains(k)) count++;
            }

            if (ans[i] != count) return false;
        }
        return true;
    }
}
