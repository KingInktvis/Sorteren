package sorteren.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import sorteren.model.DataList;

/**
 * Created by rik on 9-3-17.
 */
public abstract class SortInterface extends ChartTabController {
    boolean auto;
    @FXML
    protected Button autoBtn;


    public abstract void nextStep();


    public SortInterface() {
        auto = false;
        AutoRun run = new AutoRun(this);
        Thread thread = new Thread(run);
        thread.setDaemon(true);
        thread.start();
    }

    public void nextAction() {
        if (!auto) nextStep();
    }

    public void autoAction() {
        switchAutoRun();
    }

    public Boolean getAuto() {
        return auto;
    }

    protected void switchAutoRun(){
        auto = !auto;
        if (auto){
            autoBtn.setText("stop");
        }else {
            autoBtn.setText("start");
        }
    }

    protected void switchIndexes(int index1, int index2){
        int temp = list[index1];
        list[index1] = list[index2];
        list[index2] = temp;
        bars.get(index1).setYValue(list[index1]);
        bars.get(index2).setYValue(list[index2]);
    }

    protected void setAllDone(){
        for (int i = 0; i < DataList.size; i++){
            changeColor(i, "green");
        }
    }

    protected void switchIndexTo(int target, int current) {
        if (target > current) {
            while (current != target) {
                switchIndexes(current, current + 1);
                current++;
            }
        }else {
            while (current != target) {
                switchIndexes(current, current - 1);
                current--;
            }
        }
    }
}
