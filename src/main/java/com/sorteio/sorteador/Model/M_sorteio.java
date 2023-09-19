package com.sorteio.sorteador.Model;

public class M_sorteio {

    public int minimo;
    public int maximo;
    public int quantidade;
    public boolean repetir;
    public boolean crescente;

    public M_sorteio(int minimo, int maximo, int quantidade, boolean repetir, boolean crescente) {
        this.minimo = minimo;
        this.maximo = maximo;
        this.quantidade = quantidade;
        this.repetir = repetir;
        this.crescente = crescente;
    }
}
