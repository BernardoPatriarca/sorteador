package com.sorteio.sorteador.Service;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class S_sorteio {
    public static int[] sortear(int minimo, int maximo, int quantidade, boolean crescente, boolean repetir) {
        int[] vect = new int[quantidade];
        Random rand = new Random();
        int resultado;

        for (int i = 0; i < quantidade; i++) {
            if (crescente == true) {
                resultado = rand.nextInt(maximo - minimo + 1) + minimo;
                vect[i] = resultado;
            } else {
                boolean encontrado;
                do {
                    resultado = rand.nextInt(maximo - minimo + 1) + minimo;
                    int finalResultado = resultado;
                    encontrado = Arrays.stream(vect, 0, i).anyMatch(num -> num == finalResultado);
                } while (encontrado);
                vect[i] = resultado;
            }
        }

        if (repetir == true) {
            Arrays.sort(vect);
        }

        return vect;
    }
}
