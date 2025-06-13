/**
 * PackageName : week7.이상억.progarmmers;
 * FileName    : 택배_상자_꺼내기
 * Author      : sangeok
 * Date        : 2025. 6. 11
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 6. 11.     sangeok               Initial creation
 */

//접근 방식 :
//		1) 우선 해당 박스의 층? row 를 구해야 함
//		2) w로 나누어진다면 그 층에 마지막 박스
//		3) 층이 홀수 일 때 왼->오 // 짝수일 때 오->왼 //

public class Solution {
    public int solution(int n, int w, int num) {
        int row = (num - 1) / w;
        int col = (row % 2 == 0) ? (num - 1) % w : w - 1 - (num - 1) % w;
        int lastrow = (n-1) / w;

        int count = 0;
        for (int r = row; r <=lastrow ; r++) {
            int start = r * w + 1;
            int end = (r + 1) * w ;
            int index;

            if (r % 2 == 0) {
                index = start + col;
            } else {
                index = end - col;
            }

            if (index <= n) {
                count++;
            }
        }

        return count;
    }
}