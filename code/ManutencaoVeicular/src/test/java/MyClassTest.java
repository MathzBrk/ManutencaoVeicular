import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyClassTest {

    @Test
    public void testAddition() {
        int a = 4;
        int b = 4;
        int expected = 8;
        int result = a + b;
        assertEquals(expected, result, "A soma de 4 e 4 deve ser 8");
    }
}
