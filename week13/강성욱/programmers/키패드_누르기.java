package week13.강성욱.programmers;

import java.util.HashMap;
import java.util.Map;

/**
 * PackageName : week13.강성욱.programmers
 * FileName    : 키패드_누르기
 * Author      : Baekgwa
 * Date        : 2025-07-24
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-07-24     Baekgwa               Initial creation
 */
public class 키패드_누르기 {
	//빡구현?
	//numbers 를 order 로 구분해서 진행
	//[1, 4, 7], [3, 6, 9] 는 상관없고
	//[2, 5, 8, 0] 이 들어오면, left, right 손가락 위치 맞춰서 최소 거리 계산하기.
	//같으면 주력 손에 따라서 구분.

	//최소 이동거리를 계산하기?
	//가장 쉬운건 bfs긴함. 근데 이미 고정된 숫자인데, 계산식으로 어케 안되려나?
	//현재 좌표는 pos으로 계속 관리를 하니, 키패드별 구조를 map으로 관리해두면 바로 쏙쏙 나오니 좋을듯? Map 쓰자

	class Solution {
		public String solution(int[] numbers, String hand) {
			int[] leftPos = new int[]{0, 3}; //x, y 순서
			int[] rightPos = new int[]{2, 3}; //x, y 순서
			Map<Integer, Integer[]> phone = new HashMap<>(); //key : 키패드, value : 키패드 좌표, [x, y]
			String LEFT = "L";
			String RIGHT = "R";

			//키패드 좌표 저장
			phone.put(1, new Integer[]{0, 0}); phone.put(2, new Integer[]{1, 0}); phone.put(3, new Integer[]{2, 0});
			phone.put(4, new Integer[]{0, 1}); phone.put(5, new Integer[]{1, 1}); phone.put(6, new Integer[]{2, 1});
			phone.put(7, new Integer[]{0, 2}); phone.put(8, new Integer[]{1, 2}); phone.put(9, new Integer[]{2, 2});
			phone.put(0, new Integer[]{1, 3});

			StringBuilder sb = new StringBuilder();

			//현재 좌표 기반, numbers 누르기 시작
			for (int order : numbers) {
				switch (order) {
					case 1: case 4: case 7:
						updateHandPos(LEFT, order, leftPos, rightPos, phone);
						sb.append(LEFT);
						continue;
					case 3: case 6: case 9:
						updateHandPos(RIGHT, order, leftPos, rightPos, phone);
						sb.append(RIGHT);
						continue;
				}

				//여기부터는, 비교 작업 필요
				//2, 5, 8, 0 일경우
				int leftCnt = calculateCnt(leftPos, phone.get(order));
				int rightCnt = calculateCnt(rightPos, phone.get(order));

				if(leftCnt == rightCnt) {
					if(hand.equals("right")) {
						updateHandPos(RIGHT, order, leftPos, rightPos, phone);
						sb.append("R");
					} else {
						updateHandPos(LEFT, order, leftPos, rightPos, phone);
						sb.append("L");
					}
				} else if(leftCnt < rightCnt) {
					updateHandPos(LEFT, order, leftPos, rightPos, phone);
					sb.append("L");
				} else {
					updateHandPos(RIGHT, order, leftPos, rightPos, phone);
					sb.append("R");
				}
			}

			return sb.toString();
		}

		private int calculateCnt(int[] nowPos, Integer[] targetPos) {
			return Math.abs(nowPos[0] - targetPos[0]) + Math.abs(nowPos[1] - targetPos[1]);
		}

		//손에 따라서, 현재 손, 타겟 포지션으로 업데이트
		private void updateHandPos(String hand, int target, int[] leftPos, int[] rightPos, Map<Integer, Integer[]> phone) {
			Integer[] pos = phone.get(target);
			if(hand.equals("L")) {
				leftPos[0] = pos[0];
				leftPos[1] = pos[1];
			} else {
				rightPos[0] = pos[0];
				rightPos[1] = pos[1];
			}
		}
	}
}
