package lk.ijse.javafx.controller;


import com.github.plushaze.traynotification.notification.Notifications;
import com.github.plushaze.traynotification.notification.TrayNotification;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainFormController {
    public AnchorPane rootNode;
    public AnchorPane pane;
    public JFXButton supplierBtn;
    public JFXButton dashboardBtn;
    public JFXButton itemBtn;
    public JFXButton customerBtn;
    public Label adminNameLabel;

    public void initialize() throws IOException {
        String username = LogInFormController.userName;
        adminNameLabel.setText(username);

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/view/dashboard.fxml"));

        AnchorPane itemForm = loader.load();
        pane.getChildren().clear();
        pane.getChildren().add(itemForm);

        showNotification();
    }

    private void showNotification() {
        String title = "Huree!";
        String message = "You've successfully login to the system";

        Notifications notification = Notifications.SUCCESS;
        TrayNotification tray = new TrayNotification(title, message, notification);
        tray.showAndWait();
    }

    public void supplierBtnOnClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/view/supplier_form.fxml"));

        AnchorPane itemForm = loader.load();
        pane.getChildren().clear();
        pane.getChildren().add(itemForm);
    }

    public void dashboardBtnOnClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/view/dashboard.fxml"));

        AnchorPane itemForm = loader.load();
        pane.getChildren().clear();
        pane.getChildren().add(itemForm);
    }

    public void logOutBtnOnClick(ActionEvent actionEvent) throws IOException {
        Parent rootNode = FXMLLoader.load(this.getClass().getResource("/view/log_in_form.fxml"));

        Scene scene = new Scene(rootNode);

        Stage stage = (Stage) this.rootNode.getScene().getWindow();
        stage.setScene(scene);

        stage.setTitle("Login Form");
        stage.centerOnScreen();
    }

    public void itemBtnOnClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/view/item_form.fxml"));

        AnchorPane itemForm = loader.load();
        pane.getChildren().clear();
        pane.getChildren().add(itemForm);
    }

    public void customerBtnOnClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/view/customer_form.fxml"));

        AnchorPane itemForm = loader.load();
        pane.getChildren().clear();
        pane.getChildren().add(itemForm);
    }
}
