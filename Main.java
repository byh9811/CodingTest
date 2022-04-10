import 그리디.섬_연결하기.Solution;

public class Main {
    public static void main(String[] args) {
        int[][] costs = {{0, 1, 5},{1, 2, 3},{2, 3, 3},{3, 1, 2},{3, 0, 4},{2, 4, 6},{2, 4, 6}};

        System.out.println(new Solution().solution(5, costs));
    }

    private static void print(int[][] arr) {
        for(int[] elem: arr) {
            for(int elem2: elem)
                System.out.print(elem2 + " ");
            System.out.println();
        }
    }

    private static void print(int[] arr) {
        for(int elem: arr) {
            System.out.print(elem + " ");
        }
    }
}
