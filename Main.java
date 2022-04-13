import DFS_및_BFS.여행경로.Solution;

public class Main {
    public static void main(String[] args) {
        String[][] tickets = {{"ICN", "B"}, {"B", "ICN"}, {"ICN", "A"}, {"A", "D"}, {"D", "A"}};

        print(new Solution().solution(tickets));
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
