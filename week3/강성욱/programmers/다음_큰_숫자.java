package week3.강성욱.programmers;

public class 다음_큰_숫자 {
    //2진수로 변환하고
    //그걸 2진수로 바꾸고, 배열로 변환한뒤 1의 개수를 count 한다?
    class Solution {
        public int solution(int n) {
            int count = oneCount(n);
            int next = n + 1;

            while (oneCount(next) != count) {
                next++;
            }

            return next;
        }

        private int oneCount(int n) {
            String binary = Integer.toBinaryString(n);
            int count = 0;

            for (char c : binary.toCharArray()) {
                if (c == '1') {
                    count++;
                }
            }

            return count;
        }
    }
}
