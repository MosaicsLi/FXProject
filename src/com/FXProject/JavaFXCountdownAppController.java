package com.FXProject;

import java.io.IOException;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class JavaFXCountdownAppController {

    	private int motherCountdown = 30;
	    private Thread motherThread;

	 	@FXML
	    private Label motherLabel = new Label();
	 	@FXML
	    private void initialize() {
	        // 在初始化時設定 UI 元素的初始狀態
	        motherLabel.setText("母視窗倒數：" + motherCountdown + " 秒");

	        // 在初始化時自動啟動 startMotherCountdown 方法
	        startMotherCountdown();
	    }
	 	@FXML
	    private void startMotherCountdown() {
	        motherThread = new Thread(() -> {
	            while (motherCountdown >= 0) {
	                Platform.runLater(() -> {
	                    motherLabel.setText("母視窗倒數：" + motherCountdown + " 秒");
	                });
	                try {
	                    Thread.sleep(1000);
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }
	                motherCountdown--;
	            }
	            // 顯示母視窗倒數結束訊息
	            Platform.runLater(() -> {
	                motherLabel.setText("母視窗倒數結束！");
	            });
	        });
	        motherThread.start();
	    }
	 	@FXML
	 	private void addMotherCountdown() {
	 		motherCountdown++;
	 		Platform.runLater(() -> {
                motherLabel.setText("母視窗倒數：" + motherCountdown + " 秒");
            });
	 	}
	    // 當按鈕被點擊時調用
	    @FXML
	    private void openChildWindow() {
	        Stage childStage = new Stage();
	        FXMLLoader loader = new FXMLLoader(getClass().getResource("childFXML.fxml"));
	        try {
				Parent root = loader.load();
		        childStage.setTitle("子視窗");
		        childStage.setScene(new Scene(root, 200, 100));
		        childStage.show();
			} catch (IOException e) {
				// TODO 自動產生的 catch 區塊
				e.printStackTrace();
			}
	        
	        childStage.show();
		}
}
