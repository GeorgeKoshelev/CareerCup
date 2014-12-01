/**
 * Created by george.koshelev on 12/1/2014.
 */
public class Program {
    public static void main(String[] args){
        //increasing
        GetTypeAndMax(new int[]{1,2,3,4,5,6});
        //decreasing
        GetTypeAndMax(new int[]{6,5,4,3,2,1,0});
        //decreasing-increasing
        GetTypeAndMax(new int[]{6,5,4,5,6,7});
        //increasing-decreasing
        GetTypeAndMax(new int[]{1,2,1,0,-1,-2,-3});
    }

    public static void GetTypeAndMax(int[] arr){
        int n = arr.length;
        if (n < 2)
            return;
        String head = (arr[0] > arr[1]) ? "decreasing" : "increasing";
        String tail = (arr[n-2] > arr[n-1]) ? "decreasing" : "increasing";
        if (head.equals(tail)){
            if (head.equals("increasing"))
                System.out.printf("Increasing. Max elem : %d\r\n", arr[n - 1]);
            else
                System.out.printf("Decreasing. Max elem : %d\r\n" , arr[0]);
        }
        else{
            if (head == "increasing"){
                System.out.printf("Increasing-Decreasing. Max elem: %d\r\n" , BinSearch(arr , 0 , n-1));
            }
            else{
                System.out.printf("Decreasing-Increasing. Max elem: %d\r\n", arr[0] > arr[n - 1] ? arr[0] : arr[n - 1]);
            }
        }
    }

    public static int BinSearch(int[] arr , int l , int r){
        int m = l+ (r-l)/2;
        if (arr[m-1] < arr[m] && arr[m] > arr[m+1])
            return arr[m];

        if (arr[l] < arr[l+1] && arr[m-1] < arr[m+1]){
            return BinSearch(arr , m+1 , r);
        }
        else{
            return BinSearch(arr, l , m);
        }
    }
}
