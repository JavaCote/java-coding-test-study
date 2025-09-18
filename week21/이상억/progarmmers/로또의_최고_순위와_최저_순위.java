/**
 * PackageName : week21.이상억.progarmmers;
 * FileName    : 로또의_최고_순위와_최저_순위
 * Author      : sangeok
 * Date        : 2025. 09. 15.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 09. 15.     sangeok               Initial creation
 */

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