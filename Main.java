import DFS_및_BFS.타겟_넘버.Solution;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {4, 1, 2, 1};

        System.out.println(new Solution().solution(numbers, 4));
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
