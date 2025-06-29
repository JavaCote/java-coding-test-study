package week10.김상진.programmers;

public class 부족한_금액_계산하기 {
    class Solution {
        public long solution(int price, int money, int count) {
            long totalCost = 0;
            for(int i=1; i<=count; i++){
                totalCost+=price*i;
            }
            if (totalCost > money) {
                return totalCost - money;
            } else {
                return 0;
            }
        }
    }
}
