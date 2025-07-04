package week6.김상진.programmers;

import java.util.HashMap;
import java.util.Map;

/**
 * PackageName : week6.김상진.programmers
 * FileName    : 추억_점수
 * Author      : sangxxjin
 * Date        : 2025. 6. 1.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 6. 1.     sangxxjin               Initial creation
 */
public class 추억_점수 {
	// 어렵지 않은 문제였음 이름과 점수를 보고 map을 바로 떠올림
	// array와 list 고민 했지만 응답값의 크기가 정해져있어서 array 선택
	// 다른 사람의 풀이를 보았을때 LinkedHashMap을 사용하는 분들도 있는데 순서가 필요하지 않아서 HashMap 사용
	import java.util.*;
	class Solution {
		public int[] solution(String[] name, int[] yearning, String[][] photo) {
			int[] answer = new int[photo.length];
			Map<String, Integer> map = new HashMap<>();
			for(int i=0; i<name.length; i++){
				map.put(name[i],yearning[i]);
			}
			for(int i=0; i<photo.length; i++){
				int sum=0;
				for(int j=0; j<photo[i].length; j++){
					sum+=map.getOrDefault(photo[i][j],0);
				}
				answer[i]=sum;
			}
			return answer;
		}
	}
}
