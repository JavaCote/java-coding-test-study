package week13.김누리.programmers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * PackageName : week13.김누리.programmers
 * FileName    : 후보키
 * Author      : 김누리(NRKim)
 * Date        : 2025-07-23
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 07. 23.     김누리(NRKim)               Initial creation
 */

/*
후보키 : 유일성과 최소성을 만족하는 키...

유일성 : seq나 학번, 유저 고유 id 등 데이터마다 유일하게 가지고 있는 데이터
최소성 : 유일성을 유지하며 추가적으로 인식하게 해 줄수 있는 데이터

데이터 구성 :
relation = {
    {"학번","이름","전공","학년"},
    {"학번","이름","전공","학년"},
    {"학번","이름","전공","학년"},
    {"학번","이름","전공","학년"}
}

set 이용해서 학번 관리 Set<String> set = new HashSet<>();

set.add(relation[i][0]); >> 중복 없는 학번 취득

map  {"100" = {"항목 1","항목 2"}}

후보키 가능 조합

이름 + 전공, 이름 + 학년, 전공 + 학년, 이름 + 전공 + 학년

이름 + 전공 : 라이언 음악 / 어피치 수학/ 튜브 컴퓨터/ 콘 컴퓨터/ 무지 음악/ 어피치 음악
이름 + 학년 : 라이언 2 / 어피치 2 / 튜브 3/ 콘 1/ 무지 3/ 어피치 2 >> 학번이 달라도 동일 학년에 동명 이인이 있어 판단 불가
전공 + 학년 : 음악 2 / 수학 2/ 컴퓨터 3/ 컴퓨터 1/ 음악 3/ 음악 2 >> 학번이 있지만, 누군지 판단 불가 + 과목과 학년 조합으로 판단 불가
이름 + 전공 + 학년 >> 최소성 만족 못함

그렇다면? nCm 형태의 조합 방식으로 ㄱ

풀다가 많이 막혔음. nCm 형태의 조합 방식을 채택한건 좋지만, 이후 조합을 가지고 유일성, 최소성을 구현하는 부분에서 AI의 도움을 받음

*/

public class 후보키 {
	List<Integer> path;
	List<List<Integer>> combinations;
	List<List<Integer>> candidateKeys;
	int row;

	public int solution(String[][] relation) {
		int answer = 0;
		int col = relation[0].length;  // 컬럼 갯수
		row = relation.length;

		path = new ArrayList<>();
		combinations = new ArrayList<>();  //  조합 저장용 리스트
		candidateKeys = new ArrayList<>(); //  후보키용 리스트

		//  모든 컬럼들을 가지고 만들 수 있는 모든 조합 생성
		for (int r = 1; r <= col; r++) {
			combine(0, col, r);
		}

		// 생성된 조합들의 유일성과 최소성 검사
		for (List<Integer> c : combinations) {
			if (isUnique(c,relation) && isMinimal(c)) {
				candidateKeys.add(c);
				answer++;
			}
		}

		return answer;
	}

	//  키 조합
	public void combine(int start, int col, int r) {
		//  각 컬럼을 r개 만큼 조합되면 재귀 종료
		if(path.size() == r) {
			combinations.add(new ArrayList(path));
			return;
		}

		for(int i = start; i < col; i++) {
			path.add(i);
			combine(i+1, col, r);
			path.remove(path.size()-1);
		}
	}

	//  유일성 판정하기 위한 판정
	public boolean isUnique(List<Integer> cols, String[][] relation) {
		Set<String> set = new HashSet<>();

		for(int i = 0; i < row; i++) {
			StringBuilder sb = new StringBuilder();

			for(int c : cols) {
				//  릴레이션의 각 투플들을 조합
				sb.append(relation[i][c]).append("|");
			}
			set.add(sb.toString());
		}

		//  중복을 제거한 유일키들의 사이즈가 총 컬럼수와 같으면 true
		return set.size() == row;
	}

	//  최소성 만족하는지 판정
	public boolean isMinimal (List<Integer> cols) {
		for (List<Integer> key : candidateKeys) {
			//  컬럼에 키가 이미 존재하면 flase
			if (cols.containsAll(key)) return false;
		}

		return true;
	}
}
