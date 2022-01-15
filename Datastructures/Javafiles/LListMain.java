// import java.util.Arrays;

public class LListMain {
    public static void main(String[] args) {

        var list = new LinkedList();
        list.addFirst(10);
        list.addFirst(20);
        list.addFirst(35);
        list.addLast(29);
        list.addLast(30);
        list.addLast(33);
        list.addLast(37);
        list.addLast(32);
        list.print();
        System.out.println(list.size());
        System.out.println(list.getNodefromEnd(1));
        // System.out.println(list.size());
        // list.removeLast();
        // list.removeLast();
        // list.removeLast();
        // list.print();
        // list.reverse();
        // list.print();

    }
}
