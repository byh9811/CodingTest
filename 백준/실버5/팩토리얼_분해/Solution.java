package 백준.실버5.팩토리얼_분해;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] fac = new long[20];
        fac[0] = 1;
        for(int i=1; i<fac.length; i++)
            fac[i] = fac[i-1] * i;
        long N = Long.parseLong(br.readLine());

        if(N==0) {
            System.out.println("NO");
            return;
        }

        for(int i=19; i>=0; i--) {
            if(N>=fac[i])
                N -= fac[i];
        }

        System.out.println(N==0 ? "YES" : "NO");
    }
}