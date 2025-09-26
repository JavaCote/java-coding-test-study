import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;

        Queue<int[]> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        q.add(new int[]{x,0});
        visited.add(x);

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int value = cur[0];
            int count = cur[1];

            if(value == y){
                return count;
            }

            int[] next_value = {value + n, value * 2, value * 3};

            for(int next : next_value){
                if(next <= y && !visited.contains(next)){
                    visited.add(next);
                    q.add(new int[]{next, count + 1});
                }
            }
        }

        return -1;
    }
}