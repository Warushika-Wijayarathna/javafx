package lk.ijse.javafx.controller;

import javafx.event.ActionEvent;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.javafx.db.Db;

import java.io.IOException;

public class LogInFormController {
    public TextField userTxt;
    public TextField passwordTxt;
    public AnchorPane rootNode;

    public static String userName;

    public void logInBtnClickOnAction(ActionEvent actionEvent) throws IOException {
        userName = userTxt.getText();
        String password = passwordTxt.getText();

        System.out.println(userName);
        System.out.println(password);

        if(userName.equals(Db.USER_NAME) && password.equals(Db.PASSWORD)) {

            AnchorPane rootNode = FXMLLoader.load(this.getClass().getResource("/view/main_form.fxml"));

            Scene scene = new Scene(rootNode);

            Stage stage = (Stage) this.rootNode.getScene().getWindow();
            stage.setScene(scene);

            stage.setTitle("Main Form");
            stage.centerOnScreen();
        } else {
            new Alert(Alert.AlertType.ERROR, "Login Failed").show();
        }

    }
}
