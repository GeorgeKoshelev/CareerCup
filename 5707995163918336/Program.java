import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by george.koshelev on 12/1/2014.
 */
public class Program {
    public static void main(String[] args){
        int[][] desk = new int[][]{
                new int[]{0,0,1,0},
                new int[]{0,0,1,1},
                new int[]{1,1,0,0},
                new int[]{0,1,1,1}
        };
        FindClusters(desk , 4 , 4);
    }

    public static int[] xMoves = new int[]{-1, 0, 1, 0};
    public static int[] yMoves = new int[]{0, -1, 0, 1};

    public static Boolean inBorders(int x , int y ,int n , int m){
        return (0 <= x && x < n && 0 <= y && y < m);
    }

    public static void DFS(int[][] desk , int x , int y , int n , int m){
        if (desk[x][y] == 0)
            return;
        Queue<Pair<Integer,Integer>> queue = new LinkedList<Pair<Integer,Integer>>(){};
        queue.add(new Pair<Integer, Integer>(x , y));
        List<Pair<Integer,Integer>> cluster = new ArrayList<Pair<Integer,Integer>>();
        while(!queue.isEmpty()){
            Pair<Integer,Integer> current = queue.remove();
            desk[current.getKey()][current.getValue()] = 0;
            cluster.add(current);
            for (int i = 0 ; i < 4; i++){
                x = current.getKey() + xMoves[i];
                y = current.getValue() + yMoves[i];
                if (inBorders(x , y , n , m) && desk[x][y] != 0)
                    queue.add(new Pair<Integer, Integer>(x , y));
            }
        }
        for (Pair<Integer,Integer> cell : cluster){
            System.out.printf("(%d %d) " , cell.getKey() , cell.getValue());
        }
        System.out.println();
    }

    public static void FindClusters(int[][] desk , int n , int m){
        for (int x = 0 ; x < n ; x++){
            for (int y = 0; y < m ; y++){
                DFS(desk , x , y , n , m);
            }
        }
    }
}


