package week14.김나은.programmers;

public class 최대공약수와_최소공배수 {

    class Solution {

        public int[] solution(int n, int m) {

            // a는 더 큰 수, b는 더 작은 수로 초기화
            int a = Math.max(n, m);
            int b = Math.min(n, m);

            // 유클리드 호제법으로 최대공약수(GCD) 구함
            while (b > 0) {
                int temp = a % b; // a를 b로 나눈 나머지
                a = b;            // b를 a에 대입
                b = temp;         // 나머지를 b에 대입 (반복)
            }

            int gcd = a; // 반복문 끝나면 a가 최대공약수

            // 최소공배수(LCM)는 두 수의 곱을 최대공약수로 나눈 것
            int lcm = n * m / gcd;

            // 결과를 배열에 담아 리턴 (0: 최대공약수, 1: 최소공배수)
            return new int[]{gcd, lcm};
        }
    }
}