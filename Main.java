import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n =in.nextInt();
        int[] arr = new int[n];
        long sum = 0;
        for(int i=0;i<n;i++){
            arr[i] = in.nextInt();
            sum += arr[i];
        }

        long tar = sum/n;
        long ans = 0;
        for(int i=0;i<n;i++){
            ans += (Math.abs(arr[i]-tar));
        }

        System.out.println(ans/2);

    }
}
