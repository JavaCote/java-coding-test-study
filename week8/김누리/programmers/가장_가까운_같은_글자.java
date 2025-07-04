package week8.김누리.programmers;

/**
 * PackageName : week8.김누리.programmers
 * FileName    : 가장_가까운_같은_글자
 * Author      : 김누리(NRKim)
 * Date        : 2025-06-15
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 06. 15.     김누리(NRKim)               Initial creation
 */


/*
Case 1
    input : banana

    1. b : 제일 첫 idx 이므로 자신 앞에 같은 글자가 없으므로 -1
    2. a : 자신 앞에 같은 글자가 없으므로 -1
    3. n : 자신 앞에 같은 글자가 없으므로 -1
    4. a : idx 1에 같은 글자가 있음. 현재 idx = 3, 타겟 idx = 1 >> 3 - 1 = 2
    5. n : idx 2에 같은 글자가 있음. 현재 idx = 4, 타겟 idx = 2 >> 4 - 2 = 2
    6. a : idx 3에 같은 글자가 있음. 현재 idx = 5, 타겟 idx = 3 >> 5 - 3 = 2

    return [-1,-1,-1,2,2,2]

Case 2
    input : foobar

    1. f : 제일 첫 idx 이므로 자신 앞에 같은 글자가 없으므로 -1
    2. o : 자신 앞에 같은 글자가 없으므로 -1
    3. o : idx 1에 같은 글자가 있음. 현재 idx = 2, 타겟 idx = 1 >> 2 - 1 = 1
    4. b : 자신 앞에 같은 글자가 없으므로 -1
    5. a : 자신 앞에 같은 글자가 없으므로 -1
    6. r : 자신 앞에 같은 글자가 없으므로 -1

    return [-1,-1,1,-1,-1,-1]
*/

public class 가장_가까운_같은_글자 {
	public int[] solution(String s) {
		int[] answer = new int[s.length()];
		String[] sArr = s.split("");

		//  0번 idx는 -1
		answer[0] = -1;

		// idx 1번 부터 s 길이까지
		for(int i = 1; i < sArr.length; i++) {
			String tar = sArr[i]; //  타겟 문자

			// 현재 idx vs 이전번 idx 비교
			for(int j = i-1; j >= 0; j--) {
				String prev = sArr[j];
				if(prev.equals(tar)) {
					answer[i] = i-j;
					break;
				} else {
					answer[i] = -1;
				}
			}
		}

		return answer;
	}
}
