package week19.강성욱.programmers;

/**
 * PackageName : week19.강성욱.programmers
 * FileName    : 비밀지도
 * Author      : Baekgwa
 * Date        : 2025-09-05
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-09-05     Baekgwa               Initial creation
 */
public class 비밀지도 {
	class Solution {
		public String[] solution(int n, int[] arr1, int[] arr2) {
			int max = arr1.length;
			String[] map = new String[max];

			for(int idx=0; idx<arr1.length; idx++) {
				String a = Integer.toString(arr1[idx], 2); //이렇게만 하니깐, 9를 01001 로 써야하는데, 1001 로 해서, index out bound exception 발생
				while(a.length() < max) a = '0' + a;
				String b = Integer.toString(arr2[idx], 2);
				while(b.length() < max) b = '0' + b;

				StringBuilder sb = new StringBuilder();
				for(int i=0; i < a.length(); i++) {
					if(a.charAt(i) == '1' || b.charAt(i) == '1') {
						sb.append(1);
					} else {
						sb.append(0);
					}
				}
				String row = sb.toString().replace('1', '#').replace('0', ' ');
				map[idx] = row;
			}

			return map;
		}
	}
}
