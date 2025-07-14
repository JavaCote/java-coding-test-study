package week12.김누리.programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * PackageName : week12.김누리.programmers
 * FileName    : 여행경로
 * Author      : 김누리(NRKim)
 * Date        : 2025-07-14
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 07. 14.     김누리(NRKim)               Initial creation
 */


/*
tickets 를 뜯어보면

tickets[0][0] == from
tickets[0][1] == to

dfs 채용해서 하면 될거 같은데...

dfs(String[][] tickets, Boolean[] visited, String now, List<String> list, int cnt)로 해서 풀이 하면 될거 같은데...



*/

public class 여행경로 {
	//  방문 여행지 저장용 리스트
	List<String> list = new ArrayList<>();

	//  방문 여부 판별용 배열
	boolean[] visited;

	public String[] solution(String[][] tickets) {
		visited = new boolean[tickets.length];

		//  인천에서 출발하는걸 전제로 재귀 시작
		dfs(tickets,"ICN","ICN",0);

		Collections.sort(list);

		String[] answer = new String[list.size()];

		answer = list.get(0).split(" ");

		return answer;
	}

	private void dfs(String[][]tickets, String current, String target, int cnt) {

		//  티켓 사이즈만큼 다 돌렸다? list에 추가
		if(cnt == tickets.length) {
			list.add(target);
			return;
		}

		//  티켓 사이즈 만큼 반복
		for(int i = 0; i < tickets.length; i++) {
			if(!visited[i] && tickets[i][0].equals(current)) {
				visited[i] = true;
				//  시작점 : tickets[i][1], 경로 : 도착지 다음 도착지
				dfs(tickets,tickets[i][1],target+" "+tickets[i][1],cnt+1);
				visited[i] = false;
			}
		}
	}
}
