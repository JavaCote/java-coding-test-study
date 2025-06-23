// 동일한 가짓수의 토핑이 올라가면 공평하게 롤케이크가 나누어짐
// 어떤 토핑이 나왔는지 확인하려면 hash
import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;

        Set<Integer> set = new HashSet<>(); // 왼쪽부터 잘라나갈 토핑

        Map<Integer,Integer> map = new HashMap<>();

        // 전체 토핑 개수 세기
        for(int i : topping){
            map.put( i , map.getOrDefault(i,0) + 1);
        }

        for(int i : topping){
            set.add(i);
            map.put(i,map.get(i) -1 );
            if(map.get(i) == 0) map.remove(i);
            if(set.size() == map.size()) answer ++;
        }

        return answer;
    }
}