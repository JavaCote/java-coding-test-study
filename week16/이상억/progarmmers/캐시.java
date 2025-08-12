/**
 * PackageName : week16.이상억.progarmmers;
 * FileName    : 캐사
 * Author      : sangeok
 * Date        : 2025. 08. 12.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 08. 12.     sangeok               Initial creation
 */

// 캐시 크기 및 도시이름 배열
// 0 <= 캐시 크기 <= 30
// 도시 이름 크기 <= 100,000
// LRU => 가장 오랫동안 사용하지 않은 페이지 교체


import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        if(cacheSize == 0) return cities.length * 5;
        Deque<String> page = new LinkedList<>();


        for(String citys : cities){
            String city = citys.toLowerCase();

            if(page.contains(city)){
                page.remove(city);
                page.addLast(city);
                answer += 1;
            } else{
                if(page.size() == cacheSize) page.removeFirst();
                page.addLast(city);
                answer += 5;
            }
        }
        return answer;
    }
}