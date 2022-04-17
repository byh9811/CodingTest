package 프로그래머스.고득점_Kit.해시.베스트앨범;

import java.util.*;

class Plays implements Comparable<Plays> {
    String genre;
    int plays;

    public Plays(String genre, int plays) {
        this.genre = genre;
        this.plays = plays;
    }

    public int compareTo(Plays p) {
        return plays-p.plays;
    }
}

public class Solution {
    public ArrayList<Integer> solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<String, Integer> totalPlay = new HashMap<>();
        PriorityQueue<Plays> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0; i<genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            if(!totalPlay.containsKey(genre))
                totalPlay.put(genre, 0);
            totalPlay.put(genre, totalPlay.get(genre)+play);
        }

        for(Map.Entry<String, Integer> elem: totalPlay.entrySet()) {
            pq.add(new Plays(elem.getKey(), elem.getValue()));
        }

        while(!pq.isEmpty()) {
            Plays p = pq.poll();
            String genre = p.genre;

            for(int i=0; i<2; i++) {
                int max = -1;
                int index = -1;

                for(int j=0; j<genres.length; j++) {
                    if(genres[j].equals(genre) && plays[j]>max) {
                        max = plays[j];
                        index = j;
                    }
                }

                if(index!=-1) {
                    answer.add(index);
                    plays[index] = -1;
                }
            }
        }

        return answer;
    }
}