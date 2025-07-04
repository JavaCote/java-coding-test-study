package week3.김상진.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * PackageName : week3.김상진.baekjoon
 * FileName    : 블랙잭
 * Author      : sangxxjin
 * Date        : 2025. 5. 16.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 5. 16.     sangxxjin               Initial creation
 */
public class 블랙잭 {
	// StringTokenizer 구글링
	// 입력의 크기가 작으면 브루트포스 가능
	// N개 중 M개를 골라서 조건에 맞는 최댓값/최솟값을 구하라 -> 모든 조합 탐색 필요
	import java.io.*;
	import java.util.*;
	public class Main {
		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			int[] arr = new int[N];
			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int max = 0;
			for(int i=0; i<N-2; i++){
				if(arr[i]>M)continue;
				for(int j=i+1; j<N-1; j++){
					if((arr[i]+arr[j])>M)continue;
					for(int k=j+1; k<N; k++){
						if((arr[i]+arr[j]+arr[k])<= M &&(arr[i]+arr[j]+arr[k])>max ){
							max = arr[i]+arr[j]+arr[k];
						}
					}
				}
			}
			System.out.println(max);
		}
	}
}
