package Application;

import org.junit.Assert;
import org.junit.Test;

public class EstoqueAppTest extends EstoqueApp {

    EstoqueApp estoqueApp = new EstoqueApp();

    @Test
    public void testHasDuplicate() {
        Assert.assertEquals(true, estoqueApp.hasDuplicate("Racao Premium"));
        Assert.assertEquals(false, estoqueApp.hasDuplicate("Racao123"));
    }
}