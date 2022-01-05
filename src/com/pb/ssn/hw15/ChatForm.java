package com.pb.ssn.hw15;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.WindowEvent;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.ResourceBundle;

public class ChatForm implements Initializable {
    private static final String SERVER_IP = "127.0.0.1";
    private static final int SERVER_PORT = 9876;

    private Socket client;
    private DataOutputStream dos;
    private Thread threadReceive;

    @FXML private Label lblUserName;
    @FXML private TextArea txtChat;
    @FXML private TextField txtInput;

    private final EventHandler<WindowEvent> closeEventHandler = event -> onExit();

    public EventHandler<WindowEvent> getCloseEventHandler() {
        return closeEventHandler;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        TextInputDialog dialog = new TextInputDialog(null);

        dialog.getDialogPane().setMinSize(400, 200);
        dialog.setTitle("Представтесь пожалуйста");
        dialog.setHeaderText("Введите имя");
        dialog.setContentText("Имя:");

        Optional<String> result = dialog.showAndWait();

        if (result.isPresent()) {
            result.ifPresent(name -> this.lblUserName.setText(name));
        } else {
            System.exit(0);
        }

        try {
            client = new Socket(SERVER_IP, SERVER_PORT);
            dos = new DataOutputStream(client.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // ждем сообщений от сервера
        threadReceive = new Thread(new Receive(client, txtChat));
        threadReceive.start();

        // представляемся серверу
        send("");
    }

    @FXML
    private void btnSendAction(ActionEvent event) {
        if (! txtInput.getText().isEmpty()) {
            send(txtInput.getText());
            txtInput.clear();
        }
    }

    @FXML
    private void btnExitAction(ActionEvent event) {
        onExit();
        System.exit(0);
    }

    private void onExit() {
        send("exit");
        try {
            threadReceive.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        closeDataOutputStream();
    }

    private void send(String msg) {
        String fmtMsg = this.lblUserName.getText() + " ("
                        + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")) + "): ";

        if (msg != null && !msg.equals("")){
            if (msg.equals("exit")) {
                fmtMsg = msg;
            } else{
                fmtMsg = fmtMsg + msg;
            }
        } else {
            fmtMsg = this.lblUserName.getText();
        }

        try {
            dos.writeUTF(fmtMsg);
            dos.flush();

            if (fmtMsg.equals("exit")) {
                try {
                    threadReceive.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                closeDataOutputStream();
                System.exit(0);
            }
        } catch (IOException ex) {
            closeDataOutputStream();
            ex.printStackTrace();
        }
    }

    private void closeDataOutputStream() {
        try {
            dos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
