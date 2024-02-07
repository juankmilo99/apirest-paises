package projects.countriesapi.ejemplos.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AssertNotEqualsTeoria {

    @Test
    public void miTest() {
         Assertions.assertNotEquals(2, 1);
        // assertNotEquals(1, 2);
    }
}
