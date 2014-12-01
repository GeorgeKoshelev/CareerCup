import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by george.koshelev on 12/1/2014.
 */

public class Program {
    public static void main(String[] args){
        FindPairsWithSum(Arrays.asList(new Integer[]{1,2,39,34,4,5,6,1,8,21,3,20,4,5,6,1,2,3,4,5,6}) , 7);
    }

    public static void FindPairsWithSum(List<Integer> arr, int sum){
        if (arr == null || arr.size() < 2 || sum < 0)
            return;
        HashMap<Integer,Integer> hash = new HashMap<Integer, Integer>();
        arr.forEach(
                (Integer value) -> {
                    if (value < sum)
                        hash.put(value, hash.containsKey(value)? hash.get(value)+1 : 1);
                });
        hash.keySet().forEach((Integer x) -> {
            if (hash.containsKey(sum-x) && hash.get(x) != 0 && hash.get(sum-x) != 0 ) {
                if (x == sum-x && hash.get(x) < 2)
                    return;
                hash.put(x , 0);
                hash.put(sum-x , 0);
                System.out.printf("%d %d\r\n", x, sum - x);
            }
        });
    }
}
