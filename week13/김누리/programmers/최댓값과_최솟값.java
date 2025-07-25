package week13.김누리.programmers;

import java.util.Arrays;

/**
 * PackageName : week13.김누리.programmers
 * FileName    : 최댓값과_최솟값
 * Author      : 김누리(NRKim)
 * Date        : 2025-07-22
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 07. 22.     김누리(NRKim)               Initial creation
 */

public class 최댓값과_최솟값 {
	public String solution(String s) {
		String answer = "";
		String[] str = s.split(" ");
		int[] arr = new int[str.length];

		int idx = 0;

		for(String i : str) arr[idx++] = Integer.parseInt(i);

		Arrays.sort(arr);

		if(arr.length == 2) answer = Integer.toString(arr[0]) + " " + Integer.toString(arr[1]);
		else answer = Integer.toString(arr[0]) + " " + Integer.toString(arr[arr.length-1]);

		return answer;
	}
}
