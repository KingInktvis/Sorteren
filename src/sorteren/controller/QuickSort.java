package sorteren.controller;

import sorteren.model.DataList;

/**
 * Created by rik on 7-3-17.
 */
public class QuickSort extends SortInterface{
    private boolean done = false;
    private int step = 1;
    private int pivot = 0;
    private int compare = 1;
    private boolean[] sorted;

    public QuickSort() {
        initSorted();
    }

    @Override
    public void nextStep(){
        if (done){return;}
        switch (step) {
            case 1:
                changeColor(pivot, "blue");
                break;
            case 2:
                changeColor(compare, "purple");
                if(sorted[compare]) {
                    changePivot();
                }
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
                changeColor(compare, "grey");
                switchIndexTo(pivot, compare);
                changeColor(pivot, "grey");
                pivot++;
                changeColor(pivot, "blue");
                incrementCompare();
                break;
        }
        step = step == 4 ? 1 : step + 1;
    }

    private void incrementPivotIndex() {
        sorted[pivot] = false;
        pivot++;
        sorted[pivot] = true;
    }

    private void incrementCompare(){
        compare++;

        if (compare == DataList.size) {
            changePivot();
        }else if (sorted[compare]){
            changePivot();
        }
    }

    private void changePivot() {
        changeColor(pivot, "green");
        for (int i = 0; i < DataList.size; i++) {
            if (!sorted[i]){
                pivot = i;
                sorted[pivot] = true;
                step = 0;
                compare = pivot;
                incrementCompare();
                return;
            }
        }
        done = true;
    }

    private void initSorted(){
        sorted = new boolean[DataList.size];
        sorted[0] = true;
        for (int i = 1; i < DataList.size; i++) {
            sorted[i] = false;
        }
    }

    private void setAllSortedGreen(){
        for (int i = 0; i < DataList.size; i++) {
            if (sorted[i]){
                changeColor(i, "green");
            }
        }
    }

    @Override
    protected void switchIndexes(int index1, int index2){
        super.switchIndexes(index1, index2);
        boolean temp = sorted[index1];
        sorted[index1] = sorted[index2];
        sorted[index2] = temp;
    }

    private void printSorted(){
        System.out.println("start");
        for (int i = 0; i < DataList.size; i++){
            System.out.println(i + " " + sorted[i]);
        }
        System.out.println("stop");
    }
}
