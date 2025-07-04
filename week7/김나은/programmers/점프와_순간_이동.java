package week7.김나은.programmers;

public class 점프와_순간_이동 {

    public class Solution {

        public int solution(int n) {
            int ans = 0; // 사용한 건전지 수

            while (n != 0) {
                // n이 홀수인 경우, 이 경우 1칸 점프를 해야 다음 순간이동이 가능하므로 건전지를 1개 사용해야 함
                if (n % 2 == 1) {
                    ans++; // 점프(건전지 1개 사용)
                }

                // n을 2로 나누어 순간이동 (건전지 사용하지 않음)
                // 순간이동은 현재 위치의 2배로 이동 가능하므로,
                // 반대로 생각하면 n에서 순간이동을 한 번 했다는 의미는 현재 위치가 2배였다는 것
                n /= 2;
            }

            // 최종적으로 사용한 건전지(점프한 횟수)를 반환
            return ans;
        }
    }
}