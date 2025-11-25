import org.example.PasswordValidator;
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

        assertFalse(PasswordValidator.isValid("Ab1!"));
    }

    @Test
    public void testPasswordConEspacios() {
        // No debe tener espacios
        assertFalse(PasswordValidator.isValid(" 23456789 "));
    }

    @Test
    public void testPasswordSoloLetras() {

        assertFalse(PasswordValidator.isValid("abcdefghi"));
    }

    //test nuevos para completar las ramas logicas
    @Test
    public void testPasswordVacio() {
        // usamos un vacio especificamenta para porbarlo en la clase
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            PasswordValidator.isValid("");
        });
        assertEquals("La contraseña no puede ser nula o vacía", exception.getMessage());
    }

    @Test
    public void testLongitudMuyLarga() {

        String larga = "A".repeat(65) + "1!";
        assertFalse(PasswordValidator.isValid(larga));
    }
    @Test
    public void testFaltaNumero() {

        assertFalse(PasswordValidator.isValid("Abcdefg!"));
    }

    @Test
    public void testFaltaEspecial() {

        assertFalse(PasswordValidator.isValid("Abcdefg1"));
    }


    @Test
    public void testFaltaMinuscula() {

        assertFalse(PasswordValidator.isValid("ABCDEFG1!"));
    }

    @Test
    public void testCaracterNoPermitido() {
       //No coloque el "-" como caracter permitido
        assertFalse(PasswordValidator.isValid("Abcdef1-"));
    }
}
