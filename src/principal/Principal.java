package principal;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner consola = new Scanner(System.in);
        ConsultaApi consulta = new ConsultaApi();
        List<String> historial = new ArrayList<>();

        while (true) {
            System.out.println("""
                
                          °°° Bienvenido °°°
                    ¿Qué desea hacer a continuación?
                    1. Realizar una conversión
                    2. Ver historial de conversiones
                    3. Salir""");

            int opcion = consola.nextInt();
            consola.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("""

                            °°°°°°° Conversor de Monedas Alura °°°°°°

                                Ingrese el codigo ISO de la moneda de origen:
                            Peso mexicano - MXN             Dólar estadounidense - USD
                            Euro - EUR                      Peso argentino - ARS
                            Real brasileño - BRL            Peso chileno - CLP
                            Peso colombiano - COP           Sol peruano - PEN
                            Bolívar venezolano - VES        Euro - EUR
                            
                            
                            """);
                    String monedaOrigen = consola.nextLine().toUpperCase();

                    System.out.println("""
                                Ingrese el codigo ISO de la moneda de destino:
                            Peso mexicano - MXN             Dólar estadounidense - USD
                            Euro - EUR                      Peso argentino - ARS
                            Real brasileño - BRL            Peso chileno - CLP
                            Peso colombiano - COP           Sol peruano - PEN
                            Bolívar venezolano - VES        Euro - EUR
                            """);
                    String monedaDestino = consola.nextLine().toUpperCase();

                    String resultado = Conversion.Convertir(monedaOrigen, monedaDestino, consulta, consola);
                    historial.add("Conversión: " + resultado);
                    LocalDateTime time = LocalDateTime.now();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
                    String reg = String.format("Conversion: %s - Fecha y Hora: %s", resultado, time.format(formatter));
                    historial.add(reg);
                    break;

                case 2:
                    if (historial.isEmpty()) {
                        System.out.println("No hay historial de conversiones aún.");
                    } else {
                        System.out.println("Historial de conversiones:");
                        for (String conversion : historial) {
                            System.out.println(conversion);
                        }
                    }
                    break;

                case 3:
                    System.out.println("Saliendo...");
                    return;

                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                    break;
            }
        }

    }
}

/*
ARS - Peso argentino
BOB - Boliviano boliviano
BRL - Real brasileño
CLP - Peso chileno
COP - Peso colombiano
USD - Dólar estadounidense
*/