package week20.강성욱.baekjoon;

import java.util.ArrayList;
import java.util.List;

/**
 * PackageName : week20.강성욱.baekjoon
 * FileName    : 우박수열_정적분
 * Author      : Baekgwa
 * Date        : 2025-09-11
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-09-11     Baekgwa               Initial creation
 */
public class 우박수열_정적분 {
	class Solution {
		public double[] solution(int k, int[][] ranges) {
			List<Integer> yPointList = new ArrayList<>();
			List<Double> areaList = new ArrayList<>();
			double[] result = new double[ranges.length];

			yPointList.add(k);
			while(k != 1) {
				if(k % 2 == 0) k = k / 2;
				else k = k * 3 + 1;
				yPointList.add(k);
			}

			// 구간 별 사다리꼴? 합 먼저 구해두기
			for(int i=0; i<yPointList.size()-1; i++) {
				int a = yPointList.get(i);
				int b = yPointList.get(i + 1);
				double area = Math.min(a, b) + (Math.abs(a-b) / 2.0);
				areaList.add(area);
			}

			// 제시된 구간을, 미리 구해둔 합으로 추가하기
			for(int i=0; i<ranges.length; i++) {
				int a = ranges[i][0];
				int b = ranges[i][1];

				if(b <= 0) b = (yPointList.size()-1) + b;

				result[i] = calcArea(a, b, areaList);
			}

			return result;
		}

		private double calcArea(int a, int e, List<Double> areaList) {
			int n = areaList.size(); // 유효 인덱스: 0..n
			if (a > e) return -1.0;
			if (a < 0 || e < 0 || a > n || e > n) return -1.0;
			if (a == e) return 0.0;

			double sum = 0.0;
			for (int i = a; i < e; i++) {
				sum += areaList.get(i);
			}
			return sum;
		}
	}
}
