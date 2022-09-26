package 백준.실버5.날짜_계산;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Solution {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int E = Integer.parseInt(input[0]);
        int S = Integer.parseInt(input[1]);
        int M = Integer.parseInt(input[2]);
        int EStack = 0, SStack = 0, MStack = 0, cnt = 0;

        while(EStack!=E || SStack!=S || MStack!=M) {
            EStack++;
            SStack++;
            MStack++;
            cnt++;

            if(EStack==16)
                EStack = 1;
            if(SStack==29)
                SStack = 1;
            if(MStack==20)
                MStack = 1;
        }

        System.out.println(cnt);
    }
}