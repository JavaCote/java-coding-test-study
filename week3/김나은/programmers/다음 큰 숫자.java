package week3.김나은.programmers;

class Solution {
    public int solution(int n) {
        // n의 이진수에서 1의 개수를 구함
        int nowCount = Integer.bitCount(n);

        // 다음 숫자를 찾기 위한 반복문
        while(true) {
            n++;
            int nextCount = Integer.bitCount(n); // 증가된 n의 이진수에서 1의 개수를 구함

            // n++의 이진수 1의 개수와 원래 n의 1의 개수가 같으면 루프 종료
            if(nowCount == nextCount) {
                break;
            }
        }

        return n;
    }
}