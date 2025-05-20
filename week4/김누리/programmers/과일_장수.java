package week4.김누리.programmers;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * PackageName : week4.김누리.programmers
 * FileName    : 과일_장수
 * Author      : 김누리(NRKim)
 * Date        : 2025-05-20
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 05. 20.     김누리(NRKim)               Initial creation
 */


/*
k = 최고점
m = 1 상자에 들어가는 사과 수


case 1 :
  k = 3, m = 4
  1 2 3 1 2 3 1 > 111 22 33 >> 3322 / 111
  {
    {3,3,2,2},
    {1,1,1, }
  }


case 2 :
  4 1 2 2 4 4 4 4 1 2 4 2 >> 11 2222 444444 > 444/ 444/ 222/ 211/
  {
   {4,4,4}
   {4,4,4}
   {2,2,2}
   {2,1,1}
  }

*/

public class 과일_장수 {
	public int solution(int k, int m, int[] score) {
		int answer = 0;
		Queue<Integer> desc = new LinkedList<>(); //  내림차순 정렬해서 저장용 큐
		Stack<List<Integer>> stk = new Stack<>();

		Arrays.sort(score); // 오름차순 정렬

		for (int i = score.length-1; i >= 0; i--) {
			desc.offer(score[i]);
		}

		List tmp = new LinkedList<>();


		while(!desc.isEmpty()) {
			tmp.add(desc.poll());

			//  1상자 당 m개씩 사과 분배
			if(tmp.size() == m) {
				stk.push(tmp);

				// 다음 상자 준비
				tmp = new LinkedList<>();
			}
		}

		for(List<Integer> apple : stk) {
			int p = apple.get(0);

			for(int i = 1 ; i < apple.size(); i++) {
				int tmpApple = apple.get(i);
				if(tmpApple <= p) {
					p = tmpApple;
				}
			}

			//  추후 Google링 해서 알아낸 결과로
			//  Collections 함수 써서 아래 구문을 통해 간단히 해결 가능
			//  int p = Collections.min(apple);

			answer += (p*m);
		}

		return answer > 0 ? answer : 0; //  수익이 없는 경우 0을 던질 수 있도록 3항 조합
	}
}
