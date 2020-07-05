package Interface;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.concurrent.atomic.AtomicReference;

public class EstouraException {


    public void RaiseException(String message) {

        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERRO!!!");
        alert.setContentText(message);

        alert.showAndWait().ifPresent(rs -> {
            if (rs == ButtonType.OK) {
                System.out.println("Pressed OK.");
            }
        });
    }

    public void RaiseOK(String message) {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Aviso!");
        alert.setContentText(message);

        alert.showAndWait().ifPresent(rs -> {
            if (rs == ButtonType.OK) {
                System.out.println("Pressed OK.");
            }
        });
    }

    public Boolean RaiseConfirmation(String message) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Alerta!");
        alert.setContentText(message);

        AtomicReference<Boolean> confirmation = new AtomicReference<>(false);

        alert.showAndWait().ifPresent(rs -> {
            if (rs == ButtonType.OK) {
                confirmation.set(true);
            } else {
                confirmation.set(false);
            }
        });

        return confirmation.get();
    }


}
