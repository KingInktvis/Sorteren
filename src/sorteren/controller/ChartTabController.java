package sorteren.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import sorteren.model.DataList;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created by rik on 3/5/17.
 */
public class ChartTabController implements Initializable{

    protected ArrayList<XYChart.Data> bars = new ArrayList<>();
    protected int[] list;
    @FXML
    private BarChart chart;
    @FXML
    protected Button autoBtn;
    protected XYChart.Series series;
    boolean auto;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        list = DataList.list.clone();
        series = new XYChart.Series();
        series.setName("values");
        chart.getData().add(series);
        drawBars();
        AutoRun run = new AutoRun(this);
        Thread thread = new Thread(run);
        thread.setDaemon(true);
        thread.start();
    }

    private void drawBars() {
//        chart.getData().clear();
        for (int i = 0; i < DataList.size; i++) {
            XYChart.Data<String, Number> data = new XYChart.Data<String, Number>(Integer.toString(i)+"|"+Integer.toString(list[i]), list[i]);
            bars.add(data);
            //source: https://gist.github.com/khaledLela/6071422
            series.getData().add(data);
        }
    }

    protected void switchIndexes(int index1, int index2){
        int temp = list[index1];
        list[index1] = list[index2];
        list[index2] = temp;
        bars.get(index1).setYValue(list[index1]);
        bars.get(index2).setYValue(list[index2]);
    }

    protected void changeColor(int index, String color){
        Node node = bars.get(index).getNode();
        if (node == null){System.out.print("fuck");}
        node.setStyle("-fx-bar-fill: " + color + ";");
    }

    protected void switchAutoRun(){
        auto = !auto;
        if (auto){
            autoBtn.setText("stop");
        }else {
            autoBtn.setText("start");
        }

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

    public void nextStep(){

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
