package 프로그래머스.레벨3.추석_트래픽;

public class Solution {
    public int solution(String[] lines) {
        int max = 0;
        int[] startTimes = new int[lines.length];
        int[] endTimes = new int[lines.length];

        parseLines(lines, startTimes, endTimes);

        for(int i=0; i<lines.length; i++) {
            int task = 1;

            for(int j=i+1; j<lines.length; j++) {
                if(startTimes[j]<endTimes[i]+1000)
                    task++;
            }

            max = Math.max(max, task);
        }

        return max;
    }

    private void parseLines(String[] lines, int[] startTimes, int[] endTimes) {
        for(int i=0; i<lines.length; i++) {
            int endTime = 0;
            String[] tokens = lines[i].split(" ");
            String[] timeInfo = tokens[1].split(":");

            endTime += Integer.parseInt(timeInfo[0]) * 60 * 60 * 1000;
            endTime += Integer.parseInt(timeInfo[1]) * 60 * 1000;
            endTime += (int)(Double.parseDouble(timeInfo[2]) * 1000);

            endTimes[i] = endTime;
            startTimes[i] = endTime - (int)(Double.parseDouble(tokens[2].substring(0, tokens[2].length()-1)) * 1000) + 1;
        }
    }
}