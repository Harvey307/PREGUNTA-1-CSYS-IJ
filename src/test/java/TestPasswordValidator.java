import org.example.PasswordValidator;
// (O el paquete que estés usando)

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestPasswordValidator {
    @BeforeAll
    public static void setUpClass() {
    }

    @Test
    public void testInstanciarClase() {
        new PasswordValidator();
    }
    @Test
    public void testPasswordNula() {

        Exception excepcion = assertThrows(IllegalArgumentException.class, () -> {
            PasswordValidator.isValid(null);
        });
        assertEquals("La contraseña no puede ser nula o vacía", excepcion.getMessage());
    }

    @Test
    public void testPasswordValida() {

        assertTrue(PasswordValidator.isValid("Secure123!"));
    }

    @Test
    public void testPasswordInvalidaSinMayuscula() {

        assertFalse(PasswordValidator.isValid("secure123!"));
    }

    @Test
    public void testPasswordMuyCorta() {

        assertFalse(PasswordValidator.isValid("nosecura!"));
    }

    @Test
    public void testPasswordConEspacios() {
        // No debe tener espacios
        assertFalse(PasswordValidator.isValid(" 23456789"));
    }

    @Test
    public void testPasswordSoloLetras() {

        assertFalse(PasswordValidator.isValid("abcdefghi"));
    }
}
