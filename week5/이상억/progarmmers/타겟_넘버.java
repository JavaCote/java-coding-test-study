/**
 * PackageName : week5.이상억.progarmmers;
 * FileName    : 타겟_넘버
 * Author      : sangeok
 * Date        : 2025. 5. 29.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 5. 29.     sangeok               Initial creation
 */

class Solution {
    int answer = 0;

    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return answer;
    }

    public void dfs(int[] numbers, int target, int idx, int sum) {
        if (idx == numbers.length) {
            if (sum == target) {
                answer++;
            }
            return;
        }
        dfs(numbers, target, idx + 1, sum + numbers[idx]);
        dfs(numbers, target, idx + 1, sum - numbers[idx]);
    }
}

//import java.util.*;
//
//class Solution {
//    public int solution(int[] numbers, int target) {
//        int answer = 0;
//
//        Stack<int[]> stack = new Stack<>();
//        stack.push(new int[]{0, 0});
//
//        while (!stack.isEmpty()) {
//            int[] current = stack.pop();
//            int idx = current[0];
//            int sum = current[1];
//
//            if (idx == numbers.length) {
//                if (sum == target) answer++;
//            } else {
//                stack.push(new int[]{idx + 1, sum + numbers[idx]});
//                stack.push(new int[]{idx + 1, sum - numbers[idx]});
//            }
//        }
//
//        return answer;
//    }
//}
