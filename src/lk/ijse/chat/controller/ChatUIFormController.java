package lk.ijse.chat.controller;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatUIFormController {
    public Pane chatPane;
    public TextField txtMessage;
    public Button btnAttachFile;
    public Button btnEmoji;
    public AnchorPane mainPane;
    Socket socket = null;


     public void initialize() throws IOException {
         new Thread(()->{
             try {
                 socket = new Socket("localhost",3000);
                 InputStreamReader ins = new InputStreamReader(socket.getInputStream());
                 BufferedReader bufferedReader = new BufferedReader(ins);
                 String string = bufferedReader.readLine();
                 System.out.println(string);

             } catch (IOException e) {
                 throw new RuntimeException(e);
             }
         }).start();
     }

    public void btnEmojiOnAction(ActionEvent actionEvent) {
    }

    public void btnAttachFileOnAction(ActionEvent actionEvent) {
    }

    public void btnSendOnAction(ActionEvent actionEvent) throws IOException {
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
        printWriter.println(txtMessage.getText());
        String clientMessage = txtMessage.getText();
        if(!clientMessage.isEmpty()){
            Pane pane = new Pane();
            pane.setPadding(new Insets(10,5,5,10));
            pane.setLayoutX(320);
            Text text = new Text(clientMessage);
            TextFlow textFlow = new TextFlow(text);
            textFlow.setStyle("-fx-background-color: #da9e7d;"+"-fx-background-radius: 10px");
            textFlow.setPadding(new Insets(10,10,10,10));
            text.setFill(Color.color(1,1,1));
            pane.getChildren().add(textFlow);
            chatPane.getChildren().add(pane);
            txtMessage.clear();
            pane.setPadding(new Insets(0,0,30,0)); ;// Set horizontal gap
        }
    }

    public void txtMessegeEnterOnAction(ActionEvent actionEvent) throws IOException {
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
        printWriter.println(txtMessage.getText());
        printWriter.flush();
        String clientMessage = txtMessage.getText();
        if(!clientMessage.isEmpty()){
            Pane pane = new Pane();
            pane.setPadding(new Insets(10,5,5,10));
            pane.setLayoutX(320);
            Text text = new Text(clientMessage);
            TextFlow textFlow = new TextFlow(text);
            textFlow.setStyle("-fx-background-color: #fcb38c;"+"-fx-background-radius: 10px");
            textFlow.setPadding(new Insets(10,10,10,10));
            text.setFill(Color.color(1,1,1));
            pane.getChildren().add(textFlow);
            chatPane.getChildren().add(pane);
            txtMessage.clear();
            pane.setPadding(new Insets(0,0,30,0)); ;// Set horizontal gap
        }
    }
}
