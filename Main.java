import java.util.Scanner;

public class test {
    public static int minimizeRange(int[] arr) {
        int operations = 0;

        int minIndex = 0, maxIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[minIndex]) {
                minIndex = i;
            }
            if (arr[i] > arr[maxIndex]) {
                maxIndex = i;
            }
        }

        while (arr[maxIndex] - arr[minIndex] > 1) {
            arr[maxIndex]--;
            arr[minIndex]++;
            operations++;

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] < arr[minIndex]) {
                    minIndex = i;
                }
            }

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > arr[maxIndex]) {
                    maxIndex = i;
                }
            }
        }

        return operations;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = in.nextInt();
        }
        System.out.println(minimizeRange(arr));
    }
}
