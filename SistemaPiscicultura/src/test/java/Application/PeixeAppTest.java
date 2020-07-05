package Application;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class PeixeAppTest {
    PeixeApp peixeApp = new PeixeApp();

    @Test
    void testHasDuplicate() {
        Assert.assertEquals(true, peixeApp.hasDuplicate("Dourado"));
        Assert.assertEquals(false, peixeApp.hasDuplicate("Carpa Capim"));
    }
}