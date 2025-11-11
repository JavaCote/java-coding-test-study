import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());

        for (String op : operations) {
            String[] parts = op.split(" ");
            String cmd = parts[0];
            int num = Integer.parseInt(parts[1]);

            if (cmd.equals("I")) {
                minQ.offer(num);
                maxQ.offer(num);
            } else if (cmd.equals("D")) {
                if (minQ.isEmpty() || maxQ.isEmpty()) continue;

                if (num == 1) { // 최댓값 삭제
                    int max = maxQ.poll();
                    minQ.remove(max);
                } else { // 최솟값 삭제
                    int min = minQ.poll();
                    maxQ.remove(min);
                }
            }
        }

        if (minQ.isEmpty() || maxQ.isEmpty()) return new int[]{0, 0};
        return new int[]{maxQ.peek(), minQ.peek()};
    }
}
