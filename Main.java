import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static long tar = 0;
    static boolean tf = false;
    public static boolean f(int x){
        if(x==tar) return true;
        if(!tf && x==(tar+1)) return true;
        return false;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n =in.nextInt();
        int[] arr = new int[n];
        long sum = 0;
        for(int i=0;i<n;i++){
            arr[i] = in.nextInt();
            sum += arr[i];
        }

        tar = sum/n;
        tf = (sum%n==0);
        Arrays.sort(arr);

        int i=0,j=n-1;
        long ans = 0;
        while(i<j){
            while(i<j && f(arr[i])) i++;
            while(i<j && f(arr[j])) j--;
            if(i<j){
                long tp = Math.min(tar-arr[i],arr[j]-tar);
                arr[i] += tp;
                arr[j] -= tp;
                ans += tp;
            }
        }
        if(!tf){
            if(arr[i]!=tar) ans+=(arr[i]-(tar+1));
        }
        System.out.println(ans);
    }
}
