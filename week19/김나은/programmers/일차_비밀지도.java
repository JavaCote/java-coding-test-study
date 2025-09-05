package week19.김나은.programmers;

public class 일차_비밀지도 {

    class Solution {

        public String[] solution(int n, int[] arr1, int[] arr2) {

            // 2진수 변환 값 저장을 위한 배열 선언
            String[] newArr1 = new String[arr1.length];
            String[] newArr2 = new String[arr2.length];

            // answer담을 배열 선언
            String[] answer = new String[n];

            // arr1, arr2 각 배열 값 2진수로 변환
            for (int i = 0; i < arr1.length; i++) {
                newArr1[i] = toBinary(arr1[i], n);
                newArr2[i] = toBinary(arr2[i], n);
            }

            // arr1, arr2 값 비교해서 해독
            for (int i = 0; i < n; i++) {
                // 2진수를 해독한 문자 저장하기 위해 StringBuilder 선언
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    char c1 = newArr1[i].charAt(j);
                    char c2 = newArr2[i].charAt(j);

                    // 하나라도 '1'이면 '#', 아니면 공백
                    if (c1 == '1' || c2 == '1') {
                        sb.append('#');
                    } else {
                        sb.append(' ');
                    }
                }

                // 완성된 한 줄을 answer에 저장
                answer[i] = sb.toString();
            }
            return answer;
        }

        // 2진수 변환 메서드
        private static String toBinary(int num, int n) {

            StringBuilder sb = new StringBuilder();

            while (num > 0) {
                int remainder = num % 2; // 나머지 구하기
                sb.append(remainder); // int형 자동으로 String형으로 저장
                num /= 2; // 몫으로 갱신
            }

            String st = sb.reverse().toString(); // 뒤집어서 반환

            // 길이가 n보다 짧으면 앞에 '0'을 붙여서 n자리 맞추기
            while (st.length() < n) {
                st = "0" + st;
            }
            return st;
        }
    }
}