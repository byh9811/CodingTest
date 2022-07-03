import 프로그래머스.레벨2.파일명_정렬.Solution;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] int1DArr = {9, 20, 28, 18, 11};
        int[] int1DArr2 = {30, 1, 21, 17, 28};
        int[][] int2DArr = {
                {1,1,0,0},
                {1,0,0,0},
                {1,0,0,1},
                {1,1,1,1}
        };

        String[] str1DArr = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
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

        print(new Solution().solution(str1DArr));
    }

    private static void print(Object[][] arr) {
        for(Object[] elem: arr) {
            for(Object elem2: elem)
                System.out.print(elem2 + " ");
            System.out.println();
        }
    }

    private static void print(Object[] arr) {
        for(Object elem: arr) {
            System.out.print(elem + " ");
        }
    }

    private static void print(Object o) {
        if(o.getClass().isArray()) {
            Class<?> objClass = o.getClass();
            Object[] tempArr;
            if(objClass.equals(int[].class))
                tempArr = Arrays.stream((int[])o).boxed().toArray();
            else {
                System.out.println("기본타입 배열 출력 오류");
                return;
            }
            print(tempArr);
        } else {
            System.out.println(o);
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
