import java.util.Random;

public class Mergesort{
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
        merge_sort(arr);
        System.out.println();
        show(arr);
    }
    public static void merge_sort(int[] array){
        int iL = array.length;
        if(iL<2) return;
        var mi = iL/2;
        int left[] = new int[mi];
        int right[] = new int[iL - mi];
        for(int i=0;i<mi;i++) {
            left[i]=array[i];
        }
        for(int i=mi;i<iL;i++) {
            right[i-mi]=array[i];
        }
        merge_sort(left);
        merge_sort(right);
        int lL = left.length;
        int rL = right.length;
        int i=0,j=0,k=0;
        while(i<lL && j<rL){
            if(right[j]<=left[i]){
                array[k]=left[i];
                i++;
            }
            else{
                array[k]=right[j];
                j++;
            }k++;
        }
        while(i<lL){
            array[k]=left[i];
            i++;k++;
        }
        while(j<rL){
            array[k]=right[j];
            j++;k++;
        }
        return;
    }
}