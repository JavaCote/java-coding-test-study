package week14.강성욱.programmers;

import java.util.HashMap;
import java.util.Map;

/**
 * PackageName : week14.강성욱.programmers
 * FileName    : 성격유형검사
 * Author      : Baekgwa
 * Date        : 2025-07-28
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-07-28     Baekgwa               Initial creation
 */
public class 성격유형검사 {

	class Solution {
		public static final int[] pointArray = new int[]{0, 3, 2, 1, 0, 1, 2, 3}; //인덱스 값 기준, 점수 확인
		public String solution(String[] survey, int[] choices) {
			Map<String, Integer> map = new HashMap<>();
			//각 유형별 점수 모음
			map.put("R", 0); map.put("T", 0); map.put("C", 0); map.put("F", 0);
			map.put("J", 0); map.put("M", 0); map.put("A", 0); map.put("N", 0);

			//survey + choices 로 유형별 점수 계산
			for(int i=0; i<survey.length; i++) {
				int point = pointArray[choices[i]];
				String negative = survey[i].split("")[0];
				String positive = survey[i].split("")[1];

				if(choices[i] <= 3) map.put(negative, map.get(negative) + point);
				else if(choices[i] >= 5) map.put(positive, map.get(positive) + point);
			}

			//유형별 점수 계산하기
			StringBuilder sb = new StringBuilder();
			sb.append(map.get("R") >= map.get("T") ? "R" : "T");
			sb.append(map.get("C") >= map.get("F") ? "C" : "F");
			sb.append(map.get("J") >= map.get("M") ? "J" : "M");
			sb.append(map.get("A") >= map.get("N") ? "A" : "N");

			return sb.toString();
		}
	}
}
