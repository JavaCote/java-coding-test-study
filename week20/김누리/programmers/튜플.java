package week20.김누리.programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * PackageName : week20.김누리.programmers
 * FileName    : 튜플
 * Author      : 김누리(NRKim)
 * Date        : 2025-09-10
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 09. 10.     김누리(NRKim)               Initial creation
 */

public class 튜플 {
	public int[] solution(String s) {
		Map<Integer,Integer> map = new HashMap<>();

		String tmp = s.replace("{","").replace("}","");

		for(String s1 : tmp.split(",")) map.put(Integer.parseInt(s1),map.getOrDefault(Integer.parseInt(s1),0)+1);

		List<Integer> list = new ArrayList<>(map.keySet());
		list.sort((a,b) -> map.get(b) - map.get(a));

		int[] answer = new int[list.size()];

		for(int i = 0; i < list.size(); i++) answer[i] = list.get(i);

		return answer;
	}
}
