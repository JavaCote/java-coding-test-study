package week1.강성욱.programmers;

public class 푸트_파이트_대회 {
    class Solution {
        public String solution(int[] food) {
            StringBuilder left = new StringBuilder();

            //0은 안봐도됨
            for (int i = 1; i < food.length; i++) {
                int count = food[i] / 2;
                for (int j = 0; j < count; j++) {
                    left.append(i);
                }
            }
            return left.toString() + "0" + left.reverse().toString();
        }
    }

}
