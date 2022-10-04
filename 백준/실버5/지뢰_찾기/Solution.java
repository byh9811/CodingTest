package 백준.실버5.지뢰_찾기;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] map = new char[N][N];
        char[][] ret = new char[N][N];

        for(int i=0; i<N; i++) {
            String input = br.readLine();
            for(int j=0; j<N; j++)
                map[i][j] = input.charAt(j);
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(map[i][j]=='.')
                    continue;

                note(ret, i, j, map[i][j]-'0');
            }
        }

        for(int i=0; i<N; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<N; j++) {
                if(ret[i][j]=='*')
                    sb.append('*');
                else if(ret[i][j]>9)
                    sb.append('M');
                else
                    sb.append((int)ret[i][j]);
            }
            System.out.println(sb);
        }
    }

    private void note(char[][] ret, int i, int j, int c) {
        boolean[] unavailable = new boolean[8];

        if(i==0) {
            for(int k=0; k<3; k++)
                unavailable[k] = true;
        }

        if(i==ret.length-1) {
            for(int k=4; k<7; k++)
                unavailable[k] = true;
        }

        if(j==0) {
            unavailable[0] = true;
            unavailable[6] = true;
            unavailable[7] = true;
        }

        if(j==ret.length-1) {
            for(int k=2; k<5; k++)
                unavailable[k] = true;
        }

        ret[i][j] = '*';
        if(!unavailable[0] && ret[i-1][j-1]!='*')
            ret[i-1][j-1] += c;
        if(!unavailable[1] && ret[i-1][j]!='*')
            ret[i-1][j] += c;
        if(!unavailable[2] && ret[i-1][j+1]!='*')
            ret[i-1][j+1] += c;
        if(!unavailable[3] && ret[i][j+1]!='*')
            ret[i][j+1] += c;
        if(!unavailable[4] && ret[i+1][j+1]!='*')
            ret[i+1][j+1] += c;
        if(!unavailable[5] && ret[i+1][j]!='*')
            ret[i+1][j] += c;
        if(!unavailable[6] && ret[i+1][j-1]!='*')
            ret[i+1][j-1] += c;
        if(!unavailable[7] && ret[i][j-1]!='*')
            ret[i][j-1] += c;
    }
}