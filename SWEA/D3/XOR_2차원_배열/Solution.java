package SWEA.D3.XOR_2차원_배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
* 1. 모든 행이 이전 행과 XOR 연산을 했을 때 1이 나오면 XOR 2차원 배열이 된다.
* 2. 따라서 이전 행을 저장하고 n-1번 비교하여 확인한다.
* 3. 이 문제는 c와 c++로만 디버깅을 지원하지만 자바로 만들어보았다.
* */
public class Solution {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n, m;
    public void solution() throws Exception {
        int test_case = Integer.parseInt(br.readLine());
        for (int t = 1; t <= test_case; t++) {
            String[] input = br.readLine().split(" ");
            n = Integer.parseInt(input[0]);
            m = Integer.parseInt(input[1]);
            int[] prev = new int[m];
            String input2 = br.readLine();
            for(int i=0; i<m; i++) {
                prev[i] = input2.charAt(i);
            }
            System.out.printf("#%d %s\n", t, isXOR(prev) ? "yes" : "no");
        }
    }

    private boolean isXOR(int[] prev) throws IOException {
        for(int i=0; i<n-1; i++) {
            String input3 = br.readLine();
            for(int j=0; j<m; j++) {
                if((input3.charAt(j)^prev[j])==0) {
                    return false;
                }
                prev[j] ^= 1;
            }
        }
        return true;
    }
}