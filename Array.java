 public class Array {
    private int[] items;
    private int count=0;
    public void indexOf(int element){
        int f = 0;
        for(int i=0;i<count ; i++)
            if(element == items[i]){
                System.out.println(i);
                f=1;
                break;
            }
        if(f==0)
            System.out.println(-1);
    }
    public Array(int length){
        items = new int[length];
    }
    public void insert(int item){
        if(items.length == count){
            int[] items2 = new int[count+count];
            for(int i=0;i<count;i++) items2[i]=items[i];
            items = items2;
         } 
        items[count++] = item;
    }
    public void print(){
        for(int i=0; i<count; i++){
            System.out.println(items[i]);
        }
    }
    public void removeAt(int index){
        if(index < 0 || index >= count)
            throw new IllegalArgumentException();
        else
            for(int i=index; i<count; i++)
                items[i] = items[i+1];
            items[count--]=0;

    }
}
