/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warcraft;

import java.util.ArrayList;


/**
 *
 * @author lenon.060194
 */
public class Orc extends Raca {

    static int noOrc = 0;
    static int noCapacidadeOrc = 0;

    public Orc() {
        setComida(1000);
        setMadeira(1000);
        setMana(1000);
        setOuro(1000);
        this.extinta = false;
    }

    public int populacao() {
        return noOrc;
    }

}
