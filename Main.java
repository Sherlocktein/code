import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n =in.nextInt();
        String s = in.next();
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='?'){
                System.out.println(n-i);
                return;
            }
        }
    }
}
