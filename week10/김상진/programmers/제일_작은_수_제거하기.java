package week10.김상진.programmers;

public class 제일_작은_수_제거하기 {
    class Solution {
        public int[] solution(int[] arr) {
            if (arr.length == 1) return new int[]{-1};
            int[] answer = new int[arr.length-1];
            int min=Integer.MAX_VALUE;
            for(int i=0; i<arr.length; i++){
                min= Math.min(min,arr[i]);
            }
            int index=0;
            for(int num : arr){
                if(min!=num)answer[index++]=num;
            }

            return answer;
        }
    }
}
