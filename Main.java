import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(),m = in.nextInt(),k = in.nextInt();
        int[][] arr = new int[n+1][m+1];
        in.nextLine();
        for(int i = 0;i<k;i++){
            String c = in.nextLine();
            String op = c.split(" ")[0];
            int x = Integer.parseInt(c.split(" ")[1]), y = Integer.parseInt(c.split(" ")[2]);
            if(op.equals("c")){
                arr[x][y] = 1;
            }else if(op.equals("l")){
                int j = y-1;
                for(;j>=1;j--){
                    if(arr[x][j]==0) break;;
                }
                if(j>=1) System.out.println(x + " " + j);
                else System.out.println(-1);
            }else if(op.equals("r")){
                int j = y+1;
                for(;j<=m;j++){
                    if(arr[x][j]==0) break;;
                }
                if(j<=m) System.out.println(x + " " + j);
                else System.out.println(-1);
            }else if(op.equals("u")){
                int j = x-1;
                for(;j>=1;j--){
                    if(arr[j][y]==0) break;;
                }
                if(j>=1) System.out.println(j + " " + y);
                else System.out.println(-1);
            }else{
                int j = x+1;
                for(;j<=n;j++){
                    if(arr[j][y]==0) break;;
                }
                if(j<=n) System.out.println(j + " " + y);
                else System.out.println(-1);
            }

        }

    }
}
