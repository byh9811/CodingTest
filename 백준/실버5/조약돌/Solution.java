package 백준.실버5.조약돌;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if(N<=4) {
            System.out.print(4);
            return;
        }

        int root = (int)Math.sqrt(N);
        if(N==root*root)
            System.out.print((root-1)*4);
        else if(N>root*root+root)
            System.out.print(root*4);
        else
            System.out.print((root*2-1)*2);
    }
}