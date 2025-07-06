package week11.김누리.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * PackageName : week11.김누리.programmers
 * FileName    : 두_개_뽑아서_더하기
 * Author      : 김누리(NRKim)
 * Date        : 2025-07-06
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 07. 06.     김누리(NRKim)               Initial creation
 */

public class 두_개_뽑아서_더하기 {
	public int[] solution(int[] numbers) {
		//  계산용 임시 해시
		Set<Integer> set = new HashSet<>();

		//  두 수를 뽑아, 더한 값을 해쉬에 저장
		for(int i = 0; i < numbers.length-1; i++) {
			int a = numbers[i];

			for(int j = i+1; j < numbers.length; j++) {
				int b = numbers[j];
				set.add(a+b);
			}
		}

		//  Set >> List화
		List<Integer> list = new ArrayList<>(set);
		int[] answer = new int [list.size()];
		int idx = 0;

		for(int i : list) {
			answer[idx++] = i;
		}

		//  오름차순
		Arrays.sort(answer);

		return answer;
	}
}
