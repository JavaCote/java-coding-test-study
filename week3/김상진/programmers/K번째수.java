package week3.김상진.programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * PackageName : week3.김상진.programmers
 * FileName    : K번째수
 * Author      : sangxxjin
 * Date        : 2025. 5. 12.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 5. 12.     sangxxjin               Initial creation
 */
public class K번째수 {
	// 다른 사람의 코드를 보니 copyOfRagne를 사용하면 더 짧은 코드를 얻을 것 같음
	import java.util.*;
	class Solution {
		public List<Integer> solution(int[] array, int[][] commands) {
			//정답용 배열을 list로 변경 -> 배열로 해도 상관없음 commands를 통해 정답의 개수를 알기 때문
			List<Integer> answer = new ArrayList<>();
			//커맨드를 반복하면서 원하는 조건의 값들을 계산 후 answer배열에 넣기
			for(int i=0; i<commands.length; i++){
				//각 커맨드별 응답값을 구하고 정렬하기위한 arr
				List<Integer> arr = new ArrayList<>();
				for(int j=commands[i][0]-1; j<commands[i][1]; j++){
					arr.add(array[j]);
				}
				Collections.sort(arr);
				answer.add(arr.get(commands[i][2]-1));
			}
			return answer;
		}
	}

}
