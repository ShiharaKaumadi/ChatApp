package lk.ijse.chat.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

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
     Socket socket = null;
     public TextField txtClientMessage;

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
        printWriter.flush();
    }

    public void txtMessegeEnterOnAction(ActionEvent actionEvent) throws IOException {
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
        printWriter.println(txtClientMessage.getText());
        printWriter.flush();
    }
}
