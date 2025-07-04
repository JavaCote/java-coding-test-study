package week5.강성욱.programmers;

public class 타겟_넘버 {
    //뭔가 최적화를 생각하면, 중간에 조건 분기하고, 남은 숫자들을 뭔가 조합해서 가능하냐? 등을 할 수는 있을 것 같음. (매우 어려울듯)
    //단순 반복을 해보자.
    //중첩 for 문이 몇개 나올지는 모름. 왜? 반복회수가 정해져 있지 않음.
    //그럼 이건 완탐 * bfs/dfs 임
    //시간 복잡도는, O(2^n), 2r가지 +, -에 대해 n개 만큼
    //2^20 = 약 100만. 쌉가능

    //dfs 로 풀자.
    //종료 지점은, depth == numbers.length
    //종료 지점에서, 걸리면 target 과 비교 후, resultCount 증가. (동일하면)
    //그럼, 현재 값을 지속적으로 넘겨줘야함. visited 는 필요없음.
    class Solution {
        private int count = 0;

        public int solution(int[] numbers, int target) {
            dfs(numbers, target, 0, 0);
            return count;
        }

        private void dfs(int[] numbers, int target, int nowSum, int depth) {
            if(depth == numbers.length) {
                if(nowSum == target) count++;
                return;
            }
            dfs(numbers, target, nowSum + numbers[depth], depth + 1); //하나는 더하기
            dfs(numbers, target, nowSum - numbers[depth], depth + 1); //하나는 빼기
        }
    }
}
