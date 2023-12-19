package com.travel_managment_system.travel_managment_system.Controllers;

import com.travel_managment_system.travel_managment_system.User.TourGuide.TourGuide;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

public class UTProfileController implements Loadfxml {
    @FXML
    private HBox Nav_Box = new HBox();
    @FXML
    private Label TAge = new Label();

    @FXML
    private Label TName = new Label();

    @FXML
    private Label TPassword = new Label();

    @FXML
    private Label TPhonenumber = new Label();

    @FXML
    private TextField TUserText = new TextField();

    @FXML
    private Label TUsername = new Label();

    @FXML
    private TextField TageText = new TextField();

    @FXML
    private TextField TnameText = new TextField();

    @FXML
    private TextField TpassText = new TextField();

    @FXML
    private TextField TphoneText = new TextField();

    @FXML
    private AnchorPane Tprofile;

    @FXML
    private AnchorPane labanchor;

    @FXML
    private AnchorPane labanchor2;
    @FXML
    private Button profileButton;

    public void logoutButtonClicked(ActionEvent event) throws IOException {
        System.out.println("Logout pending!");
        //alert code
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You are logging out...");
        alert.setContentText("Are you sure you want to logout?");

        if (alert.showAndWait().get() == ButtonType.OK) {
            //logging out code
            Parent root = FXMLLoader.load(getClass().getResource("Uhello-view.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            Tprofile.getScene().getWindow().hide();
        }
    }

    public void THomeClicked(ActionEvent event) throws IOException {
        System.out.println("Going home!");
        Parent root = FXMLLoader.load(getClass().getResource("TGHomepage.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        Tprofile.getScene().getWindow().hide();
    }

    public void TProfileClicked(ActionEvent event) throws IOException {
        profileButton.setDisable(true);

    }

    public void initialize() throws IOException {
        TName.setText(TourGuide.selectedTourGuide.getName());
        TAge.setText(TourGuide.selectedTourGuide.getAge());
        TPassword.setText(TourGuide.selectedTourGuide.getPass());
        TPhonenumber.setText(TourGuide.selectedTourGuide.getPhone());
        TUsername.setText(TourGuide.selectedTourGuide.getUsername());

        TnameText.setText(TourGuide.selectedTourGuide.getName());
        TageText.setText(TourGuide.selectedTourGuide.getAge());
        TpassText.setText(TourGuide.selectedTourGuide.getPass());
        TphoneText.setText(TourGuide.selectedTourGuide.getPhone());
        TUserText.setText(TourGuide.selectedTourGuide.getUsername());
        Nav_Box.getChildren().clear();
        Nav_Box.getChildren().add(Load_navBar(getClass().getResource("NavBar.fxml")));

    }

    public void Update() {

        TourGuide.selectedTourGuide.setName(TnameText.getText());
        TourGuide.selectedTourGuide.setAge(TageText.getText());
        TourGuide.selectedTourGuide.setPass(TpassText.getText());
        TourGuide.selectedTourGuide.setPhone(TphoneText.getText());
        TourGuide.selectedTourGuide.setUsername(TUserText.getText());

        for (TourGuide tourguide : TourGuide.TourguideAcc) {
            if (TourGuide.selectedTourGuide.getGuideID().equals(tourguide.getGuideID())) {
                tourguide.setName(TourGuide.selectedTourGuide.getName());
                tourguide.setAge(TourGuide.selectedTourGuide.getAge());
                tourguide.setAge(TourGuide.selectedTourGuide.getAge());
                tourguide.setPhone(TourGuide.selectedTourGuide.getPhone());
                tourguide.setUsername(TourGuide.selectedTourGuide.getUsername());
                break;
            }

        }
    }


    @FXML
    void TEdit(ActionEvent event) throws IOException {
        labanchor.setVisible(true);
        labanchor2.setVisible(false);
        initialize();
    }

    @FXML
    void TSave(ActionEvent event) throws IOException {
        labanchor.setVisible(false);
        labanchor2.setVisible(true);
        Update();
        initialize();


    }

    public void myTripsClicked(ActionEvent event) throws IOException {
        Parent root;

        root = FXMLLoader.load(getClass().getResource("TGTrips.fxml"));
        Tprofile.getScene().getWindow().hide();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

    }

    public void salaryClicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("TGSalary.fxml"));
        UTProfileController UTProfileController = new UTProfileController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        Tprofile.getScene().getWindow().hide();
        UTProfileController.initialize();
    }

}