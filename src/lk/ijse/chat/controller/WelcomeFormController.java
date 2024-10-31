package lk.ijse.chat.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.chat.util.Navigation;

import java.io.IOException;

public class WelcomeFormController {
    public AnchorPane welcomePane;
    public JFXButton btnSignIn;
    public JFXButton btnSignUp;

    public void btnSignInOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.initUI("SignInForm.fxml");

    }

    public void btnSignUpOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.initUI("SignUpForm.fxml");
    }
}
