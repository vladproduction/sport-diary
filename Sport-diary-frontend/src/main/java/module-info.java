module com.example.sportdiaryfrontend {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.sportdiaryfrontend to javafx.fxml;
    exports com.example.sportdiaryfrontend;
}