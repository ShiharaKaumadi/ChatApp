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
import java.net.ServerSocket;
import java.net.Socket;

public class ServerFormController {
    public Pane chatPane;
    public Button btnEmoji;
    public TextField txtMessage;
    public Button btnAttachFile;
    public Button btnSend;
    public AnchorPane mainPane;

    Socket accept = null;

    public void initialize(){
        new Thread(()->{
            try{
                ServerSocket socket = new ServerSocket(3000);
                accept = socket.accept();
                System.out.println("Server Started");
                System.out.println("Client Connected");
                InputStreamReader isr = new InputStreamReader(accept.getInputStream());
                BufferedReader bufferedReader = new BufferedReader(isr);
                String string = bufferedReader.readLine();
                System.out.println("Hi "+string);

            }catch(IOException ioException){
                ioException.printStackTrace();
            }
        }).start();
    }



    public void btnEmojiOnAction(ActionEvent actionEvent) {
    }

    public void txtMessegeEnterOnAction(ActionEvent actionEvent) {
    }

    public void btnAttachFileOnAction(ActionEvent actionEvent) {
    }

    public void btnSendOnAction(ActionEvent actionEvent) throws IOException {
        PrintWriter printWriter = new PrintWriter(accept.getOutputStream());
        printWriter.println(txtMessage.getText());
        printWriter.flush();
        String clientMessage = txtMessage.getText();
        if (!clientMessage.isEmpty()){
            Pane pane = new Pane();
            pane.setPadding(new Insets(10,5,5,10));
            pane.setLayoutX(10);
            Text text = new Text(clientMessage);
            TextFlow textFlow = new TextFlow(text);
            textFlow.setStyle("-fx-background-color: #9eda9a;"+"-fx-background-radius: 10px");
            textFlow.setPadding(new Insets(10,10,10,10));
            text.setFill(Color.color(0,0,0));
            pane.getChildren().add(textFlow);
            chatPane.getChildren().add(pane);
            txtMessage.clear();
            pane.setPadding(new Insets(0,0,30,0)); ;// Set horizontal gap

        }
    }
}
