/**
 * PackageName : week15.이상억.progarmmers;
 * FileName    : 쿼드_압축_후_개수_세기
 * Author      : sangeok
 * Date        : 2025. 08. 07.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 08. 07.     sangeok               Initial creation
 */

class Solution {
    int[] answer = new int[2]; // [0의 개수, 1의 개수]

    public int[] solution(int[][] arr) {
        compress(arr, 0, 0, arr.length);
        return answer;
    }

    void compress(int[][] arr, int x, int y, int size) {
        if (isAllSame(arr, x, y, size)) {
            answer[arr[x][y]]++; // 0 또는 1 중 하나
            return;
        }

        int newSize = size / 2;
        compress(arr, x, y, newSize);                   // 왼쪽 위
        compress(arr, x + newSize, y, newSize);         // 오른쪽 위
        compress(arr, x, y + newSize, newSize);         // 왼쪽 아래
        compress(arr, x + newSize, y + newSize, newSize); // 오른쪽 아래
    }

    boolean isAllSame(int[][] arr, int x, int y, int size) {
        int value = arr[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[i][j] != value) return false;
            }
        }
        return true;
    }
}
