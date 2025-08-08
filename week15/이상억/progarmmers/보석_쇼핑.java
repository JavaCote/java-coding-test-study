/**
 * PackageName : week15.이상억.progarmmers;
 * FileName    : 보석_쇼핑
 * Author      : sangeok
 * Date        : 2025. 08. 07.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 08. 07.     sangeok               Initial creation
 */

// HashSet + Sliding Window ?

import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];

        Set<String> jewelSet = new HashSet<>(); // 전체 보석 개수 확인
        Map<String, Integer> jewelMap = new HashMap<>(); // 현재 윈도우 내 보석 개수 카운팅

        int start = 0;
        int end = 0;
        int minlen = Integer.MAX_VALUE;

        for(String g : gems){
            jewelSet.add(g);
        }

        while(end < gems.length){

            String gem = gems[end];
            jewelMap.put(gem, jewelMap.getOrDefault(gem, 0) + 1);
            end++;

            while(jewelMap.size() == jewelSet.size()){
                if(end - start < minlen){
                    minlen = end - start;
                    answer[0] = start + 1;
                    answer[1] = end;
                }

                String startgem = gems[start];
                jewelMap.put(startgem, jewelMap.get(startgem) -1);
                if(jewelMap.get(startgem) == 0){
                    jewelMap.remove(startgem);
                }

                start ++;


            }
        }
        return answer;
    }
}