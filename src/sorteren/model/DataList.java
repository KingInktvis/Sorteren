package sorteren.model;


import java.util.Random;

/**
 * Created by rik on 3/1/17.
 */
public class DataList {
    private static final int[] list;

    static {
        int size = 10;
        list = new int[size];
        Random rand;
        int num;
        rand = new Random();
        for (int i = 0; i < size; i++) {
            int limit = 100;
            num = rand.nextInt(limit);
            list[i] = num;
        }
    }

    public static int[] getList() {
        return list;
    }

}
