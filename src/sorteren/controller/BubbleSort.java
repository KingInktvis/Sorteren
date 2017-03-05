package sorteren.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.text.Text;
import sorteren.model.DataList;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created by rik on 2/28/17.
 */
public class BubbleSort implements Sorting {

    private ArrayList<XYChart.Data> bars = new ArrayList<>();
    private int[] list;
    @FXML
    private BarChart chart;
    private XYChart.Series series;

    private int compareIndex = 0;
    private int sorted;
    private int step = 1;
    public boolean auto;
    private AutoRun thread;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        list = DataList.list.clone();
        series = new XYChart.Series();
        series.setName("values");
        chart.getData().add(series);
        drawBars();
        thread = new AutoRun(this);
        new Thread(thread).start();
    }

    @Override
    public void nextAction() {
        nextStep();
        System.out.print("next");
    }

    @Override
    public void autoAction() {
        switchAutoRun();

    }
    private void changeColor(int index, String color){
        Node node = bars.get(index).getNode();
        if (node == null){System.out.print("fuck");}
        node.setStyle("-fx-bar-fill: " + color + ";");
    }
    private void changeValueOf(int newValue, int index){
        bars.get(index).setYValue(newValue);
//        displayLabelForData(bars.get(index));
    }

    private void switchIndexes(int index1, int index2){
        int temp = list[index1];
        list[index1] = list[index2];
        list[index2] = temp;
        bars.get(index1).setYValue(list[index1]);
        bars.get(index2).setYValue(list[index2]);
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

    public void switchAutoRun(){
        auto = auto ? false : true;
    }

    public void nextStep(){
        switch (step) {
            case 1:
                changeColor(compareIndex, "blue");
                changeColor(compareIndex + 1, "blue");
                break;
            case 2:
                if (list[compareIndex] > list[compareIndex +1]){
                    changeColor(compareIndex, "red");
                    changeColor(compareIndex + 1, "red");
                }else {
                    changeColor(compareIndex, "green");
                    changeColor(compareIndex + 1, "green");
                    step++;
                }
                break;
            case 3:
                switchIndexes(compareIndex, compareIndex + 1);
                break;
            case 4:
                changeColor(compareIndex, "grey");
                changeColor(compareIndex + 1, "grey");
                compareIndex = compareIndex == DataList.size - 2 ? 0 : compareIndex + 1;
                break;
        }
        step = step == 4 ? 1 : step + 1;
    }

    @Override
    public Boolean getAuto() {
        return auto;
    }


/*
* source: https://gist.github.com/khaledLela/6071422
* */
}
