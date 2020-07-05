package TestClass;

import Interface.Utils;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.text.ParseException;

class UtilsTest {

    Utils utils = new Utils();

    @Test
    void isInteger() {
        Assert.assertEquals(true, utils.isInteger("1"));
        Assert.assertEquals(false, utils.isInteger("1.5"));
    }

    @Test
    void isNumeric() {
        Assert.assertEquals(true, utils.isNumeric("1"));
        Assert.assertEquals(false, utils.isNumeric("abc"));
    }

    @Test
    void getDays() throws ParseException {
        Integer expectedDays = 30;
        Assert.assertEquals(expectedDays, utils.getDays("2020-01-30 12:00"));
    }

    @Test
    void getMonth() {
        Integer expectedMonth = 1;
        Assert.assertEquals(expectedMonth, utils.getMonth("2020-01-30 12:00"));
    }

    @Test
    void getYear() {
        Integer expectedYear = 2020;
        Assert.assertEquals(expectedYear, utils.getYear("2020-01-30 12:00"));
    }
}