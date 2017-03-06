package sorteren.controller;

import sorteren.model.DataList;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by rik on 6-3-17.
 */
public class InsertionSort extends ChartTabController {

    private boolean done = false;
    private int step = 1;
    private int sorted = 0;
    private int compare = 0;
    private int toSort = 1;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        super.initialize(location, resources);
        changeColor(0, "green");
    }

    @Override
    public void nextStep() {
        if (!done){
            switch (step) {
                case 1:
                    changeColor(toSort, "red");
                    break;
                case 2:
                    changeColor(compare, "blue");
                    break;
                case 3:
                    if (list[toSort] <= list[compare]) {
                        changeColor(compare, "red");
                    }else {
                        changeColor(compare, "green");
                        incrementCompare();
                        step = 1;
                    }
                    break;
                case 4:
                    switchIndexTo(compare, toSort);
                    nextToSort();
            }
            step = step == 4 ? 1 : step + 1;
        }

//        if (!done) {
//            switch (step) {
//                case 1:
//                    compare = 0;
//                    for (int i = 0; i <= sorted; i++) {
//                        changeColor(i, "green");
//                    }
//                    break;
//                case 2:
//                    changeColor(sorted + 1, "red");
//                    break;
//                case 3:
//                    changeColor(compare, "blue");
//                    break;
//                case 4:
//                    if (compare == sorted + 1 || list[sorted + 1] == list[compare]){
//                        step = 0;
//                        incrementSorted();
//                        compare = 0;
//                    }else if (list[sorted + 1] < list[compare]) {
//                        changeColor(compare, "red");
//                    }else {
//                        changeColor(compare, "green");
//                        compare++;
//                        step = 2;
//                    }
//                    break;
//                case 5:
//                    switchIndexTo(sorted + 1, compare);
//                    incrementSorted();
//                    compare = 0;
//                    break;
//            }
//            step = step == 5 ? 1 : step + 1;
//        }

    }

    private void nextToSort(){
        changeColor(compare, "green");
        changeColor(toSort, "green");
        compare = 0;
        step = 0;
        incrementSorted();
        toSort++;

    }

    private void incrementCompare(){
        compare++;
        if (compare - 1 >= sorted){
            nextToSort();
        }

    }

    private void incrementSorted(){
        sorted++;
        if (sorted == DataList.size - 1) {
            done = true;
        }
    }
}
