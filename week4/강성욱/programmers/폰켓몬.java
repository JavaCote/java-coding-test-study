package week4.강성욱.programmers;

public class 폰켓몬 {
    //핵심은, 최대 N/2 마리가 정답임
    //가장 중복없이 많이 가져가는게 문제임
    //그럼
    class Solution {
        public int solution(int[] nums) {
            boolean[] visited = new boolean[200001];
            int count = 0;

            for (int num : nums) {
                if (!visited[num]) {
                    visited[num] = true;
                    count++;
                }
            }

            int max = nums.length / 2;
            return max > count ? count : max;
        }
    }
}
