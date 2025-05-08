package week2.이상억.backjoon;

/**
 * PackageName : week2.이상억.backjoon
 * FileName    : 영화감독_숌
 * Author      : sangeok
 * Date        : 2025. 5. 8.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 5. 8.     sangeok               Initial creation
 */

import java.io.*;
import java.util.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int count = 0;
        int number = 666;

        while(true){
            if (String.valueOf(number).contains("666")) {
                count ++;
                if (count == n) {
                    System.out.println(number);
                    break;
                }
            }
            number++;
        }
    }
}
