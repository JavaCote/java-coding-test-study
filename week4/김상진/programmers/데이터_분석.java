package week4.김상진.programmers;

import java.util.ArrayList;
import java.util.List;

/**
 * PackageName : week4.김상진.programmers
 * FileName    : 데이터_분석
 * Author      : sangxxjin
 * Date        : 2025. 5. 21.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 5. 21.     sangxxjin               Initial creation
 */
public class 데이터_분석 {
	// 문제를 보고 먼저 응답 개수를 모르니 List<int[]> 선언
	// ext에 따라 비교값도 ext로 바뀌니 데이터의 순서로 선언
	// 문제 없이 배열에 데이터 넣는 것까지 성공 했는데 정렬에 문제가 있었음.
	// 구글링 진행 -> Integer.compare
	// 정렬조건으로 sort를 사용하려면 final로 선언해야함
	import java.util.*;

	class Solution {
		public List<int[]> solution(int[][] data, String ext, int val_ext, String sort_by) {
			List<int[]> arr = new ArrayList<>();
			int search = 0;
			final int sort;

			switch (ext) {
				case "code" : search = 0; break;
				case "date" : search = 1; break;
				case "maximum" : search = 2; break;
				case "remain" : search = 3; break;
			}

			switch (sort_by) {
				case "code" : sort = 0; break;
				case "date" : sort = 1; break;
				case "maximum" : sort = 2; break;
				case "remain" : sort = 3; break;
				default: sort=0; break;
			}

			for (int[] singleData : data) {
				if (singleData[search] < val_ext) {
					arr.add(singleData);
				}
			}

			arr.sort((a, b) -> Integer.compare(a[sort], b[sort]));

			return arr;
		}
	}

}
