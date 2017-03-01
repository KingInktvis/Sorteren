package sorteren.model;


import java.util.Random;

/**
 * Created by rik on 3/1/17.
 */
public class DataList {
    static int size = 10;
    static int limit = 100;
    static final int[] list;

    static {
        list = new int[size];
        Random rand;
        int num;
        rand = new Random();
        for (int i = 0; i < size; i++) {
            num = rand.nextInt(limit);
            list[i] = num;
        }
    }

    public static int[] getList() {
        return list;
    }

}
