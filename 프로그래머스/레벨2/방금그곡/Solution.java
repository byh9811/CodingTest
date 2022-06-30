package 프로그래머스.레벨2.방금그곡;

public class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int maxPlayTime = 0;
        m = convert(m);

        for(String musicinfo: musicinfos) {
            String[] infos = musicinfo.split(",");
            String melody = convert(infos[3]);
            int melodyLen = melody.length();
            int playTime = (Integer.parseInt(infos[1].substring(0, 2))-Integer.parseInt(infos[0].substring(0, 2)))*60 +
                            Integer.parseInt(infos[1].substring(3, 5))-Integer.parseInt((infos[0].substring(3, 5)));

            String newMelody = "";
            if(playTime>=melodyLen) {
                for(int i=0; i<playTime/melodyLen; i++)
                    newMelody += melody;
            }
            newMelody += melody.substring(0, playTime%melodyLen);

            if(newMelody.contains(m) && playTime>maxPlayTime) {
                answer = infos[2];
                maxPlayTime = playTime;
            }
        }

        return answer;
    }

    private String convert(String m) {
        String ret = m;

        ret = ret.replaceAll("C#", "c");
        ret = ret.replaceAll("D#", "d");
        ret = ret.replaceAll("F#", "f");
        ret = ret.replaceAll("G#", "g");
        ret = ret.replaceAll("A#", "a");

        return ret;
    }
}