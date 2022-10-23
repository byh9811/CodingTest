package 백준.실버5.중복_빼고_정렬하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public void solution() throws Exception {
        final int MAX = 2001;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[] isExist = new boolean[MAX];
        String[] input = br.readLine().split(" ");

        for(int i=0; i<N; i++)
            isExist[Integer.parseInt(input[i])+1000] = true;

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<MAX; i++) {
            if(isExist[i])
                sb.append(i-1000).append(' ');
        }

        System.out.println(sb);
    }
}