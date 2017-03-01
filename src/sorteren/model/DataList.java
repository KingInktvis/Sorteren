package sorteren.model;


import java.util.Random;

/**
 * Created by rik on 3/1/17.
 */
public class DataList {
    int size = 10;
    int limit = 100;
    private int[] list;

    public DataList () {
        list = new int[size];
        Random rand;
        int num;
        rand = new Random();
        for (int i = 0; i < size; i++) {
            num = rand.nextInt(limit);
            list[i] = num;
        }
    }

    public int[] getList() {
        return list;
    }

}
