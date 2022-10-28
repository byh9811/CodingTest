package 백준.실버5.수_정렬하기_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public void solution() throws Exception {
        final int MAX = 1000000;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] exist = new boolean[2*MAX+1];
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++) {
            int num = Integer.parseInt(br.readLine());
            exist[num+MAX] = true;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=2*MAX; i>=0; i--) {
            if(exist[i])
                sb.append(i-MAX).append('\n');
        }

        System.out.print(sb);
    }
}