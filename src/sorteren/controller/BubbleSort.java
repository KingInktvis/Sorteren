package sorteren.controller;

import sorteren.model.DataList;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by rik on 2/28/17.
 */
public class BubbleSort extends SortInterface {

    private int compareIndex = 0;
    private int goodAfter;
    private int step = 1;
    private Boolean done;
    private Boolean complete = false;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        super.initialize(location, resources);
        goodAfter = DataList.size;
    }

    @Override
    public void nextStep(){
        if (complete) {return;}
        switch (step) {
            case 1:
                changeColor(compareIndex, "blue");
                changeColor(compareIndex + 1, "blue");
                break;
            case 2:
                if (list[compareIndex] > list[compareIndex + 1]) {
                    changeColor(compareIndex, "red");
                    changeColor(compareIndex + 1, "red");
                } else {
                    changeColor(compareIndex, "green");
                    changeColor(compareIndex + 1, "green");
                    step++;
                }
                break;
            case 3:
                switchIndexes(compareIndex, compareIndex + 1);
                done = false;
                break;
            case 4:
                nextRound();
                break;
        }
        step = step == 4 ? 1 : step + 1;
    }

    private void isFinisfed(){
        if (done) {
            setAllDone();
            auto = false;
            complete = true;
        }
    }

    private void nextRound(){
        changeColor(compareIndex, "grey");
        changeColor(compareIndex + 1, "grey");
        if (compareIndex + 2 >= goodAfter) {
            isFinisfed();
            compareIndex = 0;
            done = true;
            if (goodAfter > 1) goodAfter--;
            changeColor(goodAfter, "green");
        } else {
            compareIndex++;
        }
    }
}
