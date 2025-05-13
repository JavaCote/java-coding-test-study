package week3.이상억.progarmmers;

/**
 * PackageName : week3.이상억.progarmmers;
 * FileName    : k번째_수
 * Author      : sangeok
 * Date        : 2025. 5. 12.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 5. 12.     sangeok               Initial creation
 */

// 문제 요구사항 :
// i = a , j = b , k = 3 -> array  a-b 까지 자름 => 자른 array의 [c]의 인덱스

// 접근 방식 : (1)
// 1) commands 배열을 순회하면서 각 명령어 [i, j, k]에 접근
// 2) 주어진 i ~ j 구간을 array에서 잘라 ArrayList에 저장
// 3) list를 정렬한 후 k번째 값을 answer[i]에 저장


// 회고 : Arrays.copyOfRange() -> 쓰면 코드 더 간단 해짐
// int[] newArray = Arrays.copyOfRange(originalArray, from, to);

import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        // 배열 값 순회
        for (int i = 0; i < commands.length; i++) {
            ArrayList<Integer> list = new ArrayList<>();

            // commands[i][0] - commands[i][1] 값으로 array 잘라 arraylist에 저장
            for (int j = commands[i][0] - 1; j <= commands[i][1] - 1; j++) {
                list.add(array[j]);
            }

            // list 정렬 후 k 번째 값 answer에 저장
            Collections.sort(list);
            answer[i] = list.get(commands[i][2] - 1);
        }

        return answer;
    }
}
