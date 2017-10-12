import org.junit.Assert;
import org.junit.Test;

public class TestasTest {
    @Test
    public void testArLyginis() throws Exception {
        boolean rezultatas = Testas.arLyginis(4);

        Assert.assertEquals(true, rezultatas);
    }

    @Test
    public void testArNeraLyginis() throws Exception {
        boolean rezultatas = Testas.arLyginis(5);

        Assert.assertEquals(false, rezultatas);
    }
}