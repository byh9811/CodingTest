package 실전용;

import 유틸.Utils;

import java.io.IOException;
import java.util.*;

import static java.lang.Integer.parseInt;

/**
 *
 *
 */
public class Main {

    public static void main(String[] args) throws IOException {
//        System.out.println(solution(), 2, 3));
    }

//    // 3번
//    public String[] solution(String[] merchantNames) {
//        Set<String> set = new HashSet<>();
//        for (String merchantName : merchantNames) {
//            boolean updated = false;
//            String pureName = pureString(merchantName);
//            for (String elem : set) {
//                String pureElem = pureString(elem);
//                System.out.println("elem = " + elem);
//                System.out.println("pureElem = " + pureElem);
//                System.out.println("merchantName = " + merchantName);
//                System.out.println("pureName = " + pureName);
//                if(pureElem.length() < pureName.length())
//                    System.out.println("pureName.substring(0, pureElem.length()+1) = " + pureName.substring(0, pureElem.length()));
//                if(pureElem.length() > pureName.length())
//                System.out.println("pureElem.substring(0, pureName.length()+1) = " + pureElem.substring(0, pureName.length()));
//                if ((pureElem.length() < pureName.length() && pureName.substring(0, pureElem.length()).equals(pureElem)) ||
//                        (pureElem.length() > pureName.length() && pureElem.substring(0, pureName.length()).equals(pureName)) ||
//                        (pureElem.equals(pureName))) {       // 똑같은 점포면
//                    if (compareLength(elem, merchantName) < 0) {       // 새로운 점포 이름이 기존보다 길면 교체
//                        System.out.println("replaced");
//                        set.remove(elem);
//                        set.add(merchantName);
//                    }
//
//                    updated = true;
//                    break;
//                }
//            }
//
//            // 끝까지 똑같은 점포가 없으면
//            if(!updated)
//                set.add(merchantName);
//        }
//
//        return set.toArray(new String[0]);
//    }
//
//    private static String pureString(String name) {
//        return name.replaceAll("[\\&\\(\\)\\.\\,\\-\\s]", "");
//    }
//
//    private static int compareLength(String origin, String newOne) {
//        int originLen = origin.replaceAll(" ", "").length();
//        int newOneLen = newOne.replaceAll(" ", "").length();
//
//        return originLen-newOneLen;
//    }

//      2번
    public static int solution(int[][] relationships, int target, int limit) {
        Set<Integer> friends = new HashSet<>();
        friends.add(target);
        int score = 0;
        int oldFriendNum = 0;

        for (int t = 0; t < limit; t++) {
            HashSet<Integer> newFriends = new HashSet<>(friends);
            for (int[] relationship : relationships) {
                if (friends.contains(relationship[0]) && !newFriends.contains(relationship[1])) {      // 현재 친구인 앞사람 - 아직 친구가 아닌 뒷사람
                    if (t == 0) {
                        score += 5;
                        oldFriendNum++;
                    } else {
                        score += 10;
                    }
                    newFriends.add(relationship[1]);
                } else if (friends.contains(relationship[1]) && !newFriends.contains(relationship[0])) {      // 아직 친구가 아닌 앞사람 - 현재 친구인 뒷사람
                    if (t == 0) {
                        score += 5;
                        oldFriendNum++;
                    } else {
                        score += 10;
                    }
                    newFriends.add(relationship[0]);
                }
            }

            friends = newFriends;
            System.out.println("friends = " + friends);
            System.out.println("score = " + score);
        }

        return score + friends.size() - oldFriendNum - 1;
    }

//      1번
    public static int solution(String s, int N) {
        int head = 0;
        int max = -1;

        while(head+N<=s.length()) {
            String sub = s.substring(head, head+N);
            if(isFanDigital(sub)) {
                max = Math.max(max, Integer.parseInt(sub));
            }

            head++;
        }

        return max;
    }

    private static boolean isFanDigital(String s) {
        boolean[] visited = new boolean[10];
        int idx = 0;
        while(idx<s.length()) {
            visited[s.charAt(idx++) - '0'] = true;
        }


        for (int i = 1; i <= s.length(); i++) {
            if(!visited[i]) {
                return false;
            }
        }

        return true;
    }

}