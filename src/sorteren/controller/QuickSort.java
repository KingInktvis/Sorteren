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

    public QuickSort() {
        initSorted();
    }

    @Override
    public void nextStep(){
        if (!done){
            switch (step) {
                case 1:
//                    printSorted();
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
                    switchIndexTo(pivot, compare);
                    changeColor(pivot, "grey");
//                    incrementPivotIndex();
                    pivot++;
                    changeColor(pivot, "blue");
                    incrementCompare();
//                    setAllSortedGreen();
//                    printSorted();
                    break;
            }
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
//            System.out.println(sorted[compare]);
        }else if (sorted[compare] == true){
            changePivot();
        }
    }

    private void changePivot() {
        changeColor(pivot, "green");
        boolean con = true;
        int i = 0;
        while (con && !done) {
            if (i == DataList.size){
                done = true;
//                setAllSortedGreen();
            }else if (!sorted[i]){
                pivot = i;
                sorted[pivot] = true;
                step = 0;
                compare = 0;
                incrementCompare();
                con = false;
            }
            i++;
        }
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
            System.out.println(sorted[i]);
        }
        System.out.println("stop");
    }
}
