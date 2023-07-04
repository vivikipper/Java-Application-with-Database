package com.example.javaa1test2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
//This file is for tableview display.
import java.util.ResourceBundle;

public class ControllerTableview implements Initializable {
    @FXML
    private TableView<PedroHealth> tbPedroHealth;
    @FXML
    private TableColumn<PedroHealth, String> tbDayOfWeek;

    @FXML
    private TableColumn<PedroHealth, Integer> tbWaterCount;
   ObservableList<PedroHealth> dataViewList = FXCollections.observableArrayList();

    @FXML
    private void changeForTableview2(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader;
        fxmlLoader = new FXMLLoader(Application.class.getResource("view.fxml"));
        Parent newScene = fxmlLoader.load();

        Scene nScene = new Scene(newScene);

        Stage tableview = (Stage) ((Node) event.getSource()).getScene().getWindow();

        tableview.setScene(nScene);
        tableview.show();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        tbDayOfWeek.setCellValueFactory(new PropertyValueFactory<>("weekName"));
        tbWaterCount.setCellValueFactory(new PropertyValueFactory<>("waterCount"));

        String URL = "jdbc:mysql://localhost:3306/pedro_health";
        String USER = "root";
        String PASS = "root123";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASS)) {
            String SQL;
            SQL = "SELECT day_of_week, water_count FROM intake";
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery(SQL);

            while(resultSet.next())
            {
                dataViewList.add(new PedroHealth(resultSet.getString("day_of_week"), resultSet.getInt("water_count")));

            }
            resultSet.close();

            tbPedroHealth.setItems(dataViewList);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}