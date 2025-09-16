import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {

        int correct = 0;
        int zero = 0;

        Set<Integer> set = new HashSet<>();

        for(int i : win_nums) set.add(i);

        for(int i : lottos){
            if(i==0) zero++;
            else if(set.contains(i)) correct ++;
        }

        int best = 7 - (correct + zero);
        int worst = 7 - correct;

        if(best > 6) best = 6;
        if(worst > 6) worst =  6;

        return new int[]{best,worst};
    }
}