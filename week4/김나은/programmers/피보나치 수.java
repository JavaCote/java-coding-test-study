package week4.김나은.programmers;

class Solution {
    public int solution(int n) {
        // 피보나치수열 수식에서 사용할 배열을 선언해준다.
        // 배열 선언 시 길이는 마지막 n번째 수를 1234567로 나눈 값을 return 해줘야 하므로 n + 1로 정한다.
        int[] answer = new int[n + 1];

        answer[0] = 0;
        answer[1] = 1;

        // 반복문을 통해 F(n) = F(n-1) + F(n-2) 수식이 만족되도록 더해준다.
        for(int i = 2; i <= n; i++) {
            answer[i] = (answer[i - 1] + answer[i - 2]) % 1234567;
        }

        // 2이상의 n이 입력되었을 때, n번째 피보나치 수를 1234567로 나눈 값을 return 해준다.
        return answer[n] % 1234567;
    }
}