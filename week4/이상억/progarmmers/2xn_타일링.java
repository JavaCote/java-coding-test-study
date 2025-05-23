package week5.이상억.progarmmers;

/**
 * PackageName : week5.이상억.progarmmers;
 * FileName    : 예산
 * Author      : sangeok
 * Date        : 2025. 5. 22.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 5. 22.     sangeok               Initial creation
 */


// 문제 요구사항 	: 가로 길이 => 2, 세로 길이 => 1 인 직사각형 모양 타일
// 이 직사각형을 이용해 새로운 길이가 2이고 가로 길이 n 인 바닥을 가득 채우려고 함

// 접근 방식 : (1) 이거 피보나치 수열 아닌가 ?

class Solution {
    public int solution(int n) {
        int answer = 0;

        int[] a = new int[n+1];

        if(n==0) return 0;
        if(n==1) return 1;
        if(n==2) return 2;

        a[0] = 0;
        a[1] = 1;
        a[2] = 2;
        for(int i = 3; i < n + 1; i++){
            a[i] = (a[i-1] + a[i-2]) % 1000000007 ;

        }
        answer = a[n] ;
        return answer;
    }
}