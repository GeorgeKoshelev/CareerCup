/**
 * Created by george.koshelev on 12/1/2014.
 */

class Node{
    public int Val;
    public Node Left;
    public Node Right;

    public Node(int val, Node left , Node right){
        Val = val;
        Left = left;
        Right = right;
    }
}

public class Program {

    private static int Sum = 0;

    public static void main(String[] args){
        Node root = new Node(6 , new Node(3 ,null,null) , new Node(4 , new Node(1 , null , null) , null));
        PathSum(root , 0);
        System.out.println(Sum);
    }

    public static void PathSum(Node root , int sum){
        sum = sum*10+root.Val;
        if (root.Left == null && root.Right == null)
            Sum += sum;
        if (root.Left != null)
            PathSum(root.Left, sum);
        if (root.Right != null)
            PathSum(root.Right, sum);
    }

}
