import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {

        Arrays.sort(A);
        Arrays.sort(B);

        int i = 0;
        int j = 0;
        int win = 0;

        while( i < A.length && j < B.length) {
            if(B[j] > A[i]){
                win ++;
                i++;
            }
            j++;
        }
        return win;
    }
}