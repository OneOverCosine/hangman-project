import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputManagerTest {

    @Test
    public void characterInput() {
        String testInput = "1";
        ByteArrayInputStream input = new ByteArrayInputStream(testInput.getBytes());
        assertEquals(testInput, InputManager.getInput(input, ""));
    }

    @Test
    public void singleCharacterValidation() {
        String testInput = "*";
        ByteArrayInputStream input = new ByteArrayInputStream(testInput.getBytes());
        assertEquals("Invalid input", InputManager.getInput(input, ""));
    }

    @Test
    public void emptyInputIsInvalid() {
        ByteArrayInputStream input = new ByteArrayInputStream("".getBytes());
        assertEquals("Invalid input", InputManager.getInput(input, ""));
    }
}
