package 백준.실버5.투명;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Solution {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<String> visited = new HashSet<>();
        String firstInput = br.readLine();
        char firstRow = firstInput.charAt(0);
        char prevRow = firstRow;
        char firstCol = firstInput.charAt(1);
        char prevCol = firstCol;
        visited.add(firstInput);

        for(int i=0; i<35; i++) {
            String input = br.readLine();
            char row = input.charAt(0);
            char col = input.charAt(1);
            int rowDif = Math.abs(row-prevRow);
            int colDif = Math.abs(col-prevCol);

            if(visited.contains(input) || rowDif==3 || colDif==3 || rowDif+colDif!=3) {
                System.out.println("Invalid");
                return;
            }

            prevRow = row;
            prevCol = col;
            visited.add(input);
        }

        int rowDif = Math.abs(firstRow-prevRow);
        int colDif = Math.abs(firstCol-prevCol);
        System.out.println(rowDif!=3 && colDif!=3 && rowDif+colDif==3 ? "Valid" : "Invalid");
    }
}