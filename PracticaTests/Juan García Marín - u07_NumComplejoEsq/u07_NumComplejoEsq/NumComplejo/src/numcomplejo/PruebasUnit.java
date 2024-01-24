package numcomplejo;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;



public class PruebasUnit {
    // Flag para borrar el contenido del archivo la primera vez que se escribe en él
    static int appendFlag = 1;
    
    public static void main(String[] args) {
        // Inicializar objetos para las pruebas
        NumComplejo numComplejo1 = new NumComplejo(3.0, 2.0);
        NumComplejo numComplejo2 = new NumComplejo(-1.0, 2.0);

        // Realizar pruebas
        realizarPrueba("Suma", numComplejo1.sumarComplejos(numComplejo1, numComplejo2));
        realizarPrueba("Resta", numComplejo1.restarComplejos(numComplejo1, numComplejo2));
        realizarPrueba("Multiplicación", numComplejo1.multiplicarComplejos(numComplejo1, numComplejo2));
        realizarPrueba("División", numComplejo1.dividirComplejos(numComplejo1, numComplejo2));

        // Intentar división por 0 para probar la excepción
        try {
            realizarPrueba("División (Indeterminado)", numComplejo1.dividirComplejos(numComplejo1, new NumComplejo(0.0, 0.0)));
        } catch (ArithmeticException e) {
            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            System.out.println("Ha ocurrido una excepción aritmética: " + e.getMessage());
            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        }
    }

    private static void realizarPrueba(String operacion, NumComplejo resultado) {
        System.out.println("-------------------------------------------------------------------------------------------------------------");
        System.out.println(operacion + ": numcomplejo." + operacion.toLowerCase() + "Complejos(" + resultado + ")");
        System.out.println(">>> (" + resultado + ")");
        System.out.println("-------------------------------------------------------------------------------------------------------------");
        System.out.println(resultado);
        System.out.println("-------------------------------------------------------------------------------------------------------------");

        // Documentar en un archivo de texto
        documentarResultados(operacion, resultado);
    }

    private static void documentarResultados(String operacion, NumComplejo resultado) {
        if (appendFlag == 1) {
            try (PrintWriter writer = new PrintWriter(new FileWriter("resultados.txt", false))) {
                --appendFlag;
                writer.println("-------------------------------------------------------------------------------------------------------------");
                writer.println(operacion + ": numcomplejo." + operacion.toLowerCase() + "Complejos(" + resultado + ")");
                writer.println(">>> (" + resultado + ")");
                writer.println("-------------------------------------------------------------------------------------------------------------");
                writer.println(resultado);
                writer.println("-------------------------------------------------------------------------------------------------------------");
                writer.println();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try (PrintWriter writer = new PrintWriter(new FileWriter("resultados.txt", true))) {
                --appendFlag;
                writer.println("-------------------------------------------------------------------------------------------------------------");
                writer.println(operacion + ": numcomplejo." + operacion.toLowerCase() + "Complejos(" + resultado + ")");
                writer.println(">>> (" + resultado + ")");
                writer.println("-------------------------------------------------------------------------------------------------------------");
                writer.println(resultado);
                writer.println("-------------------------------------------------------------------------------------------------------------");
                writer.println();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
    }       
        
    
}
