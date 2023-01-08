package SWEA.D2.Sum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
* 1. 행, 열, 대각선의 합을 각각 계산한다.
* 2. 모든 계산이 끝나면 가장 큰 값을 형식에 맞게 출력한다.
* */
public class Solution {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t=1; t<=10; t++) {
            int test_case = Integer.parseInt(br.readLine());
            int answer = Integer.MIN_VALUE;
            int[] colDP = new int[100];
            int leftDiag = 0;
            int rightDiag = 0;

            for(int i=0; i<100; i++) {
                int row = 0;
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<100; j++) {
                    int cur = Integer.parseInt(st.nextToken());
                    row += cur;
                    colDP[j] += cur;
                    if(i==j)
                        leftDiag += cur;
                    if(i==99-j)
                        rightDiag += cur;
                }
                answer = Math.max(answer, row);
            }

            for(int i=0; i<100; i++)
                answer = Math.max(answer, colDP[i]);

            if(answer<leftDiag)
                answer = leftDiag;

            if(answer<rightDiag)
                answer = rightDiag;

            System.out.printf("#%d %d\n", test_case, answer);
        }
    }
}