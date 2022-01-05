package com.pb.ssn.hw15;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ChatClient extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/com/pb/ssn/hw15/ClientForm.fxml"));

        Parent root = loader.load();
        Scene scene = new Scene(root, 755, 628);

        primaryStage.setTitle("JavaFX Чат");
        primaryStage.setScene(scene);

        ChatForm controller = loader.getController();
        primaryStage.setOnCloseRequest(controller.getCloseEventHandler());

        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}
