package 프로그래머스.레벨2.방문_길이;

public class Solution {
    public int solution(String dirs) {
        boolean[][] visitedRow = new boolean[11][10];
        boolean[][] visitedCol = new boolean[10][11];
        int locationCol = 5, locationRow = 5;
        int answer = 0;

        for(char dir: dirs.toCharArray()) {
            if(dir=='U') {
                if(locationCol==0)
                    continue;

                if(visitedCol[--locationCol][locationRow])
                    continue;

                visitedCol[locationCol][locationRow] = true;
                answer++;
            } else if(dir=='D') {
                if(locationCol==10)
                    continue;

                if(visitedCol[locationCol++][locationRow])
                    continue;

                visitedCol[locationCol-1][locationRow] = true;
                answer++;
            } else if(dir=='R') {
                if(locationRow==10)
                    continue;

                if(visitedRow[locationCol][locationRow++])
                    continue;

                visitedRow[locationCol][locationRow-1] = true;
                answer++;
            } else {
                if(locationRow==0)
                    continue;

                if(visitedRow[locationCol][--locationRow])
                    continue;

                visitedRow[locationCol][locationRow] = true;
                answer++;
            }
        }

        return answer;
    }
}