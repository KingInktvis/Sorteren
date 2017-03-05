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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        list = DataList.list.clone();
        series = new XYChart.Series();
        series.setName("values");
        //series.getData().add(new XYChart.Data("Desktop", 567));
        chart.getData().add(series);

        drawBars();

    }

    @Override
    public void nextAction() {
        switchIndexes(1,2);
    }

    @Override
    public void autoAction() {
        System.out.print("auto \n");
        changeValueOf(69, 1);
        changeColor();
    }
    private void changeColor(){
        Node node = bars.get(0).getNode();
        if (node == null){System.out.print("fuck");}
        node.setStyle("-fx-bar-fill: firebrick;");
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

    private void nextStep(){

    }
/*
* source: https://gist.github.com/khaledLela/6071422
* */
}
