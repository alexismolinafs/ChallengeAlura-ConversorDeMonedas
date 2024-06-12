package principal;

import java.util.Scanner;

import model.Monedas;

public class Conversion {
   public static String Convertir(String monedaBaseTxt, String monedaCambioTxt, ConsultaApi consulta, Scanner consola){
    double monto;
    double montoFinal;

    Monedas monedas = consulta.SearchCoins(monedaBaseTxt, monedaCambioTxt);
    System.out.println("La tasa de conversion de esta moneda es de:\n1 " + monedaBaseTxt + " = " + monedas.conversion_rate() + " " + monedaCambioTxt);
    System.out.println("Cantidad de: " + monedaBaseTxt);
    monto = Double.parseDouble(consola.nextLine());
    montoFinal = monto * monedas.conversion_rate();
    String resultado = monto + " " + monedaBaseTxt + " equivale a " + montoFinal + " " + monedaCambioTxt;
    System.out.println("\n" + resultado);
    return resultado;
   }
}
