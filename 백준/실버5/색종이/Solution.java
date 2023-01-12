package 백준.실버5.색종이;

import java.util.Scanner;

public class Solution {
    public void solution() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        boolean[][] map = new boolean[100][100];
        for(int i=0; i<N; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            for(int j=x; j<x+10; j++) {
                for(int k=y; k<y+10; k++) {
                    map[j][k] = true;
                }
            }
        }

        int sum = 0;
        for(int i=0; i<100; i++) {
            for(int j=0; j<100; j++) {
                if(map[i][j])
                    sum++;
            }
        }

        System.out.print(sum);
    }
}