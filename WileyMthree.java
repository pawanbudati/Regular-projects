import java.util.*;

public class WileyMthree {
    public static int[] splitter(int a) {
        int k[] = new int[10];
        int i = 0;
        while (a != 0) {
            k[i] = a % 10;
            i++;
            a = a / 10;
        }
        int k2[] = new int[i];
        for (int j = 0; j < i; j++)
            k2[j] = k[j];
        k = k2;
        return k;
    }

    public static int[] fun(int x, int y, int N) {
        int[] list = new int[y];
        for (int i = x, k = 0; i <= y; i++) {
            int f = 0;
            if (prime(i)) {
                for (int m : splitter(N))
                    for (int n : splitter(i))
                        if (m == n) {
                            System.out.print(i);
                            list[k] = i;
                            k++;
                            f = 1;
                            break;
                        }
                if (f == 1)
                    break;
            }
        }
        for (int i = 0; i < list.length; i++)
            System.out.print(list[i] + " ");
        return null;
    }

    public static boolean prime(int n) {
        if (n == 0 || n == 1)
            return false;
        for (int i = 2; i < n / 2; i++)
            if (n % i == 0)
                return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int N = sc.nextInt();
        sc.close();
        int[] list = fun(x, y, N);
        // int[] list = splitter(N);
        for (int i = 0; i < list.length; i++)
            System.out.println(list[i] + " ");
    }
}
