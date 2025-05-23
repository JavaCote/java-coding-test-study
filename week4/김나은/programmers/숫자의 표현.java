package week4.김나은.programmers;

// 정수론 정리 : 자연수 n을 연속된 자연수의 합으로 표현하는 방법의 수 = n의 홀수 약수의 개수

class Solution {
    public int solution(int n) {
        int answer = 0;

        for(int i = 1; i <= n; i+=2){
            if(n % i == 0) answer++;
        }

        return answer;
    }
}