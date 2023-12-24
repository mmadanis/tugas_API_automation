import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithFalse()
    {
        assertNotEquals(1,2);
    }

    @Test
    public void shouldAnswerWithTrue()
    {
        assertEquals(1,1);
    }
}