package week2.강성욱.programmers;

import java.util.*;

public class 최솟값_만들기 {
    // 가장 작은 곱셈을 구하는건?
    // 가장 작은거 x 가장 큰값?

    // [1, 4, 2], [5, 4, 4]
    // 이거 정렬하면, [1, 2, 4], [4, 4, 5]
    // 1*5, 2*4, 4*4
    // 5 + 8 + 16
    // 29

    class Solution
    {
        public int solution(int []A, int []B)
        {
            //오름 차순 정리
            Arrays.sort(A);
            Arrays.sort(B);

            int sum = 0;
            for(int i=0; i<A.length; i++) {
                //Long 변환 안해도됨. 짜피 최대 1000 이니...
                sum += A[i] * B[A.length -1 - i];
            }
            return sum;
        }
    }
}
