import DFS_및_BFS.단어_변환.Solution;

public class Main {
    public static void main(String[] args) {
        String[] puddles = {"hot", "dot", "dog", "lot", "log"};

        System.out.println(new Solution().solution("hit", "cog", puddles));
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
