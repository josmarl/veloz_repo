package com.veloz.runner.controller;

import com.veloz.runner.contants.AppConstants;
import com.veloz.runner.dto.Response;
import com.veloz.runner.helper.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import javafx.stage.DirectoryChooser;
import javafx.stage.Popup;
import javafx.stage.Stage;
import org.springframework.stereotype.Component;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Platform;

import org.springframework.beans.factory.annotation.Autowired;

@Component
public class DashboardController implements Initializable {

    @FXML
    Label label;
    @FXML
    TabPane tabApp;
    @FXML
    TextField txtMysql;
    @FXML
    TextField txtVeloz;
    @FXML
    TextField txtFirefox;
    @FXML
    ProgressIndicator loading;

    private Response response;
    private Timer timer;
    int hour = 0;

    @FXML
    protected void handleButtonAction(ActionEvent event) throws Exception {

        timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> {
                    label.setText("");
                    loading.setVisible(true);
                });
                try {
                    runMysql();
                    runVeloz();
//                    runFirefox();
                } catch (Exception ex) {
                    Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
                }

                Platform.runLater(() -> {
                    label.setText("La aplicación está siendo iniciada. Espere unos segundos...");
                    loading.setVisible(false);
                });
            }
        };
        timer.scheduleAtFixedRate(timerTask, 0, 30 * 60 * 1000);
    }

    @FXML
    protected void handleButtonStop(ActionEvent event) throws Exception {
        timer.cancel();
        timer.purge();
        loading.setVisible(false);
        label.setText("Aplicación parada");
    }


    @FXML
    protected void saveConfiguration(ActionEvent event) {

        if (!txtMysql.getText().isEmpty()) {
            if (!txtVeloz.getText().isEmpty()) {
                if (!txtFirefox.getText().isEmpty()) {
                    Utils.writeSettingsProperties(AppConstants.FILE_SETTINGS, txtMysql.getText(), txtVeloz.getText(), txtFirefox.getText());
                } else {
                    openDialog("firefox.exe");
                }
            } else {
                openDialog("veloz-1.0.jar");
            }
        } else {
            openDialog("mysql-start.bat");
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loading.setVisible(false);
        txtMysql.setText(Utils.readProperties(new File(AppConstants.FILE_SETTINGS)).getProperty(AppConstants.PROP_MYSQL));
        txtVeloz.setText(Utils.readProperties(new File(AppConstants.FILE_SETTINGS)).getProperty(AppConstants.PROP_VELOZ));
        txtFirefox.setText(Utils.readProperties(new File(AppConstants.FILE_SETTINGS)).getProperty(AppConstants.PROP_FIREFOX));
    }

    private void openDialog(String campo) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("alerta");
        alert.setHeaderText("¡Ten cuidado!");
        alert.setContentText("Falta ingresar la ruta de : " + campo);
        alert.showAndWait();
    }

    private void runMysql() throws Exception {
        String runMysql = txtMysql.getText();
        String[] cmd = {"cmd.exe", "/c", runMysql};
        Process p = Runtime.getRuntime().exec(cmd);
    }

    private void runVeloz() throws Exception {
        String runVeloz = txtVeloz.getText();
        String[] cmd = {"cmd.exe", "/c", runVeloz};
        Process p = Runtime.getRuntime().exec(cmd);
        Thread.sleep(11000);
        runFirefox();

    }

    private void runFirefox() throws Exception {
        String runFirefox = txtFirefox.getText();
        String[] cmd = {"cmd.exe", "/c", runFirefox, "localhost:8088"};
        Process p = Runtime.getRuntime().exec(cmd);
    }

}
