/**
 * PackageName : week14.이상억.progarmmers;
 * FileName    : 테이블_해시_함수
 * Author      : sangeok
 * Date        : 2025. 07. 28.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 07. 28.     sangeok               Initial creation
 */

// 해시 함수는 col, row_begin, row_end 입력 받음
// col 번째 컬럼을 기준으로 오름차순 정렬, 그 값이 동일하면 기본키인 첫 번째 칼럼의 기준으로 내림차순 정렬
// 정렬된 데이터에서 S_i를 i 번째 행의 튜플에 대해 각 칼럼의 값을 i 로 나눈 나머지들의 합으로 정의
// row_begin <= i <= row_end 인 모든 S_i를 누적하여 bitwise xor 한 값을 해시값으로 반환



import java.util.Arrays;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {

        Arrays.sort(data, (a, b) -> {
            if (a[col - 1] != b[col - 1]) {
                return Integer.compare(a[col - 1], b[col - 1]);  // col 기준 오름차순
            } else {
                return Integer.compare(b[0], a[0]);  // 첫 번째 컬럼 내림차순
            }
        });

        int xor = 0;


        for (int i = row_begin; i <= row_end; i++) {
            int sum = 0;
            for (int a : data[i - 1]) { // i번째 행은 data[i - 1]에 위치
                sum += a % i;
            }
            xor ^= sum;
        }

        return xor;
    }
}
