package week19.김누리.programmers;

/**
 * PackageName : week19.김누리.programmers
 * FileName    : 비밀지도
 * Author      : 김누리(NRKim)
 * Date        : 2025-09-01
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 09. 01.     김누리(NRKim)               Initial creation
 */

public class 비밀지도 {
	public String[] solution(int n, int[] arr1, int[] arr2) {
		String[] answer = new String[n];
		String[] sArr1 = new String[n], sArr2 = new String[n];

		//  맵 이진화
		for(int i = 0; i < n; i++) {
			sArr1[i] = String.format("%" + n + "s", Integer.toBinaryString(arr1[i])).replace(" ", "0");
			sArr2[i] = String.format("%" + n + "s", Integer.toBinaryString(arr2[i])).replace(" ", "0");
		}

		//  맵 겹치기
		for(int i = 0; i < sArr1.length; i++) {
			StringBuilder sb = new StringBuilder();

			String a = sArr1[i];
			String b = sArr2[i];

			for(int j = 0; j < a.length(); j++) {
				if((a.charAt(j) == '1' && b.charAt(j) == '1') || (a.charAt(j) == '1' && b.charAt(j) == '0') || (a.charAt(j) == '0' && b.charAt(j) == '1')) sb.append("#");
				else sb.append(" ");
			}

			answer[i] = sb.toString();
		}

		return answer;
	}
}
