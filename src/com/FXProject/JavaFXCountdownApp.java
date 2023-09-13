package com.FXProject;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class JavaFXCountdownApp extends Application {
    @Override
    public void start(Stage primaryStage) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("JavaFXCountdownApp.fxml"));
        try {
			Parent root = loader.load();
	        primaryStage.setTitle("母視窗");
	        primaryStage.setScene(new Scene(root, 300, 200));
	        primaryStage.show();
		} catch (IOException e) {
			// TODO 自動產生的 catch 區塊
			e.printStackTrace();
		}
    }

    public static void main(String[] args) {
        launch(args);
    }
}
