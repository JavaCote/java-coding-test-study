/**
 * PackageName : week10.이상억.progarmmers;
 * FileName    : 두_개_뽑아서_더하기
 * Author      : sangeok
 * Date        : 2025. 07. 04.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 07. 04.     sangeok               Initial creation
 */


import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int len = numbers.length;
        Set<Integer> set = new HashSet<>();

        int number = 0;
        for(int i = 0; i <len - 1; i++){
            for(int j = i+1; j < len; j++ ){
                set.add(numbers[i] + numbers[j]);
            }
        }
        int[] answer = new int[set.size()];

        for(int a : set){
            answer[number] = a;
            number++;
        }
        Arrays.sort(answer);
        return answer;
    }
}