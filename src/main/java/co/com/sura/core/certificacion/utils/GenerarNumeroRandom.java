package co.com.sura.core.certificacion.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GenerarNumeroRandom {

    private GenerarNumeroRandom() {
    }

    public static int generarNumeroRandom(int maxNumero) {
        Random random = new Random();
        return random.nextInt(maxNumero);
    }

    public static List<Integer> generarNumerosRandom(int maxNumero, int cantidad) {
        List<Integer> generados = new ArrayList<>();
        int contadorNumeros = 0;
        boolean generado;

        if(cantidad>maxNumero){
            cantidad = maxNumero;
        }

        while (contadorNumeros != cantidad) {
            generado = false;
            while (!generado) {
                int numeroPosible = generarNumeroRandom(maxNumero);
                if (!generados.contains(numeroPosible)) {
                    generados.add(numeroPosible);
                    generado = true;
                    contadorNumeros++;
                }
            }
        }
        generados.sort(Collections.reverseOrder());
        return generados;
    }
}