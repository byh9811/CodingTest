package SWEA.D2.두_개의_숫자열;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
* 1. 크기가 작은 배열을 크기가 큰 배열에 맞춰 계산한다.
* 2. 더이상 맞출 수 없을때 계산한 값 중 가장 큰 값을 출력한다.
* 3. 음수가 나올 수 있으므로 가장 작은 수로 초기화한다. (Long형은 배제한다)
* */
public class Solution {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);
            int[] Narr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] Marr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] bigArr = N>M ? Narr : Marr;
            int[] smallArr = N>M ? Marr : Narr;

            int answer = Integer.MIN_VALUE;
            int padding = 0;
            while(smallArr.length+padding<=bigArr.length) {
                int sum = 0;
                for(int i=0; i<smallArr.length; i++)
                    sum += smallArr[i] * bigArr[i+padding];
                answer = Math.max(answer, sum);
                padding++;
            }

            System.out.printf("#%d %d\n", test_case, answer);
        }
    }
}