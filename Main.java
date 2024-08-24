import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static int[] arr;
    static int max,min1,min2;
    static PriorityQueue<Integer> minQue,maxQue;
    static HashMap<Integer,Integer> map;

    public static void get(){
        while (true){
            int num = minQue.poll();
            if(map.get(num)<=0) continue;
            else{
                min1 = num;
                break;
            }
        }
        while (true){
            int num = minQue.poll();
            if(map.get(num)<=0) continue;
            else{
                min2 = num;
                break;
            }
        }
        while (true){
            int num = maxQue.poll();
            if(map.get(num)<=0) continue;
            else{
                max = num;
                break;
            }
        }
        minQue.add(min1);
        minQue.add(min2);
        maxQue.add(max);
    }


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        arr = new int[n];
        for(int i=0;i<n;i++) arr[i] = in.nextInt();

        minQue = new PriorityQueue<>();
        maxQue = new PriorityQueue<>((a,b)->(b-a));

        map = new HashMap<>();


        int ansl=0,ansr=0;
        int l=0,r=0;
        for(r=0;r<n;r++){
            if((r-l)<2){
                minQue.add(arr[r]);
                maxQue.add(arr[r]);
                map.put(arr[r],map.getOrDefault(arr[r],0)+1);
            }else{

                minQue.add(arr[r]);
                maxQue.add(arr[r]);
                map.put(arr[r],map.getOrDefault(arr[r],0)+1);

                get();

                if((min1+min2)>max){
                    if((r-l)>(ansr-ansl)){
                        ansl=l;
                        ansr=r;
                    }
                }else{
                    while((r-l)>=2){
                        map.put(arr[l],map.get(arr[l])-1);
                        l++;
                        get();
                        if((min1+min2)>max) break;
                    }
                }
            }
        }

        System.out.println((ansl+1) + " " + (ansr+1));

    }

}
//9
//2 3 3 3 1 1 3 3 3