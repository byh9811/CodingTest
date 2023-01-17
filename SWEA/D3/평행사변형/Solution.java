package SWEA.D3.평행사변형;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
* 1. 모든 변의 길이가 N인 가장 넓은 평행사변형은 한 변의 길이가 N인 정사각형이다.
* 2. N의 제곱을 리턴하면 답이다.
* 3. 이게 왜 D3 문제지..?
* */
public class Solution {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test_case = Integer.parseInt(br.readLine());
        for (int t = 1; t <= test_case; t++) {
            int n = Integer.parseInt(br.readLine());
            System.out.printf("#%d %s\n", t, n*n);
        }
    }
}