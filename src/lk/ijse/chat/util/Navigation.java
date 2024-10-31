package lk.ijse.chat.util;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

import java.io.IOException;
import java.lang.annotation.Native;

public class Navigation {
    public static AnchorPane anchorPane;
    public static void navigate(Route route, AnchorPane pane) throws IOException {
        Navigation.anchorPane = pane;
        Navigation.anchorPane.getChildren().clear();
        Stage window = (Stage) Navigation.anchorPane.getScene().getWindow();

        switch (route) {
            case WELCOME:
                Navigation.initUI("WelcomeForm.fxml");
                break;
            case SIGNIN:
                Navigation.initUI("SignInForm.fxml");
                break;
            case SIGNUP:
                Navigation.initUI("SignUpForm.fxml");
                break;
            case CHATUI:
                Navigation.initUI("ChatUIForm.fxml");
                break;
            default:
                Notifications notifications = Notifications.create().text("UI Not Found").title("Error").position(Pos.CENTER).hideAfter(Duration.seconds(3));
                notifications.showWarning();
        }
    }
    public static void initUI(String location) throws IOException {
        Navigation.anchorPane.getChildren().add(FXMLLoader.load(Navigation.class.getResource("/lk/ijse/chat/view/"+location)));

    }
}
