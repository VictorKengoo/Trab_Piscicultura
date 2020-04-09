package main.program.Interface;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.io.PrintWriter;
import java.io.StringWriter;

public class EstouraException {


    public void RaiseException(String message) {

        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("AVISO !!!");
        alert.setContentText(message);

        alert.showAndWait().ifPresent(rs -> {
            if (rs == ButtonType.OK) {
                System.out.println("Pressed OK.");
            }
        });
    }


}
