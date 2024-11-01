import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.PrintWriter;

public class Client extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent load = FXMLLoader.load(this.getClass().getResource("/lk/ijse/chat/view/ChatUIForm.fxml"));
        Scene scene = new Scene(load);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
