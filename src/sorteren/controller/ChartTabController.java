package sorteren.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import sorteren.model.DataList;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created by rik on 3/5/17.
 */

public class ChartTabController implements Initializable{

    protected int[] list;
    protected ArrayList<XYChart.Data> bars = new ArrayList<>();
    @FXML
    private BarChart chart;
    protected XYChart.Series series;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        list = DataList.list.clone();
        series = new XYChart.Series();
        series.setName("values");
        chart.getData().add(series);
        drawBars();
    }

    private void drawBars() {
        for (int i = 0; i < DataList.size; i++) {
            XYChart.Data<String, Number> data = new XYChart.Data<String, Number>(Integer.toString(i)+"|"+Integer.toString(list[i]), list[i]);
            bars.add(data);
            series.getData().add(data);
        }
    }

    protected void changeColor(int index, String color){
        Node node = bars.get(index).getNode();
        if (node == null){System.out.print("fuck");}
        node.setStyle("-fx-bar-fill: " + color + ";");
    }







}
