/**
 * PackageName : week17.이상억.progarmmers;
 * FileName    : 행렬의_곱셈
 * Author      : sangeok
 * Date        : 2025. 08. 20.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 08. 20.     sangeok               Initial creation
 */


//  arr1    arr2        return
//  1 4     3 3         1 * 3 + 4 * 3 => arr1[0][0] * arr2[0][0] + arr1[0][1] * arr2[1][0]
//  3 2     3 3                          arr1[0][0] * arr2[0][1] + arr1[0][1] * arr2[1][1]
//  4 1

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];

        for(int i = 0; i < arr1.length; i++){
            for(int j = 0; j < arr2[0].length; j++){
                int sum = 0;
                for (int k = 0; k < arr1[0].length; k++) {   // 공통 차원
                    sum += arr1[i][k] * arr2[k][j];
                }
                answer[i][j] = sum;
            }
        }

        return answer;
    }
}