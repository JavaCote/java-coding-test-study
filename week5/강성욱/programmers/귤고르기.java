package week5.강성욱.programmers;

import java.util.*;
public class 귤고르기 {
    //항상 가장 많은 사이즈 분포를 가진 귤만 박스에 넣으면 되는거 아닌가?
    //[1, 1, 1, 3, 3, 4, 4, 5, 5, 5, 5], k = 5;
    //5만 4개 너고, 아무꺼나 하나 넣으면 끝.
    //음.. key-value 자료구조 쓰면 될듯. Map 쓰자

    //후기, 다풀고 나니, 중간에 Map -> List 로 변환하는 과정에서, key값인 귤 사이즈 종류 데이터는 굳이 가져올 필요가 없다.
    //즉, 복잡하게 Map.Entry 로 엔트리를 가져올 필요 없이, 그냥 .values() 만 해서 값만(개수) 꺼내와도 됬을 듯 하다.

    class Solution {
        public int solution(int k, int[] tangerine) {
            Map<Integer, Integer> map = new HashMap<>(); //key : 귤 사이즈, value : 귤 개수
            for(int item : tangerine) {
                map.put(item, map.getOrDefault(item, 0) + 1);
            }

            List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(map.entrySet());
            entryList.sort((a, b) -> b.getValue() - a.getValue()); //내림차순

            int sum = 0;
            int sizeCount = 0;

            //이제 실제 상자에 담음. max = k;
            for(Map.Entry<Integer, Integer> now : entryList) {
                sum += now.getValue();
                sizeCount++;
                if(sum >= k) break;
            }

            return sizeCount;
        }
    }
}
