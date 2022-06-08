package 프로그래머스.레벨2.후보키;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int solution(String[][] relation) {
        Set<Integer> candidateKey = new HashSet<>();

        int rowLen = relation.length;
        int colLen = relation[0].length;

        for(int set=1; set<(1<<colLen); set++) {
            if(isMin(set, candidateKey) && isUni(set, rowLen, colLen, relation))
                candidateKey.add(set);
        }

        return candidateKey.size();
    }

    private boolean isUni(int set, int rowLen, int colLen, String[][] relation) {
        Set<String> appeared = new HashSet<>();

        for(int row=0; row<rowLen; row++) {
            StringBuilder sb = new StringBuilder();

            for(int col=0; col<colLen; col++) {
                if((set&(1<<col))!=0)
                    sb.append(relation[row][col]).append("&");
            }

            String connectedData = sb.toString();
            if(appeared.contains(connectedData))
                return false;
            else
                appeared.add(connectedData);
        }

        return true;
    }

    private boolean isMin(int set, Set<Integer> candidateKey) {
        for(int key: candidateKey) {
            if((key&set)==key)
                return false;
        }

        return true;
    }
}