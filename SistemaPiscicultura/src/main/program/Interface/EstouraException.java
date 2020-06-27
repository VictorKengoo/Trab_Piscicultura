package Interface;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

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
//comentando este comentario
    public void RaiseOK(String message) {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Aviso! =)");
        alert.setContentText(message);

        alert.showAndWait().ifPresent(rs -> {
            if (rs == ButtonType.OK) {
                System.out.println("Pressed OK.");
            }
        });
    }


}
