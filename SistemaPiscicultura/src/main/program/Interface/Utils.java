package Interface;
<<<<<<< HEAD
import java.text.ParseException;
=======

import Application.EstoqueApp;
import Application.PeixeApp;
import Application.TanqueApp;
import Models.Estoque;
import Models.Peixe;
import Models.Tanque;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
>>>>>>> f9c76c88962873aaeb646bef4cfdd1676d5bfbb4

public class Utils {

    public static Boolean isInteger(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static Boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static Integer getDays(String dateString) throws ParseException {
        return Integer.parseInt(dateString.split("-")[2].split(" ")[0]);
    }

<<<<<<< HEAD
    public static Integer getMonth(String dateString) {
        return Integer.parseInt(dateString.split("-")[1]);
    }
=======
        for (Tanque tanque : lista) {
            for (Peixe p : peixeApp.getAll(Peixe.class)) {
                if (p.id == tanque.getPeixe().id) ;
                peixe = p;
            }
            tanqueList.add(new Tanque(peixe.getEspecie(), tanque.getStatus(), tanque.getVolume()));
        }
>>>>>>> f9c76c88962873aaeb646bef4cfdd1676d5bfbb4

    public static Integer getYear(String dateString) {
        return Integer.parseInt(dateString.split("-")[0]);
    }

}
