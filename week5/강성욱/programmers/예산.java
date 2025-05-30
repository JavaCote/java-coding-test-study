package week5.강성욱.programmers;

import java.util.*;

public class 예산 {
    //그냥 정렬때리고, 오름차순으로 하나씩 더하다가, budget 보다 커진다? 하면 count 증가 반복 취소하고 return?
    //안될 이유가 없는디?
    //음 시간복잡도는 O(n)

    class Solution {
        public int solution(int[] d, int budget) {
            Arrays.sort(d);
            int count=0;
            int sum = 0;

            for(int now : d) {
                if(sum + now <= budget) {
                    sum += now;
                    count++;
                    continue;
                }
                break;
            }

            return count;
        }
    }
}
