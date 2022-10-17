package 백준.실버5.숫자_카드;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int range = 10000000;
        boolean[] card = new boolean[range*2+1];
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        for(int i=0; i<N; i++)
            card[Integer.parseInt(input[i])+range] = true;

        int M = Integer.parseInt(br.readLine());
        String[] input2 = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++)
            sb.append(card[Integer.parseInt(input2[i])+range] ? 1 : 0).append(' ');

        System.out.print(sb);
    }
}