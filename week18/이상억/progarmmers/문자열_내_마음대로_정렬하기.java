/**
 * PackageName : week18.이상억.progarmmers;
 * FileName    : 문자열_내_마음대로_정렬하기
 * Author      : sangeok
 * Date        : 2025. 08. 25.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 08. 25.     sangeok               Initial creation
 */



class Solution {
    public String[] solution(String[] strings, int n) {
        return bubble_sort(strings, n);
    }

    public String[] bubble_sort(String[] strings, int n) {
        int len = strings.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                char c1 = strings[j].charAt(n);
                char c2 = strings[j + 1].charAt(n);

                if (c1 > c2) {
                    swap(strings, j, j + 1);
                }
                else if (c1 == c2 && strings[j].compareTo(strings[j + 1]) > 0) {
                    swap(strings, j, j + 1);
                }
            }
        }
        return strings;
    }

    private void swap(String[] arr, int i, int j) {
        String tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
