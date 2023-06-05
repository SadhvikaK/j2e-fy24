import java.util.*;
public class Program15{

    public static int KthLargest(int[] arr, int k) {
        int n = arr.length;
        int left = 0;
        int right = n - 1;
        while (true) {
            int pivot = part(arr, left, right);
            if (pivot == n - k) {
                return arr[pivot];
            } else if (pivot < n - k) {
                left = pivot + 1;
            } else {
                right = pivot - 1;
            }
        }
    }
    public static int part(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left;
        for (int j = left; j < right; j++) {
            if (arr[j] < pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, right);
        return i;
    }
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.println(KthLargest(arr, k));
    }
}