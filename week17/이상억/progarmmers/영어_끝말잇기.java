/**
 * PackageName : week17.이상억.progarmmers;
 * FileName    : 영어_끝말잇기
 * Author      : sangeok
 * Date        : 2025. 08. 20.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 08. 20.     sangeok               Initial creation
 */

import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {

        Set<String> word_set = new HashSet<>();

        word_set.add(words[0]);

        for(int i = 1 ; i < words.length; i ++){
            String prev = words[i-1];
            String curr = words[i];

            if(word_set.contains(curr) || prev.charAt(prev.length() - 1) != curr.charAt(0)){
                return new int[]{(i%n) +1, (i/n) + 1};
            }
            word_set.add(words[i]);
        }

        return new int[]{0,0};
    }
}