package week3.강성욱.programmers;

public class PCCE_기출문제_9번_지페_접기 {
    //반복!
    //반으로 접는건, 큰쪽을 접으면 됨.
    //while 로 반복을 도면서 아래처럼 생각할것
        //1. 현재 지갑에 들어가니? (그대로 혹은 90도 돌려서?)
        //2. 안되는구나.. 그럼 반으로 접자. (큰쪽을 접자)
        //3. 접었으면 count++
        //4. 1번부터 다시 반복해~

    class Solution {
        public int solution(int[] wallet, int[] bill) {
            int count = 0;

            while (!isPossible(wallet, bill)) {
                // 긴 쪽을 반으로 접음
                if (bill[0] >= bill[1]) {
                    bill[0] /= 2;
                } else {
                    bill[1] /= 2;
                }
                count++;
            }

            return count;
        }

        private boolean isPossible(int[] wallet, int[] bill) {
            return (bill[0] <= wallet[0] && bill[1] <= wallet[1]) ||
                    (bill[1] <= wallet[0] && bill[0] <= wallet[1]);
        }
    }
}
