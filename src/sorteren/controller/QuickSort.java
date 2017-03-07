package sorteren.controller;

import sorteren.model.DataList;

/**
 * Created by rik on 7-3-17.
 */
public class QuickSort extends ChartTabController{
    private boolean done = false;
    private int step = 1;
    private int pivot = 0;
    private int compare = 1;
    private boolean[] sorted;

    @Override
    public void nextStep(){
        if (!done){
            switch (step) {
                case 1:
                    changeColor(pivot, "blue");
                    break;
                case 2:
                    changeColor(compare, "purple");
                    break;
                case 3:
                    if (list[pivot] < list[compare]) {
                        changeColor(compare, "grey");
                        incrementCompare();
                        step = 1;
                    }else {
                        changeColor(compare, "red");
                    }
                    break;
                case 4:
                    changeColor(pivot, "orange");
                    switchIndexTo(pivot, compare);
                    pivot++;
                    changeColor(pivot, "blue");

                    incrementCompare();
                    break;
            }
        }
        step = step == 4 ? 1 : step + 1;
    }

    private void incrementCompare(){
        compare++;
        if (compare == DataList.size) {
            changePivot();
        }
    }

    private void changePivot() {
        for (int i = 0; i < DataList.size; i++) {
            if (!sorted[i]){
                pivot = i;
            }
        }
    }

    private void initSorted(){
        sorted = new boolean[DataList.size];
        for (int i = 0; i < DataList.size; i++) {
            sorted[i] = false;
        }
    }
}
