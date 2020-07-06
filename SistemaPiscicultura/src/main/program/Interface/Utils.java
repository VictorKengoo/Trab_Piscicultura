package Interface;
import java.text.ParseException;

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

    public static Integer getMonth(String dateString) {
        return Integer.parseInt(dateString.split("-")[1]);
    }

    public static Integer getYear(String dateString) {
        return Integer.parseInt(dateString.split("-")[0]);
    }

}
