package SWEA.D2.백만_장자_프로젝트;

import java.util.*;

/*
* 1. 배열을 뒤에서부터 접근하면 고점을 미리 확인할 수 있다.
* 2. 저점이라면 차이를 더하고, 다른 고점이라면 고점을 갱신한다.
* 3. n은 최대 1,000,000이고 값은 최대 10,000이므로 int형의 범위를 넘을 수 있으므로 long형으로 선언한다.
* */
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i=0; i<t; i++) {
            int n = sc.nextInt();
            long answer = 0;
            int max = 0;
            int[] arr = new int[n];
            for (int j=0; j<n; j++) {
                arr[j] = sc.nextInt();
            }

            for (int j=n-1; j>=0; j--) {
                if(arr[j]>max)
                    max = arr[j];

                answer += max - arr[j];
            }

            System.out.printf("#%d %d%n", i+1, answer);
        }

        sc.close();
    }
}