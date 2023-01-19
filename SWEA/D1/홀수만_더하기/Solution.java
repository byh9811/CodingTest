package SWEA.D1.홀수만_더하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
* 1. 배열의 원소를 2로 나눠 1인 경우만 더한다.
* */
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test_case = Integer.parseInt(br.readLine());

        for (int t=1; t<=test_case; t++) {
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int sum = 0;
            for(int i=0; i<10; i++) {
                if(arr[i]%2==1) {
                    sum += arr[i];
                }
            }
            System.out.printf("#%d %d\n", t, sum);
        }
    }
}