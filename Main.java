import 정렬.H_Index.Solution;

public class Main {
    public static void main(String[] args) {
        int[] answers = {3, 0, 6, 1, 5};

        System.out.println(new Solution().solution(answers));
    }

    private static void print(int[][] arr) {
        for(int[] elem: arr) {
            for(int elem2: elem)
                System.out.print(elem2 + " ");
            System.out.println();
        }
    }

    private static void print(String[] arr) {
        for(String elem: arr) {
            System.out.print(elem + " ");
        }
    }
}
