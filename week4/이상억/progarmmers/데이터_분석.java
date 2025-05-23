package week4.이상억.progarmmers;

/**
 * PackageName : week4.이상억.progarmmers;
 * FileName    : 과일_장수
 * Author      : sangeok
 * Date        : 2025. 5. 20.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 5. 20.     sangeok               Initial creation
 */


//  문제 요구사항 : 	[ "코드번호" , "제조일" , 최대 수량", "현재 수량"] 을 구성
//    이 데이터들을 조건을 만족하는 데이터만 뽑아서 정렬
//      ext : 어떤 정보를 기준으로 데이터를 뽑아낼지를 의미하는 문자열
//      val_ext : 뽑아낼 정보의 기준값을 나타내는 정수
//      sort_by : 정보를 정렬할 기준이 되는 문자열
//      => data에서 ext 값이 val_ext 보다 작은 데이터만 뽑은 후 sort_by에 해당하는 값을 기준으로 오름차순

//  접근 방식 :     (1) 그냥 별 생각 없이 저 위에 요구사항 하드 코딩
//                 (2) hashmap 으로 string : integer 짝 지어서 작성

//  회고 : 이 방식으로 풀어서 제출 했는데 되긴 했는데 이건 좀 아닌거 같아서 다시 다른 방법 생각해서 풀기
//          list 정렬 하는 방식이 잘 기억나지 않아 검색하였다.
import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<int[]> list = new ArrayList<>();

        Map<String,Integer> column = Map.of(
                "code" , 0,
                "date" , 1,
                "maximum", 2,
                "remain", 3
        );

        int col = column.getOrDefault(ext, -1);
        int sortcol = column.getOrDefault(sort_by, -1);

        for (int[] row : data) {
            if (row[col] < val_ext) {
                list.add(row);
            }
        }

        list.sort(Comparator.comparingInt(row -> row[sortcol]));

        int[][] answer = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}


//import java.util.*;
//
//class Solution {
//    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
//
//        List<int[]> list = new ArrayList<>();
//
//        switch (ext) {
//            case "code":
//                for(int i = 0; i<data.length; i++){
//                    if(data[i][0] < val_ext ) list.add(data[i]);
//                }
//                break;
//
//            case "date":
//                for(int i = 0; i<data.length; i++){
//                    if(data[i][1] < val_ext ) list.add(data[i]);
//                }
//
//                break;
//            case "maximum":
//                for(int i = 0; i<data.length; i++){
//                    if(data[i][2] < val_ext ) list.add(data[i]);
//                }
//                break;
//            case "remain":
//                for(int i = 0; i<data.length; i++){
//                    if(data[i][3] < val_ext ) list.add(data[i]);
//                }
//                break;
//            default:
//                System.out.println("기타 처리");
//        }
//
//        switch (sort_by) {
//            case "code":
//                bubblesort(list,0);
//                break;
//            case "date":
//                bubblesort(list,1);
//                break;
//            case "maximum":
//                bubblesort(list,2);
//                break;
//            case "remain":
//                bubblesort(list,3);
//                break;
//            default:
//                System.out.println("기타 처리");
//        }
//
//        int[][] answer = new int[list.size()][];
//
//        for (int i = 0; i < list.size(); i++) {
//            answer[i] = list.get(i);
//        }
//        return answer;
//    }
//
//    public void bubblesort(List<int[]> list, int sortcol){
//        int n = list.size();
//
//        for(int i = 0; i < n - 1 ; i++){
//            for(int j = 0; j < n - 1 - i; j++){
//                if(list.get(j)[sortcol] > list.get(j+1)[sortcol]){
//                    int[] temp = list.get(j);
//                    list.set(j, list.get(j+1));
//                    list.set(j+1, temp);
//                }
//            }
//        }
//    }
//}