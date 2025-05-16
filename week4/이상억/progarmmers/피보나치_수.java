package week4.이상억.progarmmers;

/**
 * PackageName : week4.이상억.progarmmers;
 * FileName    : 피보나치_수
 * Author      : sangeok
 * Date        : 2025. 5. 16.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 5. 16.     sangeok               Initial creation
 */

// 문제 요구사항 : f(0) = 1 , f(1) = 1 일 때, f(n) = f(n-1) + f(n-2)

// 접근 방법 : (1) 이거 멀리 뛰기랑 똑같은거

class Solution {
    public int solution(int n) {
        int answer = 0;

        int[] a = new int[n+1];

        if(n==0) return 0;
        if(n==1) return 1;

        a[0] = 0;
        a[1] = 1;
        for(int i = 2; i < n + 1; i++){
            a[i] = (a[i-1] + a[i-2]) % 1234567 ;

        }
        answer = a[n] ;
        return answer;
    }
}