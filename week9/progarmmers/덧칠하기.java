/**
 * PackageName : week9.이상억.progarmmers;
 * FileName    : 덧칠하기
 * Author      : sangeok
 * Date        : 2025. 6. 25.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 6. 25.     sangeok               Initial creation
 */

// 문제 풀 때 중간에 덧칠되는 부분을 고려 안하고 차례대로 하는 방향으로 했어서 실패했다. 그 후 칠해진 부분은 스킵하는 방식으로 문제를 해결
    // 문제 설명을 보다가 너무 길어서 입출력 예제를 보고 이해해서 풀었다. 그림을 보는게 훨씬 이해가 잘간다.


class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int len = section.length;
        int i = 0;

        while( i < len){
            int start = section[i];
            int end = start + m - 1;
            answer ++;

            while( i < section.length && section[i] <= end) i++; // 이미 색칠된 부분
        }
        return answer;
    }
}