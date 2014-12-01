/**
 * Created by george.koshelev on 12/1/2014.
 */
public class Program {

    public static void main(String[] args){
        System.out.println(GetYearWithMaxPeopleAlive(new int[]{1900, 1985}, new int[]{1986, 1987}));
    }

    public static int GetYearWithMaxPeopleAlive(int[] births, int[] deaths){
        int counts[] = new int[101];
        for (int birth : births)
            counts[birth-1900]++;
        for (int death: deaths)
            counts[death-1900]--;
        int max = 0 , count = 0 , year = 0;
        for (int i = 0 ; i < 101 ; i++){
            count += counts[i];
            if (count > max){
                year = i;
                max = count;
            }
        }
        return 1900 + year;
    }
}
