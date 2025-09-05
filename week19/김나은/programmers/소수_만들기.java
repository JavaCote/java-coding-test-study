package week19.김나은.programmers;

public class 소수_만들기 {

    class Solution {

        public int solution(int[] nums) {

            // 3개의 수 더한 값을 저장할 변수
            int answer = 0;
            int sum = 0;

            // 주어진 숫자 중 3개의 수 고르기
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    for (int k = j + 1; k < nums.length; k++) {
                        // 3개의 수 더해서 소수인지 판단
                        sum = nums[i] + nums[j] + nums[k];
                        if (isPrime(sum) == true) {
                            answer++;
                        }
                    }
                }
            }
            return answer;
        }

        // 소수인지 판단하는 메서드
        private boolean isPrime(int num) {
            // 1은 모든 숫자가 약수로 가지고 있으므로 제외한다.
            for (int i = 2; i < num; i++) {
                if (num % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
}