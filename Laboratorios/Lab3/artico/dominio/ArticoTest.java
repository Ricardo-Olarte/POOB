package dominio;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/**
 * The test class ArticoTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ArticoTest
{
    private Artico artico = null;
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
        artico = artico.demeArtico();
    }
    
    @Test
    public void deberiaCambiarDeArtico(){
        Artico nuevoArtico = null;
        nuevoArtico = nuevoArtico.demeArtico();
        artico.cambieArtico(nuevoArtico);
        assertTrue(nuevoArtico.equals(artico));
    }
    
    @Test
    public void noDeberiaDarNuevoArtico(){
        Artico nuevoArtico = null;
        nuevoArtico = artico.demeArtico();
        assertFalse(!nuevoArtico.equals(artico));
    }
    
    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }
}
