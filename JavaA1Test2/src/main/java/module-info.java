module com.example.javaa1test2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.javaa1test2 to javafx.fxml;
    exports com.example.javaa1test2;
}