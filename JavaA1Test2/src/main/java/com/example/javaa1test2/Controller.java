package com.example.javaa1test2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.chart.XYChart;

import java.io.IOException;
import java.sql.DriverManager;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;
import java.sql.Connection;

//This application is helping to avoid urinary infections in my son Pedro.
//Seeing the data is possible be aware and make changes
//This file is for Bar graph view.
public class Controller implements Initializable {

    @FXML
    private StackedBarChart<String,Number> stackedBarChart;
    @FXML
    private CategoryAxis xAxis;
    @FXML
    private NumberAxis yAxis;

    @FXML
    private void changeForTableview(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("tableview.fxml"));
        Parent newScene = fxmlLoader.load();
        Scene nScene = new Scene(newScene);
        Stage barGraph = (Stage) ((Node) event.getSource()).getScene().getWindow();
        barGraph.setScene(nScene);
        barGraph.show();
    }

    @Override @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {

        String URL = "jdbc:mysql://localhost:3306/pedro_health";
        String USER = "root";
        String PASS = "root123";

        try(Connection connection = DriverManager.getConnection(URL, USER, PASS)){
            String SQL;
            SQL = "SELECT day_of_week, water_count FROM intake";
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery(SQL);
            ArrayList<String> dayOfWeek = new ArrayList<String>();
            ArrayList <Double> waterCount = new ArrayList<Double>();

                    while(resultSet.next()){
                        dayOfWeek.add(resultSet.getString(1));
                        waterCount.add(resultSet.getDouble(2));
                    }
                    resultSet.close();
                    //Bar graph chart
            CategoryAxis xAxis = new CategoryAxis();
            xAxis.setLabel("dayOfWeek");

            NumberAxis yAxis = new NumberAxis();
            yAxis.setLabel("waterCount");

            StackedBarChart stackedBarChart1 = new StackedBarChart(xAxis, yAxis);
            XYChart.Series <String, Number> dataSeries1 = new XYChart.Series<>();


            dataSeries1.setName("Pedro Health");

            for (int i = 0; i < dayOfWeek.size(); i++){
                dataSeries1.getData().add(new XYChart.Data(dayOfWeek.get(i), waterCount.get(i)));
            }
            boolean add = stackedBarChart.getData().add(dataSeries1);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}









