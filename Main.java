import 백준.골드5.뱀과_사다리_게임.Solution;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        int[] int1DArr = {5, 3, 2, 7, 5};
        int[] int1DArr2 = {3, 4};
        int[][] int2DArr = {
                {1,1,7,4},
                {3,2,5,5},
                {4,3,6,9},
                {2,6,8,8}
        };
        int[][] int2DArr2 = {
                {3,4},
                {5,6}
        };

        String[] str1DArr = {"AN", "CF", "MJ", "RT", "NA"};
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
        long[][] long2DArr = {
                {1,2},
                {3,4}
        };

        new Solution().solution();
    }

    private static void print(Iterable<?> iterableObj) {
        for(Object obj: iterableObj)
            System.out.print(obj + " ");
    }

    private static void print(int answer) { System.out.println(answer); }
    private static void print(long answer) { System.out.println(answer); }
    private static void print(float answer) { System.out.println(answer); }
    private static void print(double answer) { System.out.println(answer); }
    private static void print(char answer) { System.out.println(answer); }
    private static void print(String answer) { System.out.println(answer); }
    private static void print(boolean answer) { System.out.println(answer); }

    private static void print(int[] answer) { System.out.println(Arrays.toString(answer)); }
    private static void print(long[] answer) { System.out.println(Arrays.toString(answer)); }
    private static void print(float[] answer) { System.out.println(Arrays.toString(answer)); }
    private static void print(double[] answer) { System.out.println(Arrays.toString(answer)); }
    private static void print(char[] answer) { System.out.println(Arrays.toString(answer)); }
    private static void print(String[] answer) { System.out.println(Arrays.toString(answer)); }
    private static void print(boolean[] answer) { System.out.println(Arrays.toString(answer)); }

    private static void print(int[][] answer) { System.out.println(Arrays.deepToString(answer)); }
    private static void print(long[][] answer) { System.out.println(Arrays.deepToString(answer)); }
    private static void print(float[][] answer) { System.out.println(Arrays.deepToString(answer)); }
    private static void print(double[][] answer) { System.out.println(Arrays.deepToString(answer)); }
    private static void print(char[][] answer) { System.out.println(Arrays.deepToString(answer)); }
    private static void print(String[][] answer) { System.out.println(Arrays.deepToString(answer)); }
    private static void print(boolean[][] answer) { System.out.println(Arrays.deepToString(answer)); }
}
