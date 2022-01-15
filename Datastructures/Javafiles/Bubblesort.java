import java.util.Random;

public class Bubblesort{
    public static void show(int[] n){
        for(int i=0;i<n.length;i++) System.out.println(n[i]+" "); }
    public static int[] random(int[] array, int range){
        Random rand = new Random();
        for(int i=0;i<array.length;i++) array[i]=rand.nextInt(range); 
        return array;
    }
    public static void main(String args[]) {
        int[] arr = new int[300];
        arr = random(arr,2000);
        show(arr);
        bubble_sort(arr);
        System.out.println();
        show(arr);
    }
    public static void bubble_sort(int[] arr){
        for(int i=0;i<arr.length;i++)
            for(int j=i+1;j<arr.length;j++)
                if(arr[j]<arr[i]){
                    int temp = arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
                return;
    }
}