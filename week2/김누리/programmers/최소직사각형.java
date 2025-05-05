package week2.김누리.programmers;

/**
 * PackageName : week2.김누리.programmers
 * FileName    : 최소직사각형
 * Author      : 김누리
 * Date        : 2025-05-05
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 05. 05.     김누리               Initial creation
 * 2025. 05. 05.     김누리               최초 풀이 완료
 */
public class 최소직사각형 {
	public int solution(int[][] sizes) {
		int answer = 0;
		int w = 0;
		int h = 0;

		for(int[] size : sizes) {
			w = Math.max(w,Math.max(size[0],size[1]));
			h = Math.max(h,Math.min(size[0],size[1]));
		}

		answer = w*h;

		return answer;
	}
}
