module com.example.sportdiaryfrontend {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.jfoenix;
    requires Sport.diary.backend;


    opens com.example.sportdiaryfrontend to javafx.fxml;
    exports com.example.sportdiaryfrontend;
}