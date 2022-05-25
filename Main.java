import 프로그래머스.레벨2.뉴스_클러스터링.Solution;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] int1DArr = {9, 20, 28, 18, 11};
        int[] int1DArr2 = {30, 1, 21, 17, 28};
        int[][] int2DArr = {
                {1, 1, 2, 2},
                {1, 2, 2, 3},
                {2, 1, 3, 2},
                {2, 2, 3, 3}
        };

        String[] str1DArr = {"sun", "bed", "car"};
        String[][] str2DArr = {
                {"a", "b", "c"},
                {"d", "e", "f"}
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

        print(new Solution().solution("E=M*C^2", "e=m*c^2"));
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
