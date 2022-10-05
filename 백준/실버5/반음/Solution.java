package 백준.실버5.반음;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] whiteKeyBoard = {0, 2, 4, 5, 7, 9, 11};
        ArrayList<String> answer = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        boolean[] available = new boolean[12];
        for(int keyBoard: whiteKeyBoard)
            available[keyBoard] = true;
        int[] sheetMusic = new int[n];
        for(int i=0; i<n; i++)
            sheetMusic[i] = Integer.parseInt(br.readLine());

        for(int keyBoard: whiteKeyBoard) {
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<sheetMusic.length; i++) {
                if(i==0)
                    sb.append(convert(keyBoard));

                keyBoard += sheetMusic[i];
                while(keyBoard<0)
                    keyBoard += 12;
                while(keyBoard>11)
                    keyBoard -= 12;
                if(!available[keyBoard])
                    break;

                if(i==sheetMusic.length-1)
                    sb.append(" " + convert(keyBoard));
            }

            if(sb.length()==3)
                answer.add(sb.toString());
        }

        answer.sort(null);
        for(String elem: answer)
            System.out.println(elem);
    }

    private char convert(int keyBoard) {
        switch (keyBoard) {
            case 0: return 'C';
            case 2: return 'D';
            case 4: return 'E';
            case 5: return 'F';
            case 7: return 'G';
            case 9: return 'A';
            default: return 'B';
        }
    }
}