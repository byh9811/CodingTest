package 프로그래머스.레벨2.주차_요금_계산;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
    public int[] solution(int[] fees, String[] records) {
        ArrayList<String> visited = new ArrayList<>();
        HashMap<String, Integer> parkingLot = new HashMap<>();
        HashMap<String, Integer> totalParking = new HashMap<>();

        for(String record: records) {
            String[] strArr = record.split(" ");
            int time = timeToInt(strArr[0]);
            String name = strArr[1];
            String action = strArr[2];

            if(action.equals("IN")) {
                if(!totalParking.containsKey(name)) {
                    totalParking.put(name, 0);
                    visited.add(name);
                }
                parkingLot.put(name, time);
            } else
                totalParking.put(name, totalParking.get(name) + time - parkingLot.remove(name));
        }

        for(String name: parkingLot.keySet())
            totalParking.put(name, totalParking.get(name) + timeToInt("23:59") - parkingLot.get(name));

        int[] answer = new int[visited.size()];
        visited.sort(null);

        for(int i=0; i<visited.size(); i++)
            answer[i] = timeToFee(fees, totalParking.get(visited.get(i)));

        return answer;
    }

    private int timeToFee(int[] fees, int parkingTime) {
        if(parkingTime<=fees[0])
            return fees[1];

        parkingTime -= fees[0];
        if(parkingTime%fees[2]==0)
            return fees[1] + (parkingTime/fees[2])*fees[3];
        else
            return fees[1] + (parkingTime/fees[2]+1)*fees[3];
    }

    private int timeToInt(String time) {
        return Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(3));
    }
}