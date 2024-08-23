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

    }
}
