import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputManagerTest {

    @Test
    public void characterInput() {
        String testInput = "1";
        ByteArrayInputStream in = new ByteArrayInputStream(testInput.getBytes());
        assertEquals(testInput, InputManager.getInput(in, ""));
    }
}
