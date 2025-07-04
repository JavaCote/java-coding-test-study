package week5.김누리.programmers;

/**
 * PackageName : week5.김누리.programmers
 * FileName    : 카펫
 * Author      : 김누리(NRKim)
 * Date        : 2025-05-27
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 05. 27.     김누리(NRKim)               Initial creation
 */


/*
넓이 : brown + yellow
가로의 길이는 최소 3.
ex )

■ : 갈색
□ : 노랑

■ ■ ■
■ □ ■
■ ■ ■

■ ■ ■ ■
■ □ □ ■
■ ■ ■ ■


■ ■ ■ ■ ■ ■ ■ ■
■ □ □ □ □ □ □ ■
■ □ □ □ □ □ □ ■
■ □ □ □ □ □ □ ■
■ □ □ □ □ □ □ ■
■ ■ ■ ■ ■ ■ ■ ■

노란 타일을 감쌀 수 있는 가로의 길이 및 세로의 길이는 3

*/
public class 카펫 {
	public int[] solution(int brown, int yellow) {
		int ext = brown + yellow; // 넓이
		int w = 3; // 가로의 최소값 (기준)
		int h = 0; // 세로의 최소값

		while (true) {
			//  예 : 48 % 7 같은 경우는?
			if(ext % w != 0) w++;

			h = ext / w;

			//  (w-2) * (h-2) >> 테두리 (brown) 을 제외한 순수 내핵의 사이즈
			if ((w-2) * (h-2) == yellow) {
				return new int[] {Math.max(w,h),Math.min(w,h)};
			}

			w++; // 가로값을 늘려줌
		}
	}
}
