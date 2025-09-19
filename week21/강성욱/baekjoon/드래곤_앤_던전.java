package week21.강성욱.baekjoon;

import java.util.Scanner;

/**
 * PackageName : week21.강성욱.baekjoon
 * FileName    : 드래곤_앤_던전
 * Author      : Baekgwa
 * Date        : 2025-09-19
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-09-19     Baekgwa               Initial creation
 */
public class 드래곤_앤_던전 {
	public class Main {

		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);

			long roomCount = sc.nextLong();
			long manPower = sc.nextLong();
			long[][] roomInfo = new long[(int)roomCount][3];
			long left = 1;
			long right = 0;
			long result = 0;

			for(int i=0; i<roomCount; i++) {
				roomInfo[i][0] = sc.nextInt(); // 몬스터방 = 1, 포션방 = 2
				roomInfo[i][1] = sc.nextInt(); // 몬스터 공격력, 용사 추가 공격력
				roomInfo[i][2] = sc.nextInt(); // 몬스터 체력, 용사 추가 체력(max = 최대생명력)
				if(roomInfo[i][0] == 1) {
					right += (roomInfo[i][2] * roomInfo[i][1]);
				}
			}

			while(left <= right) {
				long mid = left + (right-left) / 2;

				if(isPossible(mid, manPower, roomCount, roomInfo)) {
					result = mid;
					right = mid-1;
				}
				else {
					left = mid + 1;
				}
			}

			System.out.println(result);
		}

		private static boolean isPossible(long maxHp, long manPower, long roomCount, long[][] roomsInfo) {
			long nowHp = maxHp;
			for(long[] roomInfo : roomsInfo) {
				long roomType = roomInfo[0];

				if(roomType == 1) {
					long monsterPower = roomInfo[1];
					long monsterHp = roomInfo[2]; //100

					//공격 횟수 체크
					long manAttackCount = monsterHp / manPower;
					long monsterAttackCount = 0;
					long nano = monsterHp % manPower;
					if(nano > 0){
						manAttackCount += 1;
					}
					monsterAttackCount = manAttackCount - 1;

					//실제 감소 적용
					if(nowHp - (monsterAttackCount * monsterPower) <= 0) return false;
					nowHp = nowHp - (monsterAttackCount * monsterPower);
				}
				else {
					manPower += roomInfo[1];
					nowHp = Math.min(nowHp + roomInfo[2], maxHp);
				}
			}

			return nowHp > 0;
		}
	}
}
