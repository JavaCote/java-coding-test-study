package week19.김누리.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * PackageName : week19.김누리.programmers
 * FileName    : 메뉴_리뉴얼
 * Author      : 김누리(NRKim)
 * Date        : 2025-08-31
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 08. 31.     김누리(NRKim)               Initial creation
 */

/*
String[] order ==> 단품 메뉴들
String[] course ==> 단품메뉴들의 갯수

음식의 구성은 2가지, 최소 2인 이상 주문한 조합으로만 코스메뉴화

orders[i]의 값들을 쪼개서 course[i] 값 만큼 nCm 처리
Map<String,Integer>map = new HashMap<>();

그리고 key 별로 카운팅


*/

public class 메뉴_리뉴얼 {
	public String[] solution(String[] orders, int[] course) {
		List<String> rs = new ArrayList<>();

		//  orders 순회
		for(int i = 0; i < orders.length; i++) {
			//  주문 내용 split
			char[] tmp = orders[i].toCharArray();

			//  주문 내용 정렬
			Arrays.sort(tmp);

			orders[i] = new String(tmp);
		}

		for(int c : course) {
			Map<String, Integer> map = new HashMap<>();

			for(String o : orders) {
				//  주문 내용이 코스에 포함되는 제품 보다 적으면 스킵
				if(o.length() < c) continue;

				// nCm
				comb(o,c,0,new StringBuilder(), map);
			}

			int cnt = 0;
			for(int v : map.values()) cnt = Math.max(cnt,v);
			if (cnt < 2) continue; // 2명 이상의 손님이 택한게 아님

			//  Map.Entry : k-v 형태로 이루어진 Map 자료구조에서
			//  k-v의 한 셋트를 그 자체로 객체화 하는 용도.
			for(Map.Entry<String,Integer> e : map.entrySet()) {

				if(e.getValue() == cnt) rs.add(e.getKey());
			}
		}

		//  요건 : 정답 제출 시 오름차순 할 것
		Collections.sort(rs);

		//  List에 적재된 요소들의 맨 앞 글자 기준으로 정렬
		return rs.toArray(new String[0]);
	}

	public void comb(String o, int n, int m, StringBuilder sb,Map<String,Integer>map) {
		//  조합 문자수가 n과 동일하면, map에 격납
		if(sb.length() == n) {
			String key = sb.toString();
			map.put(key, map.getOrDefault(key,0)+1);
			return;
		}

		//  조합 가지수가 문자열과 동일하면 skip
		if (m == o.length()) return;

		sb.append(o.charAt(m));
		comb(o,n,m+1,sb,map);
		sb.deleteCharAt(sb.length()-1); //  맨 뒤에거 제거

		//  미선택
		comb(o,n,m+1,sb,map);
	}
}
