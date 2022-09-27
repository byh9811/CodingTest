package 백준.실버5.판화;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String orders = br.readLine();
        char[][] board = new char[N][N];
        for(char[] row: board)
            Arrays.fill(row, '.');
        int x = 0, y = 0;

        for(char order: orders.toCharArray()) {
            if((x==0 && order=='L') || (x==N-1 && order=='R') || (y==0 && order=='U') || (y==N-1 && order=='D'))
                continue;

            changeBoard(board, x, y, order);
            switch (order) {
                case 'L': x--; break;
                case 'R': x++; break;
                case 'U': y--; break;
                default: y++;
            }
            changeBoard(board, x, y, order);
        }

        for(char[] row: board) {
            StringBuilder sb = new StringBuilder();
            for(char c: row)
                sb.append(c);
            System.out.println(sb);
        }
    }

    private void changeBoard(char[][] board, int x, int y, int order) {
        if(order=='L' || order=='R') {
            if(board[y][x]=='|')
                board[y][x] = '+';
            else if(board[y][x]=='.')
                board[y][x] = '-';
        } else {
            if(board[y][x]=='-')
                board[y][x] = '+';
            else if(board[y][x]=='.')
                board[y][x] = '|';
        }
    }
}