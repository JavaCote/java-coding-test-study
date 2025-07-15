import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {


    }

    public void dfs(int level, int[] diffs, int times){
        if()
    }

    public int cleartime(int level, int diff, int time, int prevTime) {
        if (diff <= level) {
            return time;
        } else {
            return (time + prevTime) * (diff - level) + time;
        }
    }
}
