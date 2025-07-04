package week4.김나은.programmers;

import java.util.Arrays;

public class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        // 기본적으로 체육복을 잃어버린 학생 수만큼 전체 학생 수에서 빼서 시작
        int answer = n - lost.length;

        // 체육복을 잃어버린 학생들과 여벌이 있는 학생들을 정렬 (순서대로 비교하기 위해)
        Arrays.sort(lost);
        Arrays.sort(reserve);

        // 1단계: 여벌 체육복이 있지만 본인이 도난당한 경우 처리
        // 이 경우 자기 체육복을 자기가 입는 거기 때문에 빌려줄 수 없음
        for(int i = 0; i < lost.length; i++) {
            for(int j = 0; j < reserve.length; j++) {
                if(lost[i] == reserve[j]) {
                    // 본인이 잃어버렸지만 여벌도 가진 경우
                    answer++; // 체육수업 참여 가능하므로 +1
                    lost[i] = -1; // 더 이상 도난당한 학생 아님 처리 (비교에서 제외)
                    reserve[j] = -1; // 여벌도 없어진 것으로 처리 (비교에서 제외)
                    break; // 더 이상 비교할 필요 없으므로 종료
                }
            }
        }

        // 2단계: 남은 lost 배열에 대해 여벌 체육복이 있는 학생이 앞뒤 번호면 빌려주는 로직
        for(int i = 0; i < lost.length; i++) {
            if(lost[i] == -1) continue; // 이미 해결된 학생은 건너뜀
            for(int j = 0; j < reserve.length; j++) {
                if(reserve[j] == -1) continue; // 이미 여벌 사용한 경우 건너뜀
                // 자기 앞번호 또는 뒷번호인 학생에게만 빌릴 수 있음
                if((lost[i]-1 == reserve[j]) || (lost[i]+1 == reserve[j])) {
                    answer++; // 체육수업 참여 가능하므로 +1
                    reserve[j] = -1; // 해당 여벌 사용 처리
                    break; // 현재 lost 학생은 해결됐으므로 종료
                }
            }
        }

        return answer; // 최종적으로 체육수업에 참여 가능한 학생 수 반환
    }
}