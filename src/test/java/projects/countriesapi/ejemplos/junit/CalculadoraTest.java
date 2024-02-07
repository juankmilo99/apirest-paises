package projects.countriesapi.ejemplos.junit;

import org.junit.jupiter.api.*;

public class CalculadoraTest {
    Calculadora calc;

    @BeforeAll
    public static void primero() {
        System.out.println("primero");
    }

    @AfterAll
    public static void ultimo() {
        System.out.println("ultimo");
    }

    @BeforeEach
    public void instanciaObjeto() {
        calc = new Calculadora();
        System.out.println("@BeforeEach");
    }

    @AfterEach
    public void despuestTest() {
        System.out.println("@AfterEach");
    }

    @Test
    @DisplayName("prueba que ocupa assertEqual")
    @Disabled("esta prueba no se ejecutará")
    public void calculadoraAssertEqualTest() {


        Assertions.assertEquals(2, calc.sumar(1, 1));
        Assertions.assertEquals(3, calc.restar(4, 1));
        Assertions.assertEquals(9, calc.multiplicar(3, 3));
        Assertions.assertEquals(2, calc.dividir(4, 2));

        System.out.println("calculadoraAssertEqualTest");
    }


    @Test
    public void calculadoraTrueFalse() {


        Assertions.assertTrue(calc.sumar(1, 1) == 2);
        Assertions.assertTrue(calc.restar(4, 1) == 3);
        Assertions.assertFalse(calc.multiplicar(3, 3) == 8);
        Assertions.assertFalse(calc.dividir(4, 2) == 1);

        System.out.println("calculadoraTrueFalse");
    }
}
