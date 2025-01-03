package com.aluracursos.principal;

import com.aluracursos.calculos.Conversor;
import com.aluracursos.modelos.Moneda;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        int entrada = 0;
        double valorAConvertir;
        String mensajePrincipal = """
                ***************************************************************************
                Sea bienvenido/a al Conversor de Moneda =]
                ***************************************************************************
                """;
        String mensajeConsola = """
                
                ***************************************************************************
                MENÚ:
                
                1) DÓLAR           => PESO ARGENTINO
                2) PESO ARGENTINO  => DÓLAR
                3) DÓLAR           => REAL BRASILEÑO
                4) REAL BRASILEÑO  => DÓLAR
                5) DÓLAR           => PESO COLOMBIANO
                6) PESO COLOMBIANO => DÓLAR
                7) SALIR
                
                ***************************************************************************
                Elija una opción válida:""";
        String mensajeValorAConvertir = """
                ***************************************************************************
                Ingrese valor que deseas convertir:""";
        System.out.println(mensajePrincipal);
        while (true){
            System.out.println(mensajeConsola);
            Scanner lectura = new Scanner(System.in);
            entrada = lectura.nextInt();
            if(entrada==7){
                break;
            }
            if(entrada>=1 && entrada<=6) {
                System.out.println(mensajeValorAConvertir);
                valorAConvertir = lectura.nextDouble();
                Conversor conversor = new Conversor();
                Moneda moneda = new Moneda(null,null,0);
                switch (entrada) {
                    case 1:
                        moneda = (conversor.calculoMoneda("USD", "ARS"));
                        break;
                    case 2:
                        moneda = (conversor.calculoMoneda("ARS", "USD"));
                        break;
                    case 3:
                        moneda = (conversor.calculoMoneda("USD", "BRL"));
                        break;
                    case 4:
                        moneda = (conversor.calculoMoneda("BRL", "USD"));
                        break;
                    case 5:
                        moneda = (conversor.calculoMoneda("USD", "COP"));
                        break;
                    case 6:
                        moneda = (conversor.calculoMoneda("COP", "USD"));
                        break;
                }
                System.out.println("El valor: " + valorAConvertir + " [" +moneda.base_code() +
                        "], corresponde al valor final de =>>> " + (valorAConvertir* moneda.conversion_rate()) + " [" +
                        moneda.target_code() + "]");
            }else{
                System.out.println("Opción no válida.");
            }
        }
    }
}
