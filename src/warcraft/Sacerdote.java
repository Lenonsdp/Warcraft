/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warcraft;

import java.util.ArrayList;
import static warcraft.Humano.noHumano;
import static warcraft.Orc.noOrc;

/**
 *
 * @author Lenon
 */
public class Sacerdote extends Unidades {
    
    private int mana;

    public Sacerdote(Raca obj, int posX, int posY) {
        if (obj.getOuro() > 125) {
            this.setMana(10);
            this.alcance = 10;
            this.armadura = 0;
            this.ataque = 0;
            this.vivo = true;
            this.pontosVitais = 25;
            this.velocidade = 1.0;
            setPosX(posX);
            setPosY(posY);
            System.out.println("Sacerdote gerado");
            obj.unidades.add(this);
            System.out.println(" Posição atual (" + getPosX() + "," + getPosY() + ")");
            obj.setOuro(obj.getOuro() - 125);
            if (obj instanceof Orc) {
                noOrc = noOrc + 1;
            } else {
                noHumano = noHumano + 1;
            }
        } else {
            System.out.println("Sem recursos disponiveis.");
        }
    }

    @Override
    public void ataque(Raca obj, Unidades unidadeAtacada) {
    }

    @Override
    public int getPosX() {
        return this.posX;
    }

    @Override
    public int getPosY() {
        return this.posY;
    }

    @Override
    public void setPosX(int novaposX) {
        this.posX = novaposX;
    }

    @Override
    public void setPosY(int novaposY) {
        this.posY = novaposY;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getMana() {
        return this.mana;
    }

    public void curar(Unidades unidadeCurada) {
        if (unidadeCurada.isVivo()) {
            unidadeCurada.pontosVitais = unidadeCurada.pontosVitaisInicial;
            System.out.println("Unidade Curada " +unidadeCurada.pontosVitais);
            setMana(getMana()-5);
        }
    }
    
    public void reza(){
        setMana(getMana() + 5);
        System.out.println("oooooonnnn 5 de mana gerado, mana total = " + getMana());
    }
    
    public ArrayList<Unidades> verificarCura(Raca raca, Unidades obj) {
        ArrayList<Unidades> possoCurar = new ArrayList<Unidades>();
        if (raca instanceof Orc) {
            for (Unidades item : Warcraft.oo.unidades) {
                if ((obj.getPosX() - item.getPosX()) <= obj.alcance
                        && (obj.getPosY() - item.getPosY()) <= obj.alcance && item.pontosVitais != item.pontosVitaisInicial && item.pontosVitaisInicial == 25) {
                    possoCurar.add(item);
                }
            }
        }
        if (raca instanceof Humano) {
            for (Unidades item : Warcraft.hh.unidades) {
                if ((obj.getPosX() - item.getPosX()) <= obj.alcance
                        && (obj.getPosY() - item.getPosY()) <= obj.alcance && item.pontosVitais != item.pontosVitaisInicial && item.pontosVitaisInicial == 25) {

                    possoCurar.add(item);
                }

            }
        }
    
        return possoCurar;
        
                
    }
}
