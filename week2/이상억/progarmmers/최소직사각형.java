package week2.이상억.progarmmers;

/**
 * PackageName : week2.이상억.programmers
 * FileName    : 최소직사각형
 * Author      : sangeok
 * Date        : 2025. 5. 8.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 5. 8.     sangeok               Initial creation
 */

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;

        for(int i = 0; i<sizes.length; i++){
            if(sizes[i][0] < sizes[i][1]) {
                int temp = sizes[i][1];
                sizes[i][1] = sizes[i][0];
                sizes[i][0] = temp;
            }
        }

        int one = sizes[0][0];
        int two = sizes[0][1];
        for(int i = 1; i < sizes.length; i++){
            one = one > sizes[i][0] ? one : sizes[i][0];
            two = two > sizes[i][1] ? two : sizes[i][1];
        }

        return one * two;

    }
}