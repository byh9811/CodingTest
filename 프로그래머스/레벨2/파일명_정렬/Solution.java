package 프로그래머스.레벨2.파일명_정렬;

import java.util.Arrays;

class Name implements Comparable<Name> {
    int index;
    String head;
    String bigHead;
    String number;
    int num;
    String tail;

    public Name(int index, String head, String number, String tail) {
        this.index = index;
        this.head = head;
        this.bigHead = head.toUpperCase();
        this.number = number;
        num = Integer.parseInt(number);
        this.tail = tail;
    }

    @Override
    public int compareTo(Name o) {
        if(!bigHead.equals(o.bigHead))
            return bigHead.compareTo(o.bigHead);
        else if(num!=o.num)
            return num-o.num;
        else
            return index-o.index;
    }

    @Override
    public String toString() {
        return head + number + tail;
    }
}

public class Solution {
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        Name[] names = new Name[files.length];

        for(int i=0; i<files.length; i++) {
            String file = files[i];
            int he = getHeadEnd(file);
            int ne = getNumberEnd(file, he);

            names[i] = new Name(i, file.substring(0, he), file.substring(he, ne), ne==file.length() ? "" : file.substring(ne));
        }

        Arrays.sort(names);

        for(int i=0; i<files.length; i++)
            answer[i] = names[i].toString();

        return answer;
    }

    private int getNumberEnd(String file, int he) {
        int ret = he;

        for(; ret<file.length(); ret++) {
            char c = file.charAt(ret);
            if(c<'0' || c>'9')
                break;
        }

        return ret;
    }

    private int getHeadEnd(String file) {
        int ret = 0;

        for(char c: file.toCharArray()) {
            if(c<'0' || c>'9')
                ret++;
            else
                break;
        }

        return ret;
    }
}