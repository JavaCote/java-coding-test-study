package week2.이상억.progarmmers;

/**
 * PackageName : week2.이상억.programmers
 * FileName    : 기능개발
 * Author      : sangeok
 * Date        : 2025. 5. 6.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 5. 6.     sangeok               Initial creation
 */
import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        int len = speeds.length;
        int[] days = new int[len];

        for(int i = 0; i<len; i++){
            int remain = 100 - progresses[i];
            days[i] = (remain + speeds[i] - 1) / speeds[i];
        }

        int count = 1;
        int maxday = days[0];

        for(int i = 1; i<len; i++){
            if(days[i]>maxday){
                answer.add(count);
                count = 1;
                maxday = days[i];
            }
            else {
                count ++;
            }
        }

        answer.add(count);
        return answer;
    }
}