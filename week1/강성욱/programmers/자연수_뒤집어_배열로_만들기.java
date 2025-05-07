package week1.강성욱.programmers;

import java.util.ArrayList;
import java.util.List;

public class 자연수_뒤집어_배열로_만들기 {
    class Solution {
        public int[] solution(long n) {
            List<Integer> list = new ArrayList<>();

            while (n > 0) {
                list.add((int) (n % 10));
                n /= 10;
            }

            int[] result = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                result[i] = list.get(i);
            }

            return result;
        }
    }
}
