package lk.ijse.chat.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.chat.util.Navigation;

import java.io.IOException;

public class SignInFormController {
    public AnchorPane signInPane;
    public TextField txtFirstName;
    public TextField txtLastName;
    public PasswordField txtPassword;
    public JFXButton btnSignIn;

    public void btnSignInOnAction(ActionEvent actionEvent) {
    }

    public void SignUpOnClick(MouseEvent mouseEvent) throws IOException {
        Navigation.initUI("SignUpForm.fxml");

    }

    public void forgetPasswordOnClick(MouseEvent mouseEvent) {
    }
}
