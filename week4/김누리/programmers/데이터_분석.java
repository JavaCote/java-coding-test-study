package week4.김누리.programmers;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * PackageName : week4.김누리.programmers
 * FileName    : 데이터_분석
 * Author      : 김누리(NRKim)
 * Date        : 2025-05-21
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 05. 21.     김누리(NRKim)               Initial creation
 */


/*
    List<int[]> a이용

    //  정렬 및 타겟 인덱스에서 이용 가능 idx
    data[i][0] = code    target_idx = 0;
    data[i][1] = date    target_idx = 1;
    data[i][2] = maximum target_idx = 2;
    data[i][3] = remain  target_idx = 3;

    입츨력 데이터 형태
    data = [
        [1, 20300104, 100, 80],
        [2, 20300804, 847, 37],
        [3, 20300401, 10, 8]
    ]

    //  1.  타켓 인덱스 및 정렬 인덱스 셋팅
    switch(ext)
        case "code" :
            ext_idx = 0;
            break;

        case "date" :
            ext_idx = 1;
            break;

        case "maximum" :
            ext_idx = 2;
            break;

        case "remain" :
            ext_idx = 3;
            break;

        default :
            break;


    switch(sort_by)
        case "code" :
            sorted_idx = 0;
            break;

        case "date" :
            sorted_idx = 1;
            break;

        case "maximum" :
            sorted_idx = 2;
            break;

        case "remain" :
            sorted_idx = 3;
            break;

        default :
            break;

    //  2.  인덱스 값에 맞춰 리스트 생성
    for(int[] d : data) {
        if(d[ext_idx] <= val_ext) {
            a에 d 입력
        }
    }

    //  3.  정렬 후 답안 제출
    Collections.sort(a, Comparator.comparingInt(o -> o[sort_idx]));

*/
public class 데이터_분석 {
	public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
		int ext_idx = 0; //  ext의 위치를 잡기 위한 idx
		int sorted_idx = 0; //  order by 대상 위치를 잡기 위한 idx
		List<int[]> a = new LinkedList<>();

		//  ext의 위치 setting
		switch(ext) {
			case "code" :
				ext_idx = 0;
				break;

			case "date" :
				ext_idx = 1;
				break;

			case "maximum" :
				ext_idx = 2;
				break;

			case "remain" :
				ext_idx = 3;
				break;

			default :
				break;
		}

		//  order by 대상 위치의 위치 setting
		switch(sort_by) {
			case "code" :
				sorted_idx = 0;
				break;

			case "date" :
				sorted_idx = 1;
				break;

			case "maximum" :
				sorted_idx = 2;
				break;

			case "remain" :
				sorted_idx = 3;
				break;

			default :
				break;
		}

		//  ext 대상에 맞는 데이터들만 List<int[]>에 취합
		for (int[] d : data) {
			if(d[ext_idx] <= val_ext) a.add(d);
		}

		//  idx를 고정해야, Collections 명령어 통해 정렬 가능
		final int sortIndex = sorted_idx;
		Collections.sort(a, Comparator.comparingInt(o -> o[sortIndex]));

		int[][] answer = new int[a.size()][];
		int idx = 0;

		for(int[] av : a) {
			answer[idx++] = av;
		}

		return answer;
	}
}
