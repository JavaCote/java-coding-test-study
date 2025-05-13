package week3.이상억.progarmmers;

/**
 * PackageName : week3.이상억.progarmmers;
 * FileName    : 다음_큰_숫자
 * Author      : sangeok
 * Date        : 2025. 5. 12.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 5. 12.     sangeok               Initial creation
 */

// 문제 요구사항 :
// 1) n보다 큰 자연수여야 함
// 2) 2진수에서 1의 개수가 n과 같아야 함

// 접근 방식 : (1)
// 1) n을 2진법으로 바꾸는 과정에 1의 갯수 세기
// 2) 그 다음 숫자 증가
// 3) 증가 시키는 숫자의 1의 갯수가 n 과 똑같으면 반환

// 회고 : Integer.bitCount(int n)
// 이 함수는 주어진 정수 n을 2진수로 변환한 뒤, 1의 개수를 반환
class Solution {
    public int solution(int n) {
        int n_bit = 0;
        int number = n;

        // n의 1의 갯수 세기
        while (number > 0) {
            if (number % 2 == 1) n_bit++;
            number /= 2;
        }
        // n 보다 큰 다음 숫자
        int next = n + 1;

        // n 다음 숫자 찾기 위한 반복문
        while (true) {
            int next_bit = 0;
            int t = next;
            // n 보다 큰 다음 숫자 1의 갯수 구하기
            while (t > 0) {
                if (t % 2 == 1) next_bit++;
                t /= 2;
            }

            if (next_bit == n_bit) return next;

            next++;
        }
    }
}
