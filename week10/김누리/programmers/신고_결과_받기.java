package week10.김누리.programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * PackageName : week10.김누리.programmers
 * FileName    : 신고_결과_받기
 * Author      : 김누리(NRKim)
 * Date        : 2025-06-30
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 06. 30.     김누리(NRKim)               Initial creation
 */

/*

        muzi  frodo  apeach  neo
muzi     -      v      X      v
frodo    x      -      x      v
apeach   v      v      -      x
neo      x      x      x      -

신고 카운트
muzi   1
frodo  2
apeach 0
neo    2

신고 카운트 2회 이상 >> frodo && neo >> 정지맨
신고 카운트 1회     >> muzi         >> 경고맨

그러면... 저거 report >> reports의 2차원 배열화 한 다음 진행

id_list를 키로 하고

reports[i][0] => 신고 한 사람
reports[i][1] => 신고 당한 사람

Map<String,Integer> map

map = {"muzi" = 1,"frodo" = 2,"apeach" = 0,"neo" = 2}

report = ["muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"]

report 배열을 훑으며 정지 유저 카운팅 ㄱㄱ

*/

public class 신고_결과_받기 {
	public int[] solution(String[] id_list, String[] report, int k) {
		int[] answer = new int[id_list.length]; //  정답 반환용 배열
		Map<String,Integer> map1 = new HashMap<>(); //  신고자 카운트 배열
		Map<String, Set<String>> map2 = new HashMap<>(); //  신고자 별 신고 내역 카운트 배열
		Set<String> set = new HashSet<>(); // 중복 제거용 set

		//  신고자 배열에서 중복 제거
		for(String s : report) {
			set.add(s);
		}

		List<String> list = new ArrayList<>(set);
		String[][] reports = new String[list.size()][];

		int idx = 0;
		//  report 배열 2차원 배열화
		//  중복 제거 해야함 예 : case 2 의 report의 경우 ["ryan con", "ryan con", "ryan con", "ryan con"]로 들어옴
		//  결국 조사 해야하는건 ryan con 이 두개 뿐임
		for(String s : list) {
			String[] tmp = s.split(" ");
			reports[idx++] = tmp;
		}

		//  신고자별 신고 내용 카운팅 배열 초기화
		for(String s : id_list) {
			map2.put(s,new HashSet<>());
		}

		//  신고 당한사람 카운팅
		for(String[] s : reports) {
			String reporter = s[0];
			String target = s[1];

			map2.get(reporter).add(target);

			map1.put(target, map1.getOrDefault(target,0)+1);
		}

		//  정지 유저 리스트
		Set<String> banned = new HashSet<>();
		for(String s : map1.keySet()) {
			if(map1.get(s) >= k) {
				banned.add(s);
			}
		}

		//  id별 신고 메일 건수 카운팅
		for(int i = 0; i < id_list.length; i++) {
			String id = id_list[i];
			int cnt = 0;

			for(String s : map2.get(id)) {
				if(banned.contains(s)) {
					cnt++;
				}
			}

			answer[i] = cnt;
		}

		return answer;
	}
}
