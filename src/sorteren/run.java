package sorteren;

import sorteren.model.DataList;
import sorteren.model.Gui;

/**
 * Created by rik on 28-2-17.
 */
public class run {
    public static void main(String args[]){
        new DataList();
        new Gui().go(args);
    }
}
