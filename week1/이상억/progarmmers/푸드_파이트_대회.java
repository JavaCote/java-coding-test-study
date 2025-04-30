package week1.이상억.progarmmers;

/**
 * PackageName : week1.이상억.programmers
 * FileName    : 푸드_파이트_대회
 * Author      : sangeok
 * Date        : 2025. 4. 30.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 4. 30.     sangeok               Initial creation
 */

class Solution {
    public String solution(int[] food) {

        StringBuilder sb = new StringBuilder();

        for(int i = 1 ; i<food.length; i++){
            for(int j = 0 ; j<(food[i]/2); j++){
                sb.append(i);
            }
        }

        String a = sb.toString() + '0';
        String b = sb.reverse().toString();


        return a+b;
    }
}