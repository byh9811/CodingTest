package 프로그래머스.레벨1.달리기_경주;

import java.util.*;

/*
1. 각 등수 말의 이름을 해시맵으로 기록한다.
2. 각 말의 등수도 해시맵으로 기록한다.
3. callings를 순회하며 나오는 말의 이름을 해시맵에서 찾아 둘의 해시맵 정보를 바꾼다.
5. 모든 callings에 대한 순회가 끝나면 등수 해시맵을 순회하며 새로운 result를 만들어 리턴한다.

풀이 시간: 46분 44초
*/
class Solution {
    public String[] solution(String[] players, String[] callings) {
        HashMap<Integer, String> rankName = new HashMap<>();
        HashMap<String, Integer> rankNo = new HashMap<>();
        
        for(int i=0; i<players.length; i++) {
            rankName.put(i, players[i]);
            rankNo.put(players[i], i);
        }
        
        for(String calling: callings) {
            int myNo = rankNo.get(calling);
            int aheadNo = myNo - 1;
            String aheadName = rankName.get(aheadNo);
            rankName.put(myNo, aheadName);
            rankName.put(aheadNo, calling);
            rankNo.put(calling, aheadNo);
            rankNo.put(aheadName, myNo);
        }
        
        String[] answer = new String[players.length];
        for(Map.Entry<String, Integer> entry: rankNo.entrySet()) {
            answer[entry.getValue()] = entry.getKey();
        }
        
        return answer;
    }
}