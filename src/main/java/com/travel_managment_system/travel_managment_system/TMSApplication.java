package com.travel_managment_system.travel_managment_system;
import com.travel_managment_system.travel_managment_system.Trip.Trip;
import com.travel_managment_system.travel_managment_system.User.Customer.CAr;
import com.travel_managment_system.travel_managment_system.User.Customer.CarCompany;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.time.LocalDate;

public class TMSApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        Trip.trips.add(new Trip("Luxor", 1000, "Family", LocalDate.of(2023,12,11), LocalDate.of(2023,03,17),3000, 10000, "src/main/java" +
                "/com/travel_managment_system/travel_managment_system/luxorPhoto.jpg","Luxor","Plane"));
        Trip.trips.add(new Trip("Alexandria", 1001, "Couple", LocalDate.of(2023,12,03), LocalDate.of(2023,05,14), 400, 7000, "src/main" +
                "/java/com/travel_managment_system/travel_managment_system/Alexandria.jpeg","Alexandria", "Bus"));
        Trip.trips.add(new Trip("Hurghada", 1002, "Couple",LocalDate.of(2023,05,03) ,LocalDate.of(2023,05,14), 400, 7000, "src/main/resources/com/travel_managment_system/travel_managment_system/Hurghada.png","Hurghada","Bus"));


    }


    public static void main(String[] args) {
        launch();
    }
}