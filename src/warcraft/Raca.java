/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warcraft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author lenon.060194
 */
abstract class Raca {

    private int comida, madeira, mana, ouro;
    protected boolean extinta;
    protected String nome = "";
    protected List<Unidades> unidades = new ArrayList<Unidades>();
    protected List<Unidades> unidadesMortas = new ArrayList<Unidades>();
    protected List<Construcoes> construcoes = new ArrayList<Construcoes>();

    public void setComida(int comida) {
        this.comida = comida;
    }

    public void setMadeira(int madeira) {
        this.madeira = madeira;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public void setOuro(int ouro) {
        this.ouro = ouro;
    }

    public int getComida() {
        return comida;
    }

    public int getMadeira() {
        return madeira;
    }

    public int getMana() {
        return mana;
    }

    public int getOuro() {
        return ouro;
    }

    public void getposX() {

    }

    public void getposY() {

    }

    public void consultarRecursos() {
        System.out.println("Seus recursos são:");
        System.out.println(" Comida " + getComida() + "\n Madeira " + getMadeira() + "\n Mana " + getMana() + "\n Ouro " + getOuro());
    }

    public void consultarUnidades() {
        // [ C ] mostrando os "n" contatos da agenda (usando o índice)
        // número de elementos da agenda: método size()

        int o = this.unidades.size();
        for (int i = 0; i < o; i++) {
            System.out.printf("Posição %d- %s\n ", i, this.unidades.get(i).getClass().getSimpleName());
        }
    }

    public void consultarContrucoes() {
        int i;
        // [ C ] mostrando os "n" contatos da agenda (usando o índice)
        // número de elementos da agenda: método size()

        int o = this.construcoes.size();
        for (i = 0; i < o; i++) {
            System.out.printf("Posição %d- %s\n ", i, this.construcoes.get(i).getClass().getSimpleName());
        }
    }

}
