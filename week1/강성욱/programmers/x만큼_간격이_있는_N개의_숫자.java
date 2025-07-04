package week1.강성욱.programmers;

public class x만큼_간격이_있는_N개의_숫자 {
    //이거, overflow 때문인지, 테스트 케이스가 몇개 통과가 안되서 고민했었음.

    class Solution {
        public long[] solution(int x, int n) {
            long[] answer = new long[n];

            for (int i=1; i<=n; i++) {
                answer[i-1] = (long)x * i;
            }

            return answer;
        }
    }
}
