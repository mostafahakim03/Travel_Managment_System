package com.travel_managment_system.travel_managment_system;

import com.travel_managment_system.travel_managment_system.Ticket.Ticket;
import com.travel_managment_system.travel_managment_system.Trip.Trip;
import com.travel_managment_system.travel_managment_system.User.Customer.Customer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PaymentController implements Loadfxml ,Initializable {
    @FXML
    private HBox Nav_Box=new HBox();
    @FXML
    private AnchorPane paymentAnchor;

    @FXML
    private ProgressBar progressBar4;

    @FXML
    TextField visaNumberTextField = new TextField();
    @FXML
    Label alertLabel = new Label();
    @FXML
    private Label DiscountLabel;
    @FXML
    private Label paymentLabel;

    @FXML
    public void logoutButtonClicked(ActionEvent event) throws IOException {
        System.out.println("Logout pending!");
        //alert code
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You are logging out...");
        alert.setContentText("Are you sure you want to logout?");

        if (alert.showAndWait().get() == ButtonType.OK) {
            lodafxmlfile("hello-view.fxml");
            paymentAnchor.getScene().getWindow().hide();
        }
    }

    public void HomeClicked(ActionEvent event) throws IOException {
        System.out.println("Going home!");
        lodafxmlfile("CHomepage.fxml");
        paymentAnchor.getScene().getWindow().hide();
    }

    public void TProfileClicked(ActionEvent event) throws IOException {
        lodafxmlfile("CMyProfile.fxml");
        paymentAnchor.getScene().getWindow().hide();

    }

    public void myTripsClicked(ActionEvent event) throws IOException {
        lodafxmlfile("CMyTrips.fxml");
        paymentAnchor.getScene().getWindow().hide();
    }

    public void CancelTrip() throws IOException {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Cancelling trip");
        alert.setHeaderText("All information you just entered will not be saved!");
        alert.setContentText("Are you sure you want to cancel the trip?");
        if (alert.showAndWait().get() == ButtonType.OK) {
            lodafxmlfile("CHomepage.fxml");
            paymentAnchor.getScene().getWindow().hide();
        }
    }

    public void SubmitButton() throws IOException {
        if (visaNumberTextField.getText().isEmpty() || visaNumberTextField.getCharacters().length() != 16) {
            alertLabel.setVisible(true);
        } else {
            Trip.selectedTrip.setNumberOfAvailableSeats(Trip.selectedTrip.getNumberOfAvailableSeats() - Ticket.selectedTicket.numberOfReservedTickets);
            double overallPrice=Ticket.selectedTicket.numberOfReservedTickets*Trip.selectedTrip.getPrice();
            if(Ticket.selectedTicket.ticket_price<(overallPrice)){
            DiscountLabel.setVisible(true);
        }
            Customer.selectedCustomer.myTrips.add(Trip.selectedTrip);
            lodafxmlfile("TicketScene.fxml");
            paymentAnchor.getScene().getWindow().hide();
            for (Customer customer : Customer.CoustomerAcc) {
                if (customer.getUsername().equals(Customer.selectedCustomer.getUsername())) {
                    customer.tickets.add(Ticket.selectedTicket);
                    customer.myTrips = Customer.selectedCustomer.myTrips;
                    break;
                }
            }
            Trip.selectedTrip.tickets.add(Ticket.selectedTicket);
            for (Trip trip : Trip.trips) {
                if (trip.getTrip_id() == Trip.selectedTrip.getTrip_id()) {
                    if (trip.getTransportation() == "Plane") {
                        for (Integer seat : Ticket.selectedTicket.seatNumber) {
                            trip.flight.Seats.remove(seat);
                        }

                    }
                    if (trip.getTransportation() == "Bus") {
                        for (Integer seat : Ticket.selectedTicket.seatNumber) {
                            trip.bus.Seats.remove(seat);
                        }
                    }
                }
            }


        }


    }

@Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        progressBar4.setStyle("-fx-accent: #FA8B02;");
        paymentLabel.setText("This trip will cost you: " + Ticket.selectedTicket.ticket_price + " EGP");
    try {
        Nav_Box.getChildren().add(Load_navBar(getClass().getResource("NavBar.fxml")));
    } catch (IOException e) {
        throw new RuntimeException(e);
    }

}
}






