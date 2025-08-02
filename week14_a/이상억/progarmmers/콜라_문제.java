// 20 -> 10 -> 5 -> 2 + 1 +1
// 10 + 5 + 2 + 1 + 1

// n : 빈병 , 빈병 a 개를 가져다 주면 콜라 b 병을 주는 마트
class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;

        while(n>=a){
            int ex = (n/a) * b;
            int re = n % a ;

            answer += ex;

            n = ex + re;
        }

        return answer;
    }
}