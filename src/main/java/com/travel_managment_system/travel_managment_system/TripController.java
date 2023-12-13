package com.travel_managment_system.travel_managment_system;
import com.travel_managment_system.travel_managment_system.Ticket.Ticket;
import com.travel_managment_system.travel_managment_system.Trip.Trip;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TripController implements Initializable {
    @FXML
    public Label locationLabel;
    @FXML
    public Label checkLabel;
    @FXML
    private Button BookingButton;
    @FXML
    private Label ChoiceLabel;
    @FXML
    private Label NoOfTicketsMessageLabel1;
    @FXML
    private Label PackageMessageLabel;
    @FXML
    private AnchorPane TripHome;
    @FXML
    private Label TripNameLabel;
    @FXML
    private Label end_dateLabel;
    @FXML
    private ImageView imgView;
    @FXML
    private TextField numbersOfTicketsInputs;
    @FXML
    private ChoiceBox<String> packageTypeChoice;
    @FXML
    private Label priceLabel;
    @FXML
    private Label start_dateLabel;
    @FXML
    private Label tripTypeLabel;
    @FXML
    private String[] packages = {"Silver", "Golden" , "Platinum"};

    public void ViewTripDetails(Trip trip) throws IOException {

        Trip.selectedTrip=trip;
        FileInputStream imageInput = new FileInputStream(trip.getTripImage());
        Image image = new Image(imageInput);
        imgView.setImage(image);

        TripNameLabel.setText(trip.getTripName());
        tripTypeLabel.setText(trip.getTripType());
        start_dateLabel.setText(trip.getStartDate().toString());
        end_dateLabel.setText(trip.getEndDate().toString());
        priceLabel.setText(String.valueOf(trip.getPrice()));
        locationLabel.setText(trip.getLocation());


    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        packageTypeChoice.getItems().addAll(packages);
        packageTypeChoice.setOnAction(this::getPackage);
    }

    public void getPackage(ActionEvent event){
        String packageType = String.valueOf(packageTypeChoice.getValue());
        ChoiceLabel.setText("You chose : " + packageType);
        if (packageType.equals("Silver")) {
            PackageMessageLabel.setText("The trip contains only the transportation and half-board");
        } else if (packageType.equals("Golden")) {
            PackageMessageLabel.setText("The trip contains the transportation and full-board");
        } else if (packageType.equals("Platinum")) {
            PackageMessageLabel.setText("The trip contains the transportation, full-board and activities");
        }

    }

    public void logoutButtonClicked(ActionEvent event) throws IOException {
        System.out.println("Logout pending!");
        //alert code
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You are logging out...");
        alert.setContentText("Are you sure you want to logout?");

        if (alert.showAndWait().get() == ButtonType.OK) {
            //logging out code
            Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            TripHome.getScene().getWindow().hide();
        }
    }

    public void HomeClicked(ActionEvent event) throws IOException {
        System.out.println("Going home!");
        Parent root = FXMLLoader.load(getClass().getResource("CHomepage.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        TripHome.getScene().getWindow().hide();
    }

    public void CProfileClicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Cprofile.fxml"));
        //profile profile=new profile();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        TripHome.getScene().getWindow().hide();
        //profile.initialize();

    }
    public void myTripsClicked(ActionEvent event) throws IOException {
        Parent root;
        root = FXMLLoader.load(getClass().getResource("CMyTrips.fxml"));
        TripHome.getScene().getWindow().hide();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

    }


    public void Booking(ActionEvent actionEvent) throws IOException {

        int numbersOfTickets = 0;
        try {
            numbersOfTickets = Integer.parseInt(numbersOfTicketsInputs.getText());
            System.out.println(numbersOfTicketsInputs.getText());
        }
        catch (NumberFormatException e)
        {
            System.out.println(e);
        }

        String packageType = String.valueOf(packageTypeChoice.getValue());

        if (tripTypeLabel.getText().toLowerCase().equals("family") && numbersOfTickets < 3){
            NoOfTicketsMessageLabel1.setText("The minimum number for the tickets is 3");
        }
        else if (tripTypeLabel.getText().toLowerCase().equals("couple") && numbersOfTickets % 2 != 0){
            NoOfTicketsMessageLabel1.setText("Tickets must be Even number");
        }
        else if (packageTypeChoice.getValue() == null || numbersOfTickets == 0) {
//            PackageMessageLabel.setText("You must choose Package");
//            NoOfTicketsMessageLabel1.setText("You must choose at least 1 ticket");
            checkLabel.setVisible(true);
        }
        else {
            NoOfTicketsMessageLabel1.setText("");
            Ticket.selectedTicket=new Ticket();
            Ticket.selectedTicket.numberOfReservedTickets=numbersOfTickets;

            System.out.println(Trip.selectedTrip.getTransportation());
            if(Trip.selectedTrip.getTransportation().equals("Plane")) {
                FlightController flight = new FlightController();
                flight.trip_flightSwitch();
                TripHome.getScene().getWindow().hide();
            }
            else if (Trip.selectedTrip.getTransportation().equals("Bus")){
                BusController bus = new BusController();
                bus.trip_busSwitch();
                TripHome.getScene().getWindow().hide();
            }
        }

    }


}