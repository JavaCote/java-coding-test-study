package week4.이상억.progarmmers;

/**
 * PackageName : week4.이상억.progarmmers;
 * FileName    : 숫자의 표현
 * Author      : sangeok
 * Date        : 2025. 5. 16.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 5. 16.     sangeok               Initial creation
 */

//문제 요구사항 : 숫자를 연속된 자연수로 더해 나타낼 수 있는 경우의 수 구하기

// 접근 방법 : (1)
//      1)  while문으로 n == n 까지 돌리고 그
//		2) 안에 list 선언
//		3) 반복문으로 계속 값 더해서 같으면 answer ++ 더 커지면 for문 탈출
//		4) 그 다음 i = a 에 a ++ 하고 sum 값 초기화



class Solution {
    public int solution(int n) {
        int answer = 0;

        int a = 1;
        while(a<=n){
            int sum = 0;
            for(int i = a ; i<=n ; i++){
                sum+=i;
                if(sum == n) answer ++;
                if(sum > n) break;
            }
            a++;
        }
        return answer;
    }
}