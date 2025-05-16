package week4.이상억.progarmmers;

/**
 * PackageName : week4.이상억.progarmmers;
 * FileName    : 과일_장수
 * Author      : sangeok
 * Date        : 2025. 5. 16.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 5. 16.     sangeok               Initial creation
 */

// 문제 요구사항 : 	사과 상태에 따른 점수 1~k 점 / 한 상자 가격 : (1~k) * m ( 사과의 갯수 )
//        최대 사과 점수 : k , 한 상자의 들어가는 사과 개수 : m , 사과의 점수 :score

//        접근 방식 : (1)
//                     1) 정렬하고 m 간격으로 해서 돌리면 되겠다.


import java.util.Arrays;
class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;

        Arrays.sort(score);
        for(int i = score.length-m; i>=0; i-=m){
            answer += score[i] * m;
        }

        return answer;
    }
}