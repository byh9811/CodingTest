import 프로그래머스.레벨2.하노이의_탑.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        int[] int1DArr = {1, 2};
        int[] int1DArr2 = {3, 4};
        int[][] int2DArr = {
                {1,2,3,5},
                {5,6,7,8},
                {4,3,2,1}
        };

        String[] str1DArr = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        String[][] str2DArr = {
                {"100","ryan","music","2"},
                {"200","apeach","math","2"},
                {"300","tube","computer","3"},
                {"400","con","computer","4"},
                {"500","muzi","music","3"},
                {"600","apeach","music","2"}
        };

        boolean[] bool1DArr = {true,false,true};
        boolean[][] bool2DArr = {
                {true, true, true},
                {false, false, false}
        };

        char[] char1DArr = {'a', 'b', 'c'};
        char[][] char2DArr = {
                {'a', 'a', 'a'},
                {'a', 'a', 'a'}
        };

        long[] long1DArr = {2,7};

        print(new Solution().solution(2));
    }

    private static void print(Iterable<?> iterableObj) {
        for(Object obj: iterableObj)
            System.out.print(obj + " ");
    }

    private static void print(Object obj) {
        Class<?> objClass = obj.getClass();
        if(objClass.isArray()) {
            print(Arrays.stream((Object[])obj).collect(Collectors.toList()));
        } else {
            System.out.print(obj);
        }
    }

    public static boolean isBaseTypeOrArray(boolean obj) {return true;}
    public static boolean isBaseTypeOrArray(byte obj) {return true;}
    public static boolean isBaseTypeOrArray(short obj) {return true;}
    public static boolean isBaseTypeOrArray(char obj) {return true;}
    public static boolean isBaseTypeOrArray(int obj) {return true;}
    public static boolean isBaseTypeOrArray(long obj) {return true;}
    public static boolean isBaseTypeOrArray(float obj) {return true;}
    public static boolean isBaseTypeOrArray(double obj) {return true;}
}
