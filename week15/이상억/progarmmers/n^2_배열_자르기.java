/**
 * PackageName : week15.이상억.progarmmers;
 * FileName    : n^2_배열_자르기
 * Author      : sangeok
 * Date        : 2025. 08. 06.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 08. 06.     sangeok               Initial creation
 */

// 1 2 3
// 2 2 3
// 3 3 3

// 0 1 2 3 4 5 6 7 8
// 1 2 3 2 2 3 3 3 3
// left : 2 right : 5

// 2 3 4 5
// 3 2 2 3

import java.util.*;
class Solution {
    public int[] solution(int n, long left, long right) {

        int[] answer = new int[(int)(right - left + 1)];

        List<Integer> list = new ArrayList<>();

        for(long i = left; i <= right; i++){
            long row = i/n;
            long col = i%n;

            answer[(int)(i-left)] = (int)Math.max(row,col) + 1;
        }

        return answer;
    }
}


// 메모리 초과
// 일일이 다 배열을 만들어서 메모리 터짐

//import java.util.*;
//class Solution {
//    public int[] solution(int n, long left, long right) {
//
//        int[] answer = new int[(int)(right - left + 1)];
//
//        List<Integer> list = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                list.add(Math.max(i, j) + 1);
//            }
//        }
//
//        for (int a = 0; a < answer.length; a++) {
//            answer[a] = list.get((int)(left + a));
//        }
//
//        return answer;
//    }
//}