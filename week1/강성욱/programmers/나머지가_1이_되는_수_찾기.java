package week1.강성욱.programmers;

public class 나머지가_1이_되는_수_찾기 {
    class Solution {
        public int solution(int n) {
            for (int i=1; i<n; i++) {
                if (n % i == 1) {
                    return i;
                }
            }
            return 0;
        }
    }
}
