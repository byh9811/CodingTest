package 백준.골드5.이진_검색_트리;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Node {
    int num;
    Node left;
    Node right;

    public Node(int num) {
        this.num = num;
    }

    public void insert(int num) {
        if(num>this.num) {
            if(right==null)
                right = new Node(num);
            else
                right.insert(num);
        } else {
            if(left==null)
                left = new Node(num);
            else
                left.insert(num);
        }
    }
}

public class Solution {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Node root = new Node(Integer.parseInt(br.readLine()));
        while(true) {
            String input = br.readLine();
            if(input==null || input.length()==0)
                break;
            root.insert(Integer.parseInt(input));
        }

        postOrder(root);
    }

    private void postOrder(Node node) {
        if(node==null)
            return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.num);
    }
}