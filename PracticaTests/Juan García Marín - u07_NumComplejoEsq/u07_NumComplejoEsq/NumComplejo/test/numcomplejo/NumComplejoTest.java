/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numcomplejo;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class NumComplejoTest {
    private NumComplejo numComplejo1;
    private NumComplejo numComplejo2;

    @Before
    public void setUp() {
        // Inicializar objetos antes de cada prueba
        System.out.println("*-*-*-*-*-*-*");
        System.out.println("   Before");
        System.out.println("*-*-*-*-*-*-*\n");

        numComplejo1 = new NumComplejo(2.0, 3.0);  // Número complejo: 2 + 3i
        numComplejo2 = new NumComplejo(1.0, 2.0);  // Número complejo: 1 + 2i
    }

    @Test
    public void testSumar() {
        // Suma de dos números complejos: (2 + 3i) + (1 + 2i) = 3 + 5i
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        System.out.println("   testSumar: public NumComplejo sumarComplejos (NumComplejo c1, NumComplejo c2)");
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");

        NumComplejo resultado = numComplejo1.sumarComplejos(numComplejo1, numComplejo2);
        assertEquals(3.0, resultado.getpReal(), 0.0001);
        assertEquals(5.0, resultado.getpImaginaria(), 0.0001);
    }

    @Test
    public void testRestar() {
        // Resta de dos números complejos: (2 + 3i) - (1 + 2i) = 1 + 1i
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        System.out.println("   testRestar: public NumComplejo restarComplejos (NumComplejo c1, NumComplejo c2)");
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");

        NumComplejo resultado = numComplejo1.restarComplejos(numComplejo1, numComplejo2);
        assertEquals(1.0, resultado.getpReal(), 0.0001);
        assertEquals(1.0, resultado.getpImaginaria(), 0.0001);        
    }

    @Test
    public void testMultiplicar() {
        // Multiplicación de dos números complejos: (2 + 3i) * (1 + 2i) = -4 + 7i
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        System.out.println("   testMultiplicar: public NumComplejo multiplicarComplejos (NumComplejo c1, NumComplejo c2)");
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");

        NumComplejo resultado = numComplejo1.multiplicarComplejos(numComplejo1, numComplejo2);
        assertEquals(-4.0, resultado.getpReal(), 0.0001);
        assertEquals(7.0, resultado.getpImaginaria(), 0.0001);
    }

    @Test
    public void testDividir() {
        // División de dos números complejos: (2 + 3i) / (1 + 2i) = 1.6 - 0.2i
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        System.out.println("   testDividir: public NumComplejo dividirComplejos (NumComplejo c1, NumComplejo c2)");
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");

        NumComplejo resultado = numComplejo1.dividirComplejos(numComplejo1, numComplejo2);
        assertEquals(1.6, resultado.getpReal(), 0.0001);
        assertEquals(-0.2, resultado.getpImaginaria(), 0.0001);
    }
    
    @Test(expected = ArithmeticException.class)
    public void testIndeterminado() {
        // Intento de dividir por 0 (indeterminado)
        // Se espera una excepción de tipo ArithmeticException
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        System.out.println("   testDividir (Indeterminado): public NumComplejo dividirComplejos (NumComplejo c1, NumComplejo c2)");
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");

        numComplejo1.dividirComplejos(numComplejo1, new NumComplejo(0.0, 0.0));
    }
}