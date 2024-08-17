import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static long tar = 0;
    static boolean tf = false;
    public static boolean f(long x){
        if(x==tar) return true;
        if(!tf && x==(tar+1)) return true;
        return false;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        long[] arr = new long[(int)n];
        long sum = 0;
        for(int i=0;i<n;i++){
            arr[i] = in.nextLong();
            sum += (long) arr[i];
        }

        tar = sum / (long) n;
        tf = (sum % (long) n == 0);
        Arrays.sort(arr);

        int i=0,j=(int)n-1;
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
            if(arr[i]!=tar) ans += (long)(arr[i]-(tar+1));
        }
        System.out.println(ans);
    }
}
